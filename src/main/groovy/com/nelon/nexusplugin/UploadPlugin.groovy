package com.nelon.nexusplugin

import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ObjectConfigurationAction
import org.gradle.api.tasks.Upload

import java.util.Map.Entry

public class UploadPlugin implements Plugin<Project> {
    public static final String REPOSITORY_CONFIG = "repositoryConfig"

    @Override
    public void apply(Project project) {
//        project.extensions.create(REPOSITORY_CONFIG, RepositoryConfigExtension,
//                "http://localhost:8081/repository/maven-snapshots/",
//                "http://localhost:8081/repository/maven-public/",
//                [admin: 'admin123'],
//                [admin: 'admin123']
//        )

//        def uploadArchives = project.tasks.findByName("uploadArchives")
//        if (uploadArchives instanceof Upload) {
//            uploadArchives.repositories {
//                mavenDeployer {
//                    snapshotRepository(url: project.repositoryConfig.snapshotRepository) {
//                        project.repositoryConfig.snapshotRepositoryUser.entrySet.each { Entry pEntry ->
//                            authentication(userName: pEntry.key, password: pEntry.value)
//                        }
//                    }
//                    repository(url: project.repositoryConfig.repository) {
//                        project.repositoryConfig.repositoryUser.entrySet.each { Entry pEntry ->
//                            authentication(userName: pEntry.key, password: pEntry.value)
//                        }
//                    }
//                }
//            }
//        }

        project.apply(new Action<ObjectConfigurationAction>() {
            @Override
            void execute(ObjectConfigurationAction pObjectConfigurationAction) {
                pObjectConfigurationAction.plugin('maven')
            }
        })
        def uploadArchives = project.tasks.findByName("uploadArchives")
        if (uploadArchives instanceof Upload) {
            uploadArchives.repositories {
                configuration = project.configurations.archives
                mavenDeployer {
                    repository(url: "http://localhost:8081/repository/maven-snapshots/") {
                        authentication(userName: 'admin', password: 'admin123')
                    }
                }
            }
        }
    }

    public class RepositoryConfigExtension {
        public String snapshotRepository
        public String repository
        public Map<String, String> snapshotRepositoryUser
        public Map<String, String> repositoryUser

        public RepositoryConfigExtension(String pSnapshotRepository, String pRepository, Map<String, String> pSnapshotRepositoryUser, Map<String, String> pRepositoryUser) {
            snapshotRepository = pSnapshotRepository
            repository = pRepository
            snapshotRepositoryUser = pSnapshotRepositoryUser
            repositoryUser = pRepositoryUser
        }
    }
}
