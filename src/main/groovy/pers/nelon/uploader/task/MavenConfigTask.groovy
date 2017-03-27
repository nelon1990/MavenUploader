package pers.nelon.uploader.task;

/**
 * Created by nelon on 17-3-19.
 */

public class MavenConfigTask extends AbstractConfigTask {

    @Override
    public void applyConfig() {
        project.tasks.findByName("uploadArchives").repositories {
            mavenDeployer {
                println "------------------------------MAVEN POM START------------------------------"
                println "artifact :\t\t " + project.uploaderConfig.artifact
                println "group :\t\t " + project.uploaderConfig.group
                println "version :\t\t " + project.uploaderConfig.version
                println "repositoryUrl :\t " + project.uploaderConfig.repositoryUrl.replace("\t", "")
                println "userName :\t\t " + project.uploaderConfig.userName
                println "password :\t\t " + project.uploaderConfig.password
                println "-------------------------------MAVEN POM END-------------------------------"

                repository(url: project.uploaderConfig.repositoryUrl) {
                    authentication(userName: project.uploaderConfig.userName, password: project.uploaderConfig.password)
                }
                pom {
                    version = project.uploaderConfig.version
                    groupId = project.uploaderConfig.group
                    artifactId = project.uploaderConfig.artifact
                }
            }
        }
    }
}
