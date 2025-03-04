package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	
	@GetMapping("/index.html")
	public String index() {
		return "index";	
	}
	
	@GetMapping("/home.html")
	public String home() {
		return "home";	
	}
	
	@GetMapping("/login.html")
	public String login() {
		return "login";	
	}
	
	@GetMapping("/register.html")
	public String register() {
		return "register";
	}

}
