package com.banturov.controllers;

import java.util.List;

import javax.naming.Binding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.banturov.models.MyHeroes;
import com.banturov.models.MyUser;
import com.banturov.models.MyUserDetails;
import com.banturov.repository.MyHeroesService;
import com.banturov.repository.MyUserDetailService;

import jakarta.validation.Valid;

@Controller
public class MainController {

	@Autowired
	private MyUserDetailService serviceUser;

	@Autowired
	private MyHeroesService serviceHeroe;

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
	public String profilePage(@AuthenticationPrincipal MyUserDetails user, Model model) {
		List<MyHeroes> heroes = serviceHeroe.findHero(user.getId());
		model.addAttribute("heroes", heroes);
		return "profile";
	}
	
	
	
	@GetMapping("/create")
	public String createHeroe(Model model) {
		model.addAttribute("myHeroes", new MyHeroes());
		return "create";
	}
	
	@PostMapping("/create")
	public String createHeroe(@ModelAttribute("myHeroes") @Valid  MyHeroes heroe, BindingResult bindingResult,
			@AuthenticationPrincipal MyUserDetails user) {
		if(bindingResult.hasErrors()) {
			return "create";
		}
		MyUser userBuffer = new MyUser();
		userBuffer.setId(user.getId());
		heroe.setUser(userBuffer);
		serviceHeroe.save(heroe);
		return "redirect:/profile";
	}

	
	
	@GetMapping("/reg")
	public String registerPage(Model model) {
		model.addAttribute("myUser", new MyUser());
		return "register";
	}

	@PostMapping("/reg")
	public String registerPage(@ModelAttribute("myUser") @Valid  MyUser user, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			return "register";
		}
		user.setRole("ROLE_USER");
		serviceUser.save(user);
		return "redirect:/login";
	}

}
