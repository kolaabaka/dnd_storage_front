package com.banturov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.banturov.models.myUser;
import com.banturov.repository.myUserDetailService;

@Controller
public class mainController {

	@Autowired
	private myUserDetailService service;

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

	@GetMapping("/reg")
	public String registerPage(Model model) {
		model.addAttribute("myUser", new myUser());
		return "register";
	}

	@PostMapping("/reg")
	public String registerPage(@ModelAttribute("myUser") myUser user) {
		user.setRole("ROLE_USER");
		service.save(user);
		return "redirect:/login";
	}

}
