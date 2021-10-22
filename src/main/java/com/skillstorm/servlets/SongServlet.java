package com.skillstorm.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.beans.Song;
import com.skillstorm.data.SongDAO;

@WebServlet(urlPatterns = "/api/songs")
public class SongServlet extends HttpServlet {

	SongDAO dao = new SongDAO();

	// GET Method
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Song> allSongs = dao.findAll();

		String json = new ObjectMapper().writeValueAsString(allSongs);

		resp.getWriter().print(json);

		resp.setContentType("application/json");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		InputStream requestBody = req.getInputStream();

		Song song = new ObjectMapper().readValue(requestBody, Song.class);

		Song updatedSong = dao.create(song);

		resp.getWriter().print(new ObjectMapper().writeValueAsString(updatedSong));

		resp.setContentType("application/json");

		resp.setStatus(201);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		InputStream requestBody = req.getInputStream();

		Song song = new ObjectMapper().readValue(requestBody, Song.class);

		Song updatedSong = dao.create(song);

		resp.getWriter().print(new ObjectMapper().writeValueAsString(updatedSong));

		resp.setContentType("application/json");

		resp.setStatus(201);
		
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		InputStream requestBody = req.getInputStream();

		Song song = new ObjectMapper().readValue(requestBody, Song.class);
		
		dao.delete(song);
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		
		System.out.println("servlet init()");
		
	}
	
	@Override
	public void destroy() {
		super.destroy();
		
		
		
		System.out.println("servlet destroy()");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		System.out.println("servlet service()");
		super.service(req, resp);	
	}
}
