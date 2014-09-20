package com.lv.plugins.weblogic.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.TaskAction

/**
 * Custom Gradle task wrapping the Ant WLDeploy task
 * http://docs.oracle.com/cd/E11035_01/wls100/programming/wldeploy.html
 *
 * @author Sion Williams
 */
class WLDeployTask extends DefaultTask {

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
    Boolean debug = false


    /**
     * Specifies whether wldeploy displays verbose output messages.
     */
    @Input
    @Optional
    Boolean verbose = false

    /**
     * Specifies whether the server is located on a different machine.
     */
    @Input
    @Optional
    Boolean remote = false

    /**
     * Specifies whether the source file(s) are copied to the Administration Server’s upload directory prior to deployment.
     */
    @Input
    @Optional
    Boolean upload = false


    @TaskAction
    void runWlDeployCommand() {
        logger.quiet "*****************************************"
        logger.quiet "Application name : ${getDeploymentName()}"
        logger.quiet " action : ${getAction()}"
        logger.quiet " source : ${getSource()}"
        logger.quiet " adminurl : ${getAdminurl()}"
        logger.quiet " targets : ${getTargets()}"
        logger.quiet "*****************************************"

        ant.taskdef( name: 'wldeploy',
                classname: 'weblogic.ant.taskdefs.management.WLDeploy',
                classpath: project.configurations.weblogic.asPath )
        ant.wldeploy(action: getAction(),
                source: getSource(),
                name: getDeploymentName(),
                adminurl: getAdminurl(),
                user: getUser(),
                password: getPassword(),
                targets: getTargets(),
                verbose: getVerbose(),
                debug: getDebug(),
                remote: getRemote(),
                upload: getUpload()
        )
    }
}
