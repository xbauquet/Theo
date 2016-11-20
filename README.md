# Theo
Theo is a plugin that provide annotations for each 'dangerous android permission'.

Use
--------
```java
@Camera
public void cameraMethod() {
    // Do something
}
```
For the complete list of annotation see the `MainActivity` in `theo-example`

Gradle
--------

```groovy
buildscript {
  repositories {
    maven {
            url  "http://xavierbauquet.bintray.com/android"
    }
  }

  dependencies {
    classpath 'com.xavierbauquet.theo:theo-plugin:1.1.2'
  }
}

apply plugin: 'com.android.application'
apply plugin: 'com.xavierbauquet.theo'
```


License
--------

    Copyright 2016 Xavier Bauquet

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
