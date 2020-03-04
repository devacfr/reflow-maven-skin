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

set -euo pipefail

get_mvn_property() {
    mvn -N -f "${ROOT_PATH}/pom.xml" -q exec:exec -Dexec.executable=echo -Dexec.args="\${$@}"
}


get_project_version() {
    get_mvn_property "project.version"
}

artifact_exists() {
	local group="$1"
    local artifact="$2"
    local version="$3"
    local classifier="${4-}"
    local extension="${5:-jar}"

    local artifactId="$group:$artifact:$version:$extension${classifier:+":$classifier"}"
    local resource="$(tr . / <<<"$group")/$artifact/$version/$artifact-$version${classifier:+"-$classifier"}.$extension"
    local output

    log "--- Checking whether $artifactId already exists on packages.atlassian.com..."

    if ! output="$(mvn -e -N org.codehaus.mojo:wagon-maven-plugin:2.0.0:exist -f "${ROOT_PATH}/pom.xml" -Dwagon.serverId="${MAVEN_REPO_ID}" -Dwagon.url="${MAVEN_REPO_URL}" -Dwagon.resource="$resource")"; then
        log "!!! Failed to execute maven command:"
        log "$output"
        exit 1
    fi

    if grep "$resource exists." <<<"$output" >/dev/null; then
        log ">>> $artifactId already exists"
    else
        log ">>> $artifactId does not exist"
        return 1
    fi
}


deploy_file() {
    local file="$1"
    local group="$2"
    local artifact="$3"
    local version="$4"
    local classifier="${5-}"
    local extension="${6:-jar}"

    log "=== Deploying file '$(basename "$file")'"

    # The 'restricted' repository on artifactory doesn't allow overwriting of existing pom - just skip it in that case
    local generate_pom=true
    if artifact_exists "$group" "$artifact" "$version" "" "pom" 2>/dev/null; then
        log '--- Skipping publishing of POM since it already exists'
        generate_pom=false
    fi

    mvn -N -e deploy:deploy-file -Durl="${MAVEN_REPO_URL}" \
                              -DrepositoryId="${MAVEN_REPO_ID}" \
                              -Dfile="$file" \
                              -DgroupId="$group" \
                              -DartifactId="$artifact" \
                              -Dversion="$version" \
                              ${classifier:+"-Dclassifier=$classifier"} \
                              -Dpackaging="${extension}" \
                              -DgeneratePom="$generate_pom"
}

install_file() {
    local file="$1"
    local group="$2"
    local artifact="$3"
    local version="$4"
    local classifier="${5-}"
    local extension="${6:-jar}"

    log "=== Installing file '$(basename "$file")'"

    mvn -N -e install:install-file \
                              -Dfile="$file" \
                              -DgroupId="$group" \
                              -DartifactId="$artifact" \
                              -Dversion="$version" \
                              ${classifier:+"-Dclassifier=$classifier"} \
                              -Dpackaging="${extension}"
}

