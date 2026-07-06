package com.heapsteep.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/api/config")
public class ConfigDemoController {

	@Value("${app.config-demo.company}")
	private String company;

	@Value("${app.config-demo.environment}")
	private String environment;

	@Value("${greeting.message-suffix}")
	private String greetingMessageSuffix;

	@GetMapping
	public Map<String, String> getConfigValues() {
		Map<String, String> config = new LinkedHashMap<>();
		config.put("source", "Spring Cloud Config Client (microservice-1)");
		config.put("app.config-demo.company", company);
		config.put("app.config-demo.environment", environment);
		config.put("greeting.message-suffix", greetingMessageSuffix);
		return config;
	}

}
