# RepoUploader

[![](https://jitpack.io/v/nelon1990/RepoUploader.svg)](https://jitpack.io/#nelon1990/RepoUploader)

An easy-use gradle plugin for uploading lib to repository

#USEAGE

##### Step 0
>In your project build.gradle add below

    buildscript {
        repositories {
            jcenter()
            ....
            maven { url 'https://jitpack.io' }
            ....
        }
        dependencies {
            ....
            classpath 'com.github.nelon1990:RepoUploader:0.0.2'
            ....
        }
    }

##### Step 1

>Apply plugin in the head of lib's build.gradle

    apply plugin: "...."
    apply plugin: "repoUploader"
    apply plugin: "...."
    
    ....
    

##### Step 2

>Set the specified the value of project ext property that the plugin has used
>
>Config your repository url and pom

    ....
    ext {
        _artifact = "RepoUploader"
        _group = "pers.nelon.uploader"
        _version = "0.0.1"
        _repositoryUrl = "xxxx"
        _userName = "xxx"
        _password = "xxx"
    }
    ....
    
##### Step 3
>In the terminal type command below, 

    gradle uploadToRepo
    
>And it would show info on terminal below if upload successfull
    
    ....
    init completed
    :configMaven
    ------------------------------MAVEN POM START------------------------------
    _artifact :              RepoUploader
    _group :                 pers.nelon.uploader
    _version :               0.0.1
    _repositoryUrl :         xxxxxxxxxxxxxxxx
    _userName :              xxx
    _password :              xxx
    -------------------------------MAVEN POM END-------------------------------
    :compileJava UP-TO-DATE
    :compileGroovy UP-TO-DATE
    :processResources UP-TO-DATE
    :classes UP-TO-DATE
    :jar UP-TO-DATE
    :sourcesJar UP-TO-DATE
    :uploadArchives
    :uploadToRepo
    ------------------------------UPLOAD COMPLETED------------------------------
    
    BUILD SUCCESSFUL
    
    Total time: 5.123 secs
    ....
