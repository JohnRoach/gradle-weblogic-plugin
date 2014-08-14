package com.lv.plugins.weblogic

import com.lv.plugins.weblogic.tasks.WLDeployTask
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by Sion Williams on 14/08/2014.
 */
class WeblogicPlugin implements Plugin<Project> {
    static final WLDEPLOY_TASK_NAME = 'wlDeploy'

    @Override
    void apply(Project project){

        project.configurations { weblogic }

        addTasks( project )
    }

    /**
     * Add tasks to the plugin
     * @param project the target Gradle project
     */
    void addTasks( Project project ){
        project.task( WLDEPLOY_TASK_NAME, type: WLDeployTask )
    }
}
