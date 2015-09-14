package com.lv.plugins.weblogic.tasks

import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.testfixtures.ProjectBuilder
import spock.lang.Specification

/**
 * @author Sion Williams
 */
class WLUndeployTaskSpec extends Specification {
    Project project

    void setup() {
        project = ProjectBuilder.builder().build()
    }

    def "Adds WLUndeployTask task"() {
        expect:
            project.tasks.findByName( 'wlTest' ) == null

        when:
            project.task( 'wlTest', type: WLUndeployTask ) {
                adminurl = 'test'
                deploymentName = 'test'
                source = 'test'
                targets = 'test'
                user = 'test'
                password = 'test'
                appversion = '1.0'
            }

        then:
            Task task = project.tasks.findByName( 'wlTest' )
            task.group == 'Weblogic'
            task.description == 'Stops the deployment unit and removes staged files from target servers.'
            task.adminurl == 'test'
            task.deploymentName == 'test'
            task.source == 'test'
            task.targets == 'test'
            task.user == 'test'
            task.password == 'test'
            task.appversion == '1.0'
    }

}
