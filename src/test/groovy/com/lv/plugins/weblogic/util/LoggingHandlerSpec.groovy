package com.lv.plugins.weblogic.util

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import spock.lang.Specification

/**
 * Logging handler unit tests.
 *
 * @author Benjamin Muschko
 */
class LoggingHandlerSpec extends Specification {
    Project project

    def setup() {
        project = ProjectBuilder.builder().build()
    }

    void "withAntLoggingListener closure is executed"() {
        expect:
            project.ant.project.buildListeners.find { it.class == org.apache.tools.ant.BuildListener } == null
            boolean test = false
        when:
            LoggingHandler.withAntLoggingListener(project.ant) {
                test = true
            }
        then:
            test
            project.ant.project.buildListeners.find { it.class == org.apache.tools.ant.BuildListener } == null
    }
}
