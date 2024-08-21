package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@GetMapping("/test")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void test(@RequestParam("kra") String kra) {
		if (kra.equals("err")) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

}
