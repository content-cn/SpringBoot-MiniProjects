package com.example.MovieTicket.MovieBooking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.MovieTicket.MovieBooking.Entity.Movie;

@Service
public interface MovieServiceInterface {

	

	Movie getMovie(long id);

	void addMovie(Movie todo);

	String deleteMovie(long id);

	void updateMovie(Movie topic, long id);

	List<Movie> getMovies();

//	void save(Movie m);
}
