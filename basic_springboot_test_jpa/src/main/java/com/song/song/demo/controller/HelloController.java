package com.song.song.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/")
	public String HelloWorld() {
		return "Welcome to my page hahadsada";
	}
}
