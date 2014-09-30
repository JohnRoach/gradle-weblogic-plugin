package com.lv.plugins.weblogic.tasks

import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.testfixtures.ProjectBuilder
import spock.lang.Specification

/**
 * Created by Sion Williams on 30/09/2014.
 */
class WLDeployTaskSpec extends Specification {
    Project project

    void setup() {
        project = ProjectBuilder.builder().build()
    }

    def "Adds WLDeploy task"() {
        expect:
            project.tasks.findByName( 'wlTest' ) == null

        when:
            project.task( 'wlTest', type: WLDeployTask ) {
                adminurl = 'test'
                appversion = 'test'
                deploymentName = 'test'
                source = 'test'
                targets = 'test'
                user = 'test'
                password = 'test'
                debug = false
                verbose = false
                remote = false
                upload = false
            }

        then:
            Task task = project.tasks.findByName( 'wlTest' )
            task.adminurl == 'test'
            task.appversion == 'test'
            task.deploymentName == 'test'
            task.source == 'test'
            task.targets == 'test'
            task.user == 'test'
            task.password == 'test'
            task.debug == false
            task.verbose == false
            task.remote == false
            task.upload == false
    }

}
