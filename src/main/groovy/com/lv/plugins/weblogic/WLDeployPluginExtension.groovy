package com.lv.plugins.weblogic

/**
 * Created by Sion Williams on 27/08/2014.
 */
class WLDeployPluginExtension {
    String action = 'deploy'
    String adminurl = 't3://localhost:7001'
    String appversion
    String deploymentName
    String source
    String targets
    String user = 'weblogic'
    String password = 'welcome1'
    Boolean debug = false
    Boolean verbose = false
    Boolean remote = false
    Boolean upload = false
}
