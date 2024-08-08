package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Songs;
import com.example.demo.entities.Users;
import com.example.demo.services.SongsServices;
import com.example.demo.services.UsersServiceImp;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UsersServiceImp users;
    
    @Autowired
    SongsServices songservice;

    @PostMapping("/register")
    public String addUser(@ModelAttribute Users user) {
        if (users.emailExists(user.getEmail())) {
            return "registerFail";
        } else {
            users.addUser(user);
            return "RegisterSuccess";
        }
    }

    @PostMapping("/login")
    public String validateUser(@RequestParam String email, @RequestParam String password,HttpSession session) {
        if (users.validateUser(email, password)) {
            session.setAttribute("email", email);
            if (users.getRole(email).equals("admin")) {
                return "adminHome";
            } else {
                return "customerHome";
            }
        } else {
            return "loginFail";
        }
    }
    @GetMapping("/viewsongs")
	public String viewCustomerSongs(HttpSession session,Model model) {
    	String email=(String) session.getAttribute("email");
		Users user= users.getObject(email);
		boolean userStatus=user.isPremium();
		if (userStatus) {
			//Fetching songs using songservice
			List<Songs> songList = songservice.fetchAllSongs();
			model.addAttribute("songList", songList);
			return "DisplaySongs";

		} else

			return "makePayment";
	}

}
