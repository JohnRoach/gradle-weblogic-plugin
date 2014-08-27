package com.lv.plugins.weblogic.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.TaskAction

/**
 * Custom Gradle task wrapping the Ant WLDeploy task
 * @author Sion Williams
 */
class WLDeployTask extends DefaultTask{

    /**
     * The deployment action to perform.
     * Valid values are deploy, cancel, undeploy, redeploy, distribute, start, and stop.
     */
    @Input
    String action = 'deploy'


    /**
     * The URL of the Administration Server.
     */
    @Input
    String adminurl = 't3://localhost:7001'


    /**
     * The version identifier of the deployed application.
     */
    @Input
    @Optional
    String appversion


    /**
     * The deployment name for the deployed application.
     */
    @Input
    String deploymentName = project.name


    /**
     * The archive file or exploded directory to deploy.
     */
    @Input
    String source


    /**
     * The list of target servers to which the application is deployed.
     */
    @Input
    String targets


    /**
     * The administrative username.
     */
    @Input
    String user = 'weblogic'


    /**
     * The administrative password.
     */
    @Input
    String password = 'welcome1'

    /**
     * Enable wldeploy debugging messages.
     */
    @Input
    @Optional
    boolean debug = false


    /**
     * Specifies whether wldeploy displays verbose output messages.
     */
    @Input
    @Optional
    boolean verbose = false

    @TaskAction
    void runWlDeployCommand(){
        ant.taskdef( name: 'wldeploy',
                classname: 'weblogic.ant.taskdefs.management.WLDeploy',
                classpath: project.configurations.weblogic.asPath )

        ant.wldeploy( action: getAction(), verbose: getVerbose(), debug: getDebug(),
                name: getDeploymentName(), source: getSource(),
                user: getUser(), password: getPassword(),
                adminurl: getAdminurl(), targets: getTargets())
    }
}
