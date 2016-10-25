#!/bin/bash

echo "Build"
mvn clean install

echo "Run"
java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=9000 -jar ./target/dependency/webapp-runner.jar ./target/mimetypeTest.war