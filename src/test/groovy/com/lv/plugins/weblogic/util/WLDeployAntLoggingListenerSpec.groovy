package com.lv.plugins.weblogic.util

import org.apache.tools.ant.BuildEvent
import org.apache.tools.ant.BuildListener
import org.apache.tools.ant.Project
import org.apache.tools.ant.Task
import org.apache.tools.ant.taskdefs.Copy
import org.gradle.api.logging.Logger
import spock.lang.Specification
import weblogic.ant.taskdefs.management.WLDeploy

/**
 * Cargo Ant build listener unit tests.
 *
 * @author Benjamin Muschko
 * @author Sion Williams
 */
class WLDeployAntLoggingListenerSpec extends Specification {
    BuildListener buildListener

    def setup() {
        buildListener = new WLDeployAntLoggingListener()
    }

    void 'Message not logged for non-WLDeploy Ant task'() {
        given:
            Task antCopyTask = new Copy()
            BuildEvent buildEvent = new BuildEvent( antCopyTask )
            buildEvent.message = 'Weblogic started'
            Logger mockLogger = Mock( Logger )
            buildListener.logger = mockLogger

        when:
            buildListener.messageLogged( buildEvent )

        then:
            0 * mockLogger.lifecycle('Weblogic started')
    }

    void 'Message not logged for WLDeploy Ant task with debug priority'() {
        given:
            Task antWLDeployTask = new WLDeploy()
            BuildEvent buildEvent = new BuildEvent( antWLDeployTask )
            buildEvent.message = 'Weblogic started'
            buildEvent.priority = Project.MSG_DEBUG
            Logger mockLogger = Mock( Logger )
            buildListener.logger = mockLogger

        when:
            buildListener.messageLogged( buildEvent )

        then:
            0 * mockLogger.lifecycle('Weblogic started')
    }

    void 'Message is logged for WLDeploy Ant task with info priority'() {
        given:
            Task antWLDeployTask = new WLDeploy()
            BuildEvent buildEvent = new BuildEvent( antWLDeployTask )
            buildEvent.message = 'Weblogic started'
            buildEvent.priority = Project.MSG_INFO
            Logger mockLogger = Mock( Logger )
            buildListener.logger = mockLogger

        when:
            buildListener.messageLogged( buildEvent )

        then:
            1 * mockLogger.lifecycle('Weblogic started')
    }
}
