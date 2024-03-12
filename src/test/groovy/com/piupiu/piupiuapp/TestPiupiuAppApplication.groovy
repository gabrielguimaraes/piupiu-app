package com.piupiu.piupiuapp

import org.springframework.boot.SpringApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.utility.DockerImageName

@TestConfiguration(proxyBeanMethods = false)
class TestPiupiuAppApplication {

	@Bean
	@ServiceConnection
	MongoDBContainer mongoDbContainer() {
		new MongoDBContainer(DockerImageName.parse("mongo:latest"))
	}

	static void main(String[] args) {
		SpringApplication.from(PiupiuAppApplication::main).with(TestPiupiuAppApplication).run(args)
	}

}
