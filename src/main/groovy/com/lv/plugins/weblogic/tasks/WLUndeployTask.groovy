package com.lv.plugins.weblogic.tasks

/**
 * @author Sion Williams
 */
class WLUndeployTask extends AbstractWLDeployTask {

    /**
     * The deployment action to perform.
     */
    static final String ACTION = 'undeploy'

    /**
     * Constructor.
     */
    WLUndeployTask() {
        super( 'Stops the deployment unit and removes staged files from target servers.' )
    }

    @Override
    void runWlDeployCommand() {

        ant.wldeploy(action: ACTION,
                name: getDeploymentName(),
                adminurl: getAdminurl(),
                user: getUser(),
                password: getPassword(),
                targets: getTargets(),
                verbose: getVerbose(),
                debug: getDebug(),
                remote: getRemote(),
                upload: getUpload()
        )
    }
}
