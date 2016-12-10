# Theo
Theo is a plugin that provides annotations for each 'dangerous android permission'.

Use
--------
Use annotations to ask for permissions

```java
@Camera
public void cameraMethod() {
    // Do something
}

@Permissions({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CAMERA})
public void permissionsMethod(){
    // Do something
}
```

For the complete list of annotation see the `MainActivity` in `theo-example`

Theo also provide methods to check if permissions are granted or not

```java
Theo.checkPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION);
Theo.checkPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION, false);
Theo.checkPermission(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CAMERA});
Theo.checkPermission(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CAMERA}, false);

if(Theo.checkPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION);){
    // do something
}
```
This method is returning a boolean and can be used directly inside a if().
The last boolean is used to enable or disable the snack bar that is shown if a permission is not granted.

![1]

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
    classpath 'com.xavierbauquet.theo:theo-plugin:1.3.0'
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

[1]: ./gif/snackbar.gif