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

source ${dir}/setenv.sh

MAVEN_CMD="mvn"

for i in "$@"
do
case $i in
    -d|--docker)
    MAVEN_CMD="${ROOT_PATH}/mvnd"
    shift
    ;;
    -w|--wrapper)
    MAVEN_CMD="${ROOT_PATH}/mvnw"
    shift
    ;;
    *)
    # unknown option
    ;;
esac
done

${MAVEN_CMD} clean clover:instrument install clover:aggregate site site:stage $@
