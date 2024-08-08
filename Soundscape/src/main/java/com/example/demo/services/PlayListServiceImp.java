package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.PlayList;
import com.example.demo.repositories.PlayListRepository;

@Service
public class PlayListServiceImp implements PlayListServices {
	@Autowired
	PlayListRepository playRepo;

	@Override
	public void addPlayList(PlayList playList) {
		playRepo.save(playList);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PlayList> fetchAllPlayLists() {
		return playRepo.findAll();
	}

}
