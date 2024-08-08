package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.PlayList;
import com.example.demo.entities.Songs;

public interface PlayListServices {

	void addPlayList(PlayList playList);

	List<PlayList> fetchAllPlayLists();

}
