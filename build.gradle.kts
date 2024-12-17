plugins {
    id("java")
    id("maven-publish")
}

group = "pl.sophietheshork.shorkapi"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

publishing {
    publications {
        create<MavenPublication>("ShorkAPI") {
            from(components["java"])
            pom {
                name.set("ShorkAPI")
                description.set("Library for my Minecraft plugins")
                url.set("https://github.com/sophiethetransshork/ShorkAPI")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("sophietheshork")
                        name.set("SophieTheShork")
                        email.set("sophietheshork@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/sophiethetransshork/ShorkAPI.git")
                    developerConnection.set("scm:git:ssh://github.com/sophiethetransshork/ShorkAPI.git")
                    url.set("https://github.com/sophiethetransshork/ShorkAPI")
                }
            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
}