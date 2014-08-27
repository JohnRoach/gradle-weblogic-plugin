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
    String password = 'password'
    boolean debug = false
    boolean verbose = false
}
