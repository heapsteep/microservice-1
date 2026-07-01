package com.heapsteep.controller;

import com.heapsteep.model.GreetingResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greetings")
public class GreetingController {

	@Value("${server.port}")
	private String port;

	@GetMapping("/{name}")
	public GreetingResponse getGreeting(@PathVariable String name) {
		return new GreetingResponse(name, "Hello " + name + ", response from microservice-1 from port: " + port);
	}

}