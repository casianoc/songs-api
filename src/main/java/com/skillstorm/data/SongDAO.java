package com.skillstorm.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.skillstorm.beans.Song;

public class SongDAO {

	private static final String url = "jdbc:mysql://localhost:3306/songs-api";
	private static final String username = "root";
	private static final String password = "root";
	
	// Load the class
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Song create(Song song) {
		
		// Create the connection and close when done
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			
			// Create the statement
			String sql = "insert into songs(name, rating, length, artist_name, album_name, genre, year_released) values(?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, song.getName());
			stmt.setInt(2, song.getRating());
			stmt.setInt(3, song.getLength());
			stmt.setString(4, song.getArtistName());
			stmt.setString(5, song.getAlbumName());
			stmt.setString(6, song.getGenre());
			stmt.setInt(3, song.getRelease());
			
			stmt.executeUpdate();
			
			ResultSet keys = stmt.getGeneratedKeys();
			
			keys.next();
			int songID = keys.getInt(1);
			song.setId(songID);
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		// return updated song with an id
		return song;
		
	}
	
	
	public List<Song> findAll(){
		
		List<Song> allSongs = new LinkedList<Song>();
		
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			
			String sql = "select id, name, rating, length, artist_name, album_name, genre, year_released from songs";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int songId = rs.getInt("id");
				String songName = rs.getString("name");
				int songRating = rs.getInt("rating");
				int songLength = rs.getInt("length");
				String artistName = rs.getString("artist_name");
				String albumName = rs.getString("album_name");
				String songGenre = rs.getString("genre");
				int yearReleased = rs.getInt("year_released");
				
				Song song = new Song(songId, songName, songRating, songLength, artistName, albumName, songGenre, yearReleased);
				
				allSongs.add(song);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allSongs;
		
	}
	
	
	public Song findById(int id) {
		
		Song song = new Song();
		
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			
			String sql = "select id, name, rating, length, artist_name, album_name, genre, year_released from songs where id= " + id;
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int songId = rs.getInt("id");
				String songName = rs.getString("name");
				int songRating = rs.getInt("rating");
				int songLength = rs.getInt("length");
				String artistName = rs.getString("artist_name");
				String albumName = rs.getString("album_name");
				String songGenre = rs.getString("genre");
				int yearReleased = rs.getInt("year_released");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return song;
	}
	
	public Song findByName(String name) {
		
		Song song = new Song();
		
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			
			String sql = "select id, name, rating, length, artist_name, album_name, genre, year_released from songs where name= " + name;
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int songId = rs.getInt("id");
				String songName = rs.getString("name");
				int songRating = rs.getInt("rating");
				int songLength = rs.getInt("length");
				String artistName = rs.getString("artist_name");
				String albumName = rs.getString("album_name");
				String songGenre = rs.getString("genre");
				int yearReleased = rs.getInt("year_released");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return song;
	}
	
	public void update(Song newSong) {
		
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			
			String sql = "update song set name = ?, rating = ?, length = ?, artist_name = ?, album_name = ?, genre = ?, year_released = ? where id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, newSong.getName());
			stmt.setInt(2, newSong.getRating());
			stmt.setInt(3, newSong.getLength());
			stmt.setString(4, newSong.getArtistName());
			stmt.setString(5, newSong.getAlbumName());
			stmt.setString(6, newSong.getGenre());
			stmt.setInt(7, newSong.getRelease());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void delete(Song song) {
		
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			
			String sql = "delete from songs where id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, song.getId());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
