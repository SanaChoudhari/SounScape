package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
@Entity
public class Songs {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String songName;
	String	artist;
	String genre;
	String link;
	@ManyToMany
	List<PlayList> playlist;
	public Songs(int id, String songName, String artist, String genre, String link, List<PlayList> playlist) {
		super();
		this.id = id;
		this.songName = songName;
		this.artist = artist;
		this.genre = genre;
		this.link = link;
		this.playlist = playlist;
	}
	public Songs() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public List<PlayList> getPlaylist() {
		return playlist;
	}
	public void setPlaylist(List<PlayList> playlist) {
		this.playlist = playlist;
	}
	@Override
	public String toString() {
		return "Songs [id=" + id + ", songName=" + songName + ", artist=" + artist + ", genre=" + genre + ", link="
				+ link  +"]";
	}
	

}
