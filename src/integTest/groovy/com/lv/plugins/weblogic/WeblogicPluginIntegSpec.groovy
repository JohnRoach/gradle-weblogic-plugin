package com.lv.plugins.weblogic

import nebula.test.IntegrationSpec
import nebula.test.functional.ExecutionResult


/**
 * Created by Sion Williams on 14/08/2014.
 */
class WeblogicPluginIntegSpec extends IntegrationSpec {

    def 'setup new build and check tasks are available'() {
        setup:
            buildFile << '''
                apply plugin: 'com.lv.weblogic'
            '''.stripIndent()

        when:
            ExecutionResult result = runTasksSuccessfully('tasks')

        then:
            result.standardOutput.contains('wlDeploy - Deploys or redeploys an application or module.')
            result.standardOutput.contains('wlUndeploy - Stops the deployment unit and removes staged files from target servers.')
            result.standardOutput.contains('wlCancel - Attempt to cancel a running deployment task.')
            result.standardOutput.contains('wlRedeploy - Redeploys a running application or part of a running application.')
            result.standardOutput.contains('wlStart - Makes a stopped (inactive) application available to clients on target servers.')
            result.standardOutput.contains('wlStop - Makes an application inactive and unavailable administration and client requests.')
    }
}
