package com.lv.plugins.weblogic

import com.lv.plugins.weblogic.tasks.WLDeployTask
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by Sion Williams on 14/08/2014.
 */
class WeblogicPlugin implements Plugin<Project> {
    static final WL_DEPLOY_EXTENSION = 'weblogic'
    static final WL_DEPLOY_TASK_NAME = 'wlDeploy'
    static final WL_UNDEPLOY_TASK_NAME = 'wlUndeploy'
    static final WL_CANCEL_TASK_NAME = 'wlCancel'
    static final WL_REDEPLOY_TASK_NAME = 'wlRedeploy'
    static final WL_DISTRIBUTE_TASK_NAME = 'wlDistribute'
    static final WL_START_TASK_NAME = 'wlStart'
    static final WL_STOP_TASK_NAME = 'wlStop'


    @Override
    void apply(Project project){

        // users to provide the dependency via the weblogic custom configuration
        project.configurations { weblogic }

        project.extensions.create( WL_DEPLOY_EXTENSION, WLDeployPluginExtension )

        addTasks( project )
    }

    /**
     * Add tasks to the plugin
     * @param project the target Gradle project
     */
    void addTasks( Project project ){
        def extension = project.extensions.findByName( WL_DEPLOY_EXTENSION )
        project.tasks.withType( WLDeployTask ){
            conventionMapping.adminurl = { extension.adminurl }
            conventionMapping.appversion = { extension.appversion }
            conventionMapping.deploymentName = { extension.deploymentName }
            conventionMapping.source = { extension.source }
            conventionMapping.targets = { extension.targets }
            conventionMapping.user = { extension.user }
            conventionMapping.password = { extension.password }
            conventionMapping.debug = { extension.debug }
            conventionMapping.verbose = { extension.verbose }
            conventionMapping.remote = { extension.remote }
            conventionMapping.upload = { extension.upload }

        }

        project.task( WL_DEPLOY_TASK_NAME, type: WLDeployTask ){
            action = 'deploy'
            description = 'Deploys or redeploys an application or module.'
        }

        project.task( WL_UNDEPLOY_TASK_NAME, type: WLDeployTask ){
            action = 'undeploy'
            description = 'Stops the deployment unit and removes staged files from target servers.'
        }

        project.task( WL_CANCEL_TASK_NAME, type: WLDeployTask ){
            action = 'cancel'
            description = 'Attempt to cancel a running deployment task.'
        }

        project.task( WL_REDEPLOY_TASK_NAME, type: WLDeployTask ){
            action = 'redeploy'
            description = 'Redeploys a running application or part of a running application.'
        }

        project.task( WL_DISTRIBUTE_TASK_NAME, type: WLDeployTask ){
            action = 'distribute'
            description = 'Prepares deployment files for deployment by copying deployment files to target servers and validating them.'
        }

        project.task( WL_START_TASK_NAME, type: WLDeployTask ){
            action = 'start'
            description = 'Makes a stopped (inactive) application available to clients on target servers.'
        }

        project.task( WL_STOP_TASK_NAME, type: WLDeployTask ){
            action = 'stop'
            description = 'Makes an application inactive and unavailable administration and client requests.'
        }
    }
}
