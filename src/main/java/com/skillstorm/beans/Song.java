package com.skillstorm.beans;

import java.util.Objects;

public class Song {
	
	// Fields
	private int id;
	private String name;
	private int length;
	private int rating;
	private String artistName;
	private String albumName;
	private String genre;
	private int release;
	
	// Constructors
	public Song(int id, String name, int length, int rating, String artistName, String albumName, String genre, int release) {
		super();
		this.id = id;
		this.name = name;
		this.length = length;
		this.rating = rating;
		this.artistName = artistName;
		this.albumName = albumName;
		this.genre = genre;
		this.release = release;
	}
	
	public Song() {
		super();
	}


	// Getters and Setters 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getRelease() {
		return release;
	}
	public void setRelease(int release) {
		this.release = release;
	}
	
	// To string 
	@Override
	public String toString() {
		return "Song [ID=" + id + "name=" + name + ", length=" + length + ", rating=" + rating + ", artistName=" + artistName
				+ ", albumName=" + albumName + ", genre=" + genre + ", release=" + release + "]";
	}

	
	// Hashcode and Equals Methods 
	@Override
	public int hashCode() {
		return Objects.hash(albumName, artistName, genre, id, length, name, rating, release);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		return Objects.equals(albumName, other.albumName) && Objects.equals(artistName, other.artistName)
				&& Objects.equals(genre, other.genre) && id == other.id && length == other.length
				&& Objects.equals(name, other.name) && rating == other.rating && release == other.release;
	}

	
}
