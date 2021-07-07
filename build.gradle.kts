import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.3.12.RELEASE"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"
	kotlin("plugin.jpa") version "1.3.72"
}

group = "com.review"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	compile(group= "com.h2database", name= "h2", version= "1.3.148")

	implementation(group = "io.springfox", name = "springfox-swagger2", version = "3.0.0")
	implementation(group="io.springfox", name= "springfox-boot-starter", version= "3.0.0")
	implementation(group= "io.springfox", name= "springfox-swagger-ui", version= "2.9.2")
	implementation(group= "com.fasterxml.jackson.dataformat", name= "jackson-dataformat-xml")

//	testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
//	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
//	testImplementation(group= "org.springframework", name= "spring-test", version= "5.3.3")


	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}

}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
