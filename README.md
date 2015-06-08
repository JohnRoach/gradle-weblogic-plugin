# Gradle Weblogic plugin

This plugin is a direct port from the Ant equivalents found at [wldeploy Ant Task Reference](http://docs.oracle.com/cd/E13222_01/wls/docs92/programming/wldeploy.html)

## Latest Version
[ ![Download](https://api.bintray.com/packages/lv/gradle-plugins/gradle-weblogic-plugin/images/download.svg) ](https://bintray.com/lv/gradle-plugins/gradle-weblogic-plugin/_latestVersion)

## Build Status

[![Build Status](https://travis-ci.org/Liverpool-Victoria/gradle-weblogic-plugin.svg?branch=master)](https://travis-ci.org/Liverpool-Victoria/gradle-weblogic-plugin)

## Waffle Board (issues)

[![Stories in Ready](https://badge.waffle.io/Liverpool-Victoria/gradle-weblogic-plugin.svg?label=ready&title=Ready)](http://waffle.io/Liverpool-Victoria/gradle-weblogic-plugin)

## Usage

To use the plugin, configure your `build.gradle` script and add the plugin:
```groovy
    buildscript {
        repositories {
            mavenCentral()
            maven { url 'http://dl.bintray.com/lv/gradle-plugins/' }
        }
        dependencies {
            classpath 'com.lv.plugins:gradle-weblogic-plugin:<VERSION>'
        }
    }
    apply plugin: 'com.lv.weblogic'
    
    dependencies {
        weblogic files('/path/to/wlfullclient.jar')
    }
```
The weblogic configuration is added by the plugin, but you will need to specify where the wlfullclient jar is located.


# Tasks
The plugin adds 6 tasks to your project; `wlDeploy`, `wlUndeploy`, `wlCancel`, `wlRedeploy`, `wlStart` and `wlStop`.

## Configuration

### build.gradle
```groovy
    weblogic {
            adminurl = 't3://localhost:7001'
            deploymentName = 'myUberApp'
            source = "${projectDir}/dist/demo.war"
            targets = 'managed01, managed02'
            user = 'weblogic'
            password = 'secret'
            debug = false
            verbose = false
            upload = true
            remote = false
    }
```

## Task properties
### generic properties

* `adminurl` : The URL of the Administration Server. Default 't3://localhost:7001'.
* `appversion` : The version identifier of the deployed application.
* `deploymentName` : The deployment name for the deployed application.
* `source` : The archive file or exploded directory to deploy.
* `targets` : The list of target servers to which the application is deployed. Default 'AdminServer'
* `user` : The administrative username.
* `password` : The administrative password.
* `debug` : Enable wldeploy debugging messages. Default 'false'.
* `verbose` : Specifies whether wldeploy displays verbose output messages. Default 'false'. 
* `remote` : Specifies whether the server is located on a different machine. Default 'false'.
* `upload` : Specifies whether the source file(s) are copied to the Administration Server’s upload directory prior to deployment. Default 'false'.
