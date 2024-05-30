package com.banturov.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {

	
	@GetMapping("/")
	public String homePage() {
		return "home";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/faq")
	public String faqPage() {
		return "faq";
	}
	
	@GetMapping("/profile")
	@PreAuthorize("hasAuthority('ROLE_USER') || hasAuthority('ROLE_ADMIN')")
	public String profilePage() {
		return "profile";
	}

}
