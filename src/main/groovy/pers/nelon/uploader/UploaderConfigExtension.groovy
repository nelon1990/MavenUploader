package pers.nelon.uploader

import org.gradle.api.Action

/**
 * Created by nelon on 17-3-27.
 */

class UploaderConfigExtension {
    String artifact
    String group
    String version
    String repositoryUrl
    String userName
    String password
    Map<String, String> extMap

    UploaderConfigExtension() {
        artifact = ""
        group = ""
        version = ""
        repositoryUrl = ""
        userName = ""
        password = ""
        extMap = new HashMap<>()
    }

    void ext(Action<Map> pMapAction) {
        pMapAction.execute(extMap)
    }
}
