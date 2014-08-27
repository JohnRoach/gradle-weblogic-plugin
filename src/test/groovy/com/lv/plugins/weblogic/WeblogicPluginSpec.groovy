package com.lv.plugins.weblogic

import com.lv.plugins.weblogic.tasks.WLDeployTask
import nebula.test.PluginProjectSpec
import org.gradle.api.Task
import org.gradle.api.artifacts.Configuration


/**
 * Created by Sion Williams on 14/08/2014.
 */
class WeblogicPluginSpec extends PluginProjectSpec {
    static final String PLUGIN_ID = 'com.lv.weblogic'

    @Override
    String getPluginName() {
        return PLUGIN_ID
    }

    def setup() {
        project.apply plugin: pluginName
    }

    def "apply creates weblogic configuration" () {
        expect: project.configurations.findByName('weblogic') instanceof Configuration
    }

    def "apply creates wlDeploy extension" () {
        expect: project.extensions.findByName('wlDeploy')
    }

    def "apply creates wlDeploy task" () {
        setup:
            Task task = project.tasks.findByName('wlDeploy')

        expect:
            task != null
            task instanceof WLDeployTask
            task.action == 'deploy'
    }

    def "apply creates wlUndeploy task" () {
        setup:
            Task task = project.tasks.findByName('wlUndeploy')

        expect:
            task != null
            task instanceof WLDeployTask
            task.action == 'undeploy'
    }

    def "apply creates wlCancel task" () {
        setup:
            Task task = project.tasks.findByName('wlCancel')

        expect:
            task != null
            task instanceof WLDeployTask
            task.action == 'cancel'
    }

    def "apply creates wlRedeploy task" () {
        setup:
            Task task = project.tasks.findByName('wlRedeploy')

        expect:
            task != null
            task instanceof WLDeployTask
            task.action == 'redeploy'
    }

    def "apply creates wlDistribute task" () {
        setup:
            Task task = project.tasks.findByName('wlDistribute')

        expect:
            task != null
            task instanceof WLDeployTask
            task.action == 'distribute'
    }

    def "apply creates wlStart task" () {
        setup:
            Task task = project.tasks.findByName('wlStart')

        expect:
            task != null
            task instanceof WLDeployTask
            task.action == 'start'
    }

    def "apply creates wlStop task" () {
        setup:
            Task task = project.tasks.findByName('wlStop')

        expect:
            task != null
            task instanceof WLDeployTask
            task.action == 'stop'
    }
}
