package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Songs;
import com.example.demo.entities.Users;
import com.example.demo.services.SongsServices;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SongsController {
	@Autowired
	SongsServices songService;

	@PostMapping("/add_Song")
	public String addSongs(@ModelAttribute Songs song) {
		if (songService.isSongPresent(song.getSongName())) {
			System.out.println(song+" presnet");
			return "songRegisterFail";
		} else {
			System.out.println(song+" presnet");
			songService.addSongs(song);
			return "songSuccess";
			
		}
	}

	@GetMapping("/map_DisplaySong")
	public String viewSongs(Model model) {
		List<Songs> songList = songService.fetchAllSongs();
		model.addAttribute("songList", songList);
		return "DisplaySongs";
	}

	
}
