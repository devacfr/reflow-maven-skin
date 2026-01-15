/*
* Copyright 2012-2025 Christophe Friederich
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.devacfr.maven.skins.reflow.context;

import com.google.common.base.CaseFormat;

public enum PositionType {

  none,
  left,
  right,
  navigationTop,
  navigationBottom,
  bottom;

  @Override
  public String toString() {
    return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_HYPHEN, this.name());
  }

  public static PositionType valueOfHyphen(String value) {
    String e = CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, value);
    return PositionType.valueOf(PositionType.class, e);
  }
}
