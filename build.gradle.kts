plugins {
    java
    checkstyle
    jacoco
    id("org.springframework.boot") version "3.5.0"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.vtkr"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    runtimeOnly("com.h2database:h2")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.projectlombok:lombok")
}

checkstyle {
    configFile = file("config/checkstyle/checkstyle.xml")
}

// Check style configuration and reports.
tasks.withType<Checkstyle> {
    isShowViolations = true
    reports {
        html.required.set(true)
    }
}

// Ensure JaCoCo report is generated after tests
tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport, tasks.jacocoTestCoverageVerification)
}

// JaCoCo report configuration
tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        html.required.set(true)
    }
}

// JaCoCo Test Coverage Rules
tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            limit {
                counter = "LINE"
                value = "COVEREDRATIO"
                minimum = "0.80".toBigDecimal()
            }
        }
    }
}
