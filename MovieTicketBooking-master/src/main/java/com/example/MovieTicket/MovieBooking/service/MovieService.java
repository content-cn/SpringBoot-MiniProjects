package com.example.MovieTicket.MovieBooking.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;
import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.communicator.RatingRestCommunicator;

@Service
public class MovieService implements MovieServiceInterface {
	
	List<Movie> moviesList =new ArrayList<>();
	Map<String,Movie> movieMap= new HashMap<>();
	
	@Autowired
	RatingRestCommunicator ratingServiceCommunicator;
	
	
//	public MovieService() {
////		super();
////	moviesList=new ArrayList<>();
////		moviesList.add(new Movie(1,"Captain America","Joe Johnston ", "6.9", "English",
////				new ArrayList<>(List.of("Christopher Markus", "Stephen McFeely","Joe Simon")),
////				new ArrayList<>(List.of("Chris Evans", "Stephen McFeely","Samuel L. Jackson")),
////				new ArrayList<>(List.of("Adventures", "Action"))
////			));
//	}

	@Override
	public List<Movie> getMovies() {
		return moviesList;
	}

	@Override
	public Movie getMovie(String id) {
		
		if(ObjectUtils.isEmpty(movieMap.get(id)))
		{
			throw new IdNotFound("Hotel not found for id: "+id);
		}
		Movie movie = movieMap.get(id);
		
		long updatedRating=ratingServiceCommunicator.getRating(id);
		movie.setMovieRating(updatedRating);
		return movie;
	}

	@Override
	public void addMovie(Movie movie) {
		Map<String, Long> ratingsMap = new HashMap<>();
		
		moviesList.add(movie); 
		movieMap.put(movie.getId(), movie);
		ratingsMap.put(movie.getId(), movie.getMovieRating());
		ratingServiceCommunicator.addRating(ratingsMap);
	}
		

	@Override
	public void deleteMovie(String id) {
		Movie movie = getMovie(id);
		moviesList.remove(movie);
		movieMap.remove(id);
		ratingServiceCommunicator.deleteRating(id);
	}

	@Override
	public void updateMovie(Movie movie, String id) {
        Movie existingMovie= getMovie(id);
		
		moviesList.remove(existingMovie);
		moviesList.add(movie);		
		movieMap.put(id, movie);
		
		Map<String,Long> updatedRating = new HashMap<>();
		updatedRating.put(id, movie.getMovieRating());
		ratingServiceCommunicator.updateRating(updatedRating);
	}

}
