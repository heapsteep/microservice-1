package com.heapsteep.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.heapsteep.bean.Microservice1;

@RestController
public class Microservice1Controller {
	@Autowired
	private Environment environment;
	
	@GetMapping("microservice-1/from/{from}/to/{to}")
	public Microservice1 getValue(@PathVariable String from, @PathVariable String to) {
		String port=environment.getProperty("local.server.port");
		return new Microservice1(1000L, from, to, BigDecimal.valueOf(50),port);		
	}
}
