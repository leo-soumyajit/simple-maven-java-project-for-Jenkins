package com.soumyajit.JenkinswithMaven;

import com.soumyajit.JenkinswithMaven.Controller.ApiController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JenkinswithMavenApplicationTests {

	private final ApiController controller = new ApiController();

	@Test
	void testHomeEndpoint() {
		String response = controller.home();
		assertEquals("Greetings from Soumyajit Banerjee!", response);
	}

	@Test
	void testHelloEndpointWithName() {
		String response = controller.hello(Optional.of("Soumyajit"));
		assertEquals("Hello, Soumyajit! Welcome to the Maven Project.", response);
	}

	@Test
	void testHelloEndpointWithDefaultName() {
		String response = controller.hello(Optional.empty());
		assertEquals("Hello, Super Coder! Welcome to the Maven Project.", response);
	}

	@Test
	void testStatusEndpoint() {
		String response = controller.status();
		assertEquals("Application is running!...", response);
	}

}
