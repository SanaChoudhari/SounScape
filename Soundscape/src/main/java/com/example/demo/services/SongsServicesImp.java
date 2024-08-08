package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Songs;
import com.example.demo.entities.Users;
import com.example.demo.repositories.SongsRepository;

@Service
public class SongsServicesImp implements SongsServices {
    @Autowired
    SongsRepository srepo;

    @Override
    public String addSongs(Songs song) {
        srepo.save(song);
        return "Song is added";
    }

    @Override
    public boolean isSongPresent(String songName) {
        return srepo.findBySongName(songName) != null;
    }

	@Override
	public List<Songs> fetchAllSongs() {
		List<Songs> songList=srepo.findAll();
		// TODO Auto-generated method stub
		return songList;
	}

	public void updateSong(Songs song) {
		srepo.save(song);
		// TODO Auto-generated method stub
		
	}

	
}
