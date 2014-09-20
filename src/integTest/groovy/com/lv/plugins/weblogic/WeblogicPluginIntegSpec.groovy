package com.lv.plugins.weblogic

import nebula.test.IntegrationSpec
import nebula.test.functional.ExecutionResult


/**
 * Created by Sion Williams on 14/08/2014.
 */
class WeblogicPluginIntegSpec extends IntegrationSpec {
    def 'runs build'() {
        when:
        ExecutionResult result = runTasks('dependencies')

        then:
        result.failure == null
    }

    def 'setup new build and check tasks are available'() {
        setup:
        buildFile << '''
            apply plugin: 'com.lv.weblogic'
        '''.stripIndent()

        when:
        ExecutionResult result = runTasksSuccessfully('tasks')

        then:
        result.standardOutput.contains('wlDeploy')
        result.standardOutput.contains('wlUndeploy')
        result.standardOutput.contains('wlCancel')
        result.standardOutput.contains('wlRedeploy')
        result.standardOutput.contains('wlDistribute')
        result.standardOutput.contains('wlStart')
        result.standardOutput.contains('wlStop')
    }
}
