plugins {
    java
}

group = "com.tavisca.training.practice"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testCompile("junit", "junit", "4.12")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.0")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_10
    targetCompatibility = JavaVersion.VERSION_1_10
}

tasks.named<Test>("test") {
    dependsOn("cleanTest")
    useJUnitPlatform {
        includeEngines("junit-jupiter")
        excludeTags("tbd-tests")
    }

    testLogging {
        showExceptions = true
        events("passed", "skipped", "failed")
    }
}