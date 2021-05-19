package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class HelloWorldController {

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World - Changed");
	}
	
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
		
	@GetMapping(path = "/actuator/health")
	public String healthBean() {
		return "Hello World - Health";
	}
		
	@GetMapping(path = "/")
	public String rootBean() {
		return "Hello World - Health";
	}
		
	@GetMapping(path = "/resttemplate")
	public String restTemplateBean() {
		RestTemplate restTemplate= new RestTemplate();

		String url = "https://w4fnt8whvj.execute-api.ap-northeast-1.amazonaws.com/dev/pets";
        ResponseEntity<String> user = restTemplate.getForEntity(url, String.class);
        HttpStatus statusCode = user.getStatusCode();
        // System.out.println("status code - " + statusCode);
        String userDetails = user.getBody();
        return userDetails;
        // System.out.println("response body - " + userDetails);
        // HttpHeaders responseHeaders = user.getHeaders();
        // System.out.println("response Headers - " + responseHeaders);
	}
}
