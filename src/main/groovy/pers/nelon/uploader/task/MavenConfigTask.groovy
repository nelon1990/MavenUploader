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
                println "_artifact :\t\t " + project._artifact
                println "_group :\t\t " + project._group
                println "_version :\t\t " + project._version
                println "_repositoryUrl :\t " + project._repositoryUrl.replace("\t", "")
                println "_userName :\t\t " + project._userName
                println "_password :\t\t " + project._password
                println "-------------------------------MAVEN POM END-------------------------------"

                repository(url: project._repositoryUrl) {
                    authentication(userName: project._userName, password: project._password)
                }
                pom {
                    version = project._version
                    groupId = project._group
                    artifactId = project._artifact
                }
            }
        }
    }
}
