package com.heapsteep.controller;

import com.heapsteep.model.GreetingResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greetings")
public class GreetingController {

	private static final Logger log = LoggerFactory.getLogger(GreetingController.class);

	@Value("${server.port}")
	private String port;

	@Value("${greeting.message-suffix}")
	private String messageSuffix;

	@GetMapping("/{name}")
	public GreetingResponse getGreeting(@PathVariable String name) {
		log.info("Received greeting request for name={}", name);
		return new GreetingResponse(name, "Hello " + name + ", " + messageSuffix + " from port: " + port);
	}
}