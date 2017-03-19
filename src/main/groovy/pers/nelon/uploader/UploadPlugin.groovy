package pers.nelon.uploader

import org.gradle.api.Plugin
import org.gradle.api.Project
import pers.nelon.uploader.task.MavenConfigTask

public class UploadPlugin implements Plugin<Project> {
    private static final String MAVEN_CONFIG_TASK_NAME = "configMaven"

    @Override
    public void apply(Project project) {
        configMaven(project)
    }

    private void configMaven(Project pProject) {
        if (!pProject.plugins.hasPlugin("maven")) {
            pProject.apply plugin: "maven"
        }

        pProject.ext {
            _artifact = pProject.name
            _group = pProject.group
            _version = pProject.version
            _repositoryUrl = ""
            _userName = ""
            _password = ""
        }

        pProject.project.getTasks().create(MAVEN_CONFIG_TASK_NAME, MavenConfigTask)

        pProject.tasks.findByName("uploadArchives").dependsOn MAVEN_CONFIG_TASK_NAME

        pProject.project.getTasks().create("uploadToRepo", UploadExecutor) {
            doLast {
                println "------------------------------UPLOAD COMPLETED------------------------------"
            }
        }.dependsOn "uploadArchives"
    }

}
