plugins {
    java // Gradle can work with other languages, not just Java! So want to specify we have a Java project.
    // To find which languages are supported: https://docs.gradle.org/current/userguide/userguide.html
    application // When using Gradle, it is better to run programs through Gradle, rather than Intellij.
}

// Want to explicitly state which Java version we are using in this project for the programmer and Gradle!
java.toolchain.languageVersion = JavaLanguageVersion.of(25)

application.mainClass = "edu.canisius.csc213.project1.UniqueHands"

repositories {
    mavenCentral() // Where to look for external (3rd-party) dependencies.
    // What libraries are in this repository can be found here: https://mvnrepository.com/repos/central
}

dependencies {

    // We'll be using the JUnit testing framework to help us run the unit tests, so pull the necessary dependencies
    // from Maven Central.

    // This dependency is for the testing code to run. /////////////////////////////////////////////////////////////
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:6.0.3") // Declare testing framework launcher.

    // This dependency is required to compile and run the testing code. ////////////////////////////////////////////
    testImplementation("org.junit.jupiter:junit-jupiter:6.0.3")
}

tasks.test {
    useJUnitPlatform() // Declare that we are using the JUnit Testing Framework for our tests.
}

tasks.jar {
    archiveBaseName.set("UniqueHands") // Change the name of the jar.
    manifest { attributes["Main-Class"] = application.mainClass } // Ensure jar is runnable.
}
