package pers.nelon.uploader.task
/**
 * Created by nelon on 17-3-19.
 */

public class MavenConfigTask extends AbstractConfigTask {

    @Override
    public void applyConfig() {
        project.tasks.findByName("uploadArchives").repositories {
            mavenDeployer {
                println "------------------------------MAVEN POM START------------------------------"
                println "artifact :\t\t ${project.uploaderConfig.artifact}"
                println "group :\t\t ${project.uploaderConfig.group}"
                println "version :\t\t ${project.uploaderConfig.version}"
                println "repositoryUrl :\t\t ${project.uploaderConfig.repositoryUrl}"
                println "userName :\t\t ${project.uploaderConfig.userName}"
                println "password :\t\t ${project.uploaderConfig.password}"
                println "ext :"
                Map<String, String> map = project.uploaderConfig.extMap
                Set<String> keySet = map.keySet()
                keySet.each { key ->
                    println "\t${key} : ${map.get(key)}"
                }
                println "-------------------------------MAVEN POM END-------------------------------"

                repository(url: project.uploaderConfig.repositoryUrl) {
                    authentication(userName: project.uploaderConfig.userName, password: project.uploaderConfig.password)
                }
                pom { p ->
                    p.version = project.uploaderConfig.version
                    p.groupId = project.uploaderConfig.group
                    p.artifactId = project.uploaderConfig.artifact

                    keySet.each { key ->
                        p.withXml {
                            asNode().appendNode(key, map.get(key))
                        }
                    }

                }
            }
        }
    }
}
