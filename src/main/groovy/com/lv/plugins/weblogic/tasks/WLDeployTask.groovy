package com.lv.plugins.weblogic.tasks

/**
 * @author Sion Williams
 */
class WLDeployTask extends AbstractWLDeployTask {

    /**
     * The deployment action to perform.
     */
    static final String ACTION = 'deploy'

    /**
     * Constructor.
     */
    WLDeployTask() {
        super( 'Deploys or redeploys an application or module.' )
    }

    @Override
    void runWlDeployCommand() {

        ant.wldeploy(action: ACTION,
                source: getSource(),
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
