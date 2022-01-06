// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        mavenCentral()
        google()
        jcenter()
        maven("https://plugins.gradle.org/m2/")
        maven("maven.google.com")
        maven("https://jitpack.io")
    }
    dependencies {
        classpath(Dependencies.Gradle.GRADLE)
        classpath(Dependencies.Gradle.KOTLIN_GRADLE)
        classpath(Dependencies.Navigation.CLASSPATH)
        classpath(Dependencies.Hilt.CLASSPATH)


        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven("maven.google.com")
        maven("https://jitpack.io")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
