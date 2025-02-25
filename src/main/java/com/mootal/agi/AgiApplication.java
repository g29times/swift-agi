package com.mootal.agi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.lang.Exception;
import io.sentry.Sentry;

@SpringBootApplication
@RestController
public class AgiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgiApplication.class, args);
	}

	@GetMapping("/")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping("/hello_error")
	public String error() {
		try {
			throw new Exception("This is a test.");
		} catch (Exception e) {
			Sentry.captureException(e);
		}
		return "Hello Error";
	}

}
