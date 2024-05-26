package com.banturov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {

	@GetMapping("")
	public String homePage() {
		return "home";
	}
	
	@GetMapping("/faq")
	public String faqPage() {
		return "faq";
	}
	
	@GetMapping("/profile")
	public String profilePage() {
		return "profile";
	}

}
