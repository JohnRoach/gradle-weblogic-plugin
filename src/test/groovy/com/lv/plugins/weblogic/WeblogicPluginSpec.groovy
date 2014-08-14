package com.lv.plugins.weblogic

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import spock.lang.Specification

/**
 * Created by Sion Williams on 14/08/2014.
 */
class WeblogicPluginSpec extends Specification {
    Project project

    void setup() {
        project = ProjectBuilder.builder().build()
    }

    void 'Applies plugins and confirms tasks are added'(){
        expect: 'no plugin tasks available in the project initially'
            project.tasks.findByName( WeblogicPlugin.WLDEPLOY_TASK_NAME ) == null

        when: 'I explicitly add the plugin'
            project.apply plugin: 'com.lv.weblogic'

        then:
            project.tasks.findByName( WeblogicPlugin.WLDEPLOY_TASK_NAME )
    }
}
