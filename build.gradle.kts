plugins {
    id("com.android.application") version "7.3.1" apply false
    id("com.android.library") version "7.3.1" apply false
    id("org.jetbrains.kotlin.android") version "1.6.10" apply false
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "1.6.10"
}

buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:7.3.0")
        classpath("io.insert-koin:koin-gradle-plugin:3.3.0")
        classpath(kotlin("gradle-plugin", version = "1.6.10"))
        classpath(kotlin("serialization", version = "1.6.10"))
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.