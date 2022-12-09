package com.example.MovieTicket.MovieBooking.Entity;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
//
//The class contains the validation over here so that we can validate the entry type when we are using postMapping in controller
//
public class Movie {
	public long id;
	
	@NotNull
	@Size(min=4, message="movieName cannot be of less then 4 size")
	public String movieName;
	
	@NotNull
	public String movieDirector;
	
	@NotBlank(message="Movie Rating Cannot Be Blank")
	public String movieRating;
	
	@Size(min=1,message="required")  
	public String movieLanguage;
	public List<String> writers;
	public List<String> actors;
	public List<String> genre;
	
	//Movie Constructor
	public Movie(long id, String movieName, String movieDirector, String movieRating, String movieLanguage,
			List<String> writers, List<String> actors, List<String> genre) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.movieDirector = movieDirector;
		this.movieRating = movieRating;
		this.movieLanguage = movieLanguage;
		this.writers = writers;
		this.actors = actors;
		this.genre = genre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public String getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(String movieRating) {
		this.movieRating = movieRating;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public List<String> getWriters() {
		return writers;
	}

	public void setWriters(List<String> writers) {
		this.writers = writers;
	}

	public List<String> getActors() {
		return actors;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}

	public List<String> getGenre() {
		return genre;
	}

	public void setGenre(List<String> genre) {
		this.genre = genre;
	}
	

}
