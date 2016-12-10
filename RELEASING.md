Release Process
===============

 1. Update version number in `gradle.properties` file.
 2. Update version number in `TheoPlugin.groovy` file.
 3. Update version number in `README.md` file.
 4. Comment `classpath "com.xavierbauquet.theo:theo-plugin:${THEO_VERSION}"` and `apply plugin: 'com.xavierbauquet.theo'` in `theo-example/build.gradle` file.
 5. In the terminal `./gradlew install`.
 6. Uncomment lines in `theo-example/build.gradle` file.
 7. Play tests in `theo-example` app.
 8. Commit and Push
 9. Tag: `git tag <version>` and Push: `git push origin --tags`
 10. Publish on bintray