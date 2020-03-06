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


function container_exists {
    local name=$1
    echo "$(docker ps -a -f name=^/${name}$ --format "{{.Names}}" | tr -d '[:space:]')"
}

function container_running {
    local name=$1
    echo "$(docker container ls -f name=^/${name}$ --format "{{.Names}}" | tr -d '[:space:]')"
}

function image_exists {
    local image_name=$1
    echo "$(docker image ls --format "{{.Repository}}" | grep ${image_name} | tr -d '[:space:]')"
}

function volume_exists {
    local volume_name=$1
    echo "$(docker volume ls -q -f name=${volume_name} | tr -d '[:space:]')"
}

function initial_docker_options {
  local dockerOptions=""
  # use remote access if docker host inquire
  if [[ ! -z "${DOCKER_HOST:-}" ]]; then
      dockerOptions="-h ${DOCKER_HOST}"
  fi
  export DOCKER_OPTIONS=${dockerOptions}
}

function remove_image {
  if [[ -n "$( docker images -q  $1 )" ]]; then
    docker ${DOCKER_HOST} rmi $1
  fi
}

