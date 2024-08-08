package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Songs;
import com.example.demo.entities.Users;

public interface SongsServices {

	public String addSongs(Songs song);
	public boolean isSongPresent(String Song_name);
	public List<Songs> fetchAllSongs();
	public void updateSong(Songs song);
	

}
