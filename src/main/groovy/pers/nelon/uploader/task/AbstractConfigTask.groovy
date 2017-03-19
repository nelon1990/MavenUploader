package pers.nelon.uploader.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Upload

/**
 * Created by nelon on 17-3-19.
 */

public abstract class AbstractConfigTask extends DefaultTask {

    public AbstractConfigTask() {
        doLast {
            applyConfig()
        }
    }

    public abstract void applyConfig()

}
