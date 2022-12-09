package com.example.MovieTicket.MovieBooking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import com.example.MovieTicket.MovieBooking.Entity.Movie;
import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;

@Service
public class MovieService implements MovieServiceInterface {
	
	//List of Movie objects that stores local data
	List<Movie> moviesList;
	
	
	public MovieService() {
//		super();
	moviesList=new ArrayList<>();
		moviesList.add(new Movie(1,"Captain America","Joe Johnston ", "6.9", "English",
				new ArrayList<>(List.of("Christopher Markus", "Stephen McFeely","Joe Simon")),
				new ArrayList<>(List.of("Chris Evans", "Stephen McFeely","Samuel L. Jackson")),
				new ArrayList<>(List.of("Adventures", "Action"))
			));
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Movie> getMovies() {
		return moviesList;
	}

	@Override
	public Movie getMovie(long id) {
		
		Movie ans=null;
		
		for(int i=0;i<moviesList.size();i++) {
			if(moviesList.get(i).id==id) {
				ans=moviesList.get(i);
			}
		}
		if(ans==null) {
			throw new IdNotFound("Id is Not Available");
		}
		return ans;
	}

	@Override
	public void addMovie(Movie movie) {
		long id1=movie.id;
		for(int i=0;i<moviesList.size();i++) {
			if(moviesList.get(i).id==id1) {
				throw new IdNotFound("Id Already Exist");
				
			}
		}
		moviesList.add(movie);
	}

	@Override
	public String deleteMovie(long id) {
		for(int i=0;i<moviesList.size();i++) {
			if(moviesList.get(i).id==id) {
				moviesList.remove(i);
				return "Success In Deletion";
			}
		}
		return "";
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMovie(Movie movie, long id) {
		for(int i=0;i<moviesList.size();i++) {
			if(moviesList.get(i).id==id) {
				moviesList.remove(i);
				moviesList.add(i, movie);				
				return;
			}
		}
		// TODO Auto-generated method stub

	}

}
