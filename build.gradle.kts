plugins {
    id("java")
    id("maven-publish")
}

group = "pl.sophietheshork.shorkapi"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public")
    maven("https://repo.dmulloy2.net/repository/public/")
    maven("https://oss.sonatype.org/content/groups/public/")
    maven("https://maven.enginehub.org/repo/")
    maven("https://jitpack.io")
    maven("https://mvn.lumine.io/repository/maven-public/")
    maven("https://repo.codemc.org/repository/maven-public/")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT")
    implementation("net.luckperms:api:5.4")
    implementation("org.incendo:cloud-core:2.0.0-rc.2")
    implementation("org.incendo:cloud-annotations:2.0.0-rc.2")
    implementation("org.incendo:cloud-minecraft-extras:2.0.0-beta.9")
    implementation("org.incendo:cloud-paper:2.0.0-beta.9")
    implementation("net.dv8tion:JDA:5.0.1")
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