#!/bin/bash
#
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements. See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership. The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License. You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied. See the License for the
# specific language governing permissions and limitations
# under the License.
#

set +x -euo pipefail

dir="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"

source "${dir}/setenv.sh"

# default maven command
maven_cmd="mvn"
maven_profiles=""
maven_args=""
skipTests=false


for i in "$@"
do
case $i in
    -d|--docker)
    maven_cmd="${ROOT_PATH}/mvnd"
    shift
    ;;
    -w|--wrapper)
    maven_cmd="${ROOT_PATH}/mvnw"
    shift
    ;;
    -s|--skip-tests)
    maven_profiles="$( add_mvn_profile "${maven_profiles}" "skipTests" )"
    maven_args="${maven_args} -Dmaven.javadoc.skip=true"
    skipTests=true
    shift
    ;;
    -p|--report)
    maven_profiles="$( add_mvn_profile "${maven_profiles}" "reporting" )"
    shift
    ;;
    -X|--debug)
    maven_args="${maven_args} --debug"
    shift
    ;;
    *)
    # unknown option
    ;;
esac
done

if [ "${skipTests}" = true ] ; then
    echo "Skipping tests during site generation."
else
    # enable clover report
    maven_profiles="$( add_mvn_profile "${maven_profiles}" "clover.report" )"
    echo "Tests will be executed during site generation."
fi

echo "Generating site with command: ${maven_cmd} site site:stage ${maven_profiles} ${maven_args} $@"
${maven_cmd} clean install ${maven_profiles} ${maven_args}
${maven_cmd} site site:stage "$@" ${maven_profiles} ${maven_args}
