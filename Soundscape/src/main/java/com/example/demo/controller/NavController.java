package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NavController {
	@GetMapping("/map_register")
	public String registerMapping() {
		return "register";
	}
	
	@GetMapping("/map_login")
	public String loginMapping() {
		return "login";
	}
	@GetMapping("/map_addSong")
	public String addSongsMapping() {
		return "AddSongs";
	}
	@GetMapping("/samplePayment")
	public String samplePayment() {
		return "samplePayment";
	}
	@GetMapping("/map__adminHome")
	public String mapAdmin() {
		return "adminHome";
	}
	
	
	
	

}
