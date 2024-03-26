// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}

buildscript{

    dependencies{
        classpath("com.android.tools.build:gradle:4.1.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.10")
        classpath("org.koin:koin-gradle-plugin:2.1.6")
    }
}


//buildscript {
//
////    val kotlinVersion by extra("1.5.20")
////    repositories {
////        google()
////        mavenCentral()
////        maven {
////            url= uri("https://maven.fabric.io/public")
////        }
////        maven {
////            url = uri("https://oss.sonatype.org/content/repositories/snapshots")
////        }
////    }
//
//    dependencies {
//        classpath("com.android.tools.build:gradle:4.1.3")
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.10")
//        classpath("io.insert-koin:koin-gradle-plugin:2.1.6")
//    }
//}
//
//allprojects {
//    repositories {
//        google()
//        mavenCentral()
//        maven { url = uri("https://jitpack.io") }
//    }
//}
//
//tasks.register("clean",Delete::class) {
//    delete(rootProject.buildDir)
//}