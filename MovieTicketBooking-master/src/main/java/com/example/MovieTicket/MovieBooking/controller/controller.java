package com.example.MovieTicket.MovieBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.example.MovieTicket.MovieBooking.Entity.Movie;
import com.example.MovieTicket.MovieBooking.service.MovieServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class controller {

	
	
	@Autowired
	private MovieServiceInterface todoservice;
//	private TopicService topicService;
//	
	@RequestMapping("/home")
	public String Welcome() {
		//it will automatically converted JSON object
		return "Welcome to CodingNinjas Movies";
	}
	
	@GetMapping(path = "movies")
	public List<Movie> getTodo(){
		
		return todoservice.getMovies();
		
	}
	@GetMapping("/movie/{id}")
//	@ResponseStatus(HttpStatus.OK)
	public Movie getSingleTopdo(@PathVariable long id) {
		
		return todoservice.getMovie(id);
	}
	
	@PostMapping(path = "/movie")
//	@ResponseStatus(HttpStatus.CREATED)
	public List<Movie> addTodo(@Valid @RequestBody Movie todo) {
		System.out.print(todo);
		todoservice.addMovie(todo);
		return todoservice.getMovies();
	}

	 
	@PutMapping(path = "/update/{id}")
//	@ResponseStatus(HttpStatus.ACCEPTED)
	public List<Movie> updateTodo(@Valid @RequestBody Movie topic,@PathVariable long id) {
		System.out.print(topic);
		todoservice.updateMovie(topic,id);
		return todoservice.getMovies();
	} 
//	
	@DeleteMapping(value = "/movie/{id}")
	public List<Movie> deleteTodo(@PathVariable long id) {
		System.out.print(id);
		todoservice.deleteMovie(id);
		return todoservice.getMovies();
	}
	
}
