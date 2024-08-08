package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo.entities.PlayList;
import com.example.demo.entities.Songs;
import com.example.demo.services.PlayListServiceImp;
import com.example.demo.services.PlayListServices;
import com.example.demo.services.SongsServices;
import com.example.demo.services.SongsServicesImp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class PlaylistController {
	@Autowired
	PlayListServices playser;
	@Autowired
	SongsServicesImp songSer;
	@GetMapping("/map_createPlayList")
	public String createPlayList(Model model) {
		List<Songs> songList= songSer.fetchAllSongs();
		model.addAttribute("songList", songList);
		
		return "createPlayList";
	}
	
	@PostMapping("/addPlayList")
	public String addPlayList(@ModelAttribute PlayList playList) {
			playser.addPlayList(playList);
			//update song table
			List<Songs> songsList=playList.getSongs();
			for(Songs song: songsList) {
				song.getPlaylist().add(playList);
				songSer.updateSong(song);
			}
			
				//TODO: process POST request
		
		return "playListSuccess";
	}
	
	@GetMapping("/map_viewPlayList")
	public String viewPlayList(Model model) {
		List<PlayList> playLists=playser.fetchAllPlayLists();
		model.addAttribute("playLists",playLists);
		return "viewPlayList";
	}
	
	
	

}
