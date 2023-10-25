package com.keyin.sprint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
public class APIRoutes {
	public static void main(String[] args) {
		SpringApplication.run(APIRoutes.class, args);
	}

/**
  * This is a basic call to our springboot API.
  * 	This is a GET request to the /hello endpoint.
  * 	The @RequestParam annotation is used to extract query parameters from the request.
  * 	The @RequestParam annotation has two attributes:
  * 		1. value: the name of the request parameter
  * 		2. defaultValue: the default value to use as a fallback when the request parameter is not provided
 **/
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/passengers")
	public String passengers() {
		return "This is a list of passengers!";
	}

	@GetMapping("/passenger/{id}")
	public String passenger(@RequestParam(value = "id", defaultValue = "0") String id) {
		return String.format("This is passenger %s!", id);
	}

	@GetMapping("/cities")
	public String cities() {
		return "This is a list of cities!";
	}

	@GetMapping("/city/{id}")
	public String city(@RequestParam(value = "id", defaultValue = "0") String id) {
		return String.format("This is city %s!", id);
	}

	@GetMapping("/airports")
	public String airports() {
		return "This is a list of airports!";
	}

	@GetMapping("/airport/{id}")
	public String airport(@RequestParam(value = "id", defaultValue = "0") String id) {
		return String.format("This is airport %s!", id);
	}

	@GetMapping("/aircraft")
	public String aircraft() {
		return "This is a list of aircraft!";
	}

	@GetMapping("/aircraft/{id}")
	public String aircraft(@RequestParam(value = "id", defaultValue = "0") String id) {
		return String.format("This is aircraft %s!", id);
	}

	@GetMapping("/test")
	public String test() {
		return "This is a test!";
	}

	@GetMapping("/")
	public String home() {
		return "Welcome to the Sprint API!";
	}

}

