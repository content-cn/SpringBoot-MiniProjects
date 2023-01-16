package com.example.MovieTicket.MovieBooking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.Exceptions.IdAlreadyExist;
import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;
import com.example.MovieTicket.MovieBooking.service.MovieServiceInterface;

@SpringBootTest
class MovieBookingApplicationTests {

	@Autowired
	private MovieServiceInterface todoservice;
	
	
	@Test
	void testCreateMovie() {
		Movie m=new Movie("3","Black Panther","Joe Johnston ", 4, "Englis1",
				new ArrayList<>(List.of("Christopher Marku1", "Stephen McFeel1","Joe Simo1")),
				new ArrayList<>(List.of("Chris Evan1", "Stephen McFeel1","Samuel L. Jackso1")),
				new ArrayList<>(List.of("Adventures1", "Action1"))
			);
		todoservice.updateMovie(m,"3");
		assertNotNull(todoservice.getMovie("3"));			
	}
	
	@Test
	void updateMovie() {
		Movie m=new Movie("3","Black Panther","Joe Johnston ", 4, "Englis1",
				new ArrayList<>(List.of("Christopher Marku1", "Stephen McFeel1","Joe Simo1")),
				new ArrayList<>(List.of("Chris Evan1", "Stephen McFeel1","Samuel L. Jackso1")),
				new ArrayList<>(List.of("Adventures1", "Action1"))
			);
		todoservice.addMovie(m);
		assertNotNull(todoservice.getMovie("3"));			
	}
	
	void updateMovie2(){
		Movie m=new Movie("3","Black Panther","Joe Johnston ", 4, "Englis1",
				new ArrayList<>(List.of("Christopher Marku1", "Stephen McFeel1","Joe Simo1")),
				new ArrayList<>(List.of("Chris Evan1", "Stephen McFeel1","Samuel L. Jackso1")),
				new ArrayList<>(List.of("Adventures1", "Action1"))
			);
		todoservice.deleteMovie("3");
		todoservice.addMovie(m);
		assertNotNull(todoservice.getMovie("3"));			
	}
	
	@Test
	void deleteMovie() {
		Movie m=new Movie("3","Black Panther","Joe Johnston ", 4, "Englis1",
				new ArrayList<>(List.of("Christopher Marku1", "Stephen McFeel1","Joe Simo1")),
				new ArrayList<>(List.of("Chris Evan1", "Stephen McFeel1","Samuel L. Jackso1")),
				new ArrayList<>(List.of("Adventures1", "Action1"))
			);
		todoservice.addMovie(m);
//		String test1= todoservice.deleteMovie("3");

//		System.out.println(test1);
//		assertEquals(test1,"Success In Deletion");
	}
	
	//Exception Test
	@Test
	void ExceptionCheck(){
		try {
		Movie test1=todoservice.getMovie("3");
		}catch(IdNotFound e) {
				System.out.println("Exception Handling : Id is Not Available");
		}
	}
	
	@Test
	void ExceptionCheck2(){
		Movie m=new Movie("3","Black Panther","Joe Johnston ", 4, "Englis1",
				new ArrayList<>(List.of("Christopher Marku1", "Stephen McFeel1","Joe Simo1")),
				new ArrayList<>(List.of("Chris Evan1", "Stephen McFeel1","Samuel L. Jackso1")),
				new ArrayList<>(List.of("Adventures1", "Action1"))
			);
		todoservice.addMovie(m);
		Movie m2=new Movie("3","Black Panther","Joe Johnston ", 4, "Englis1",
				new ArrayList<>(List.of("Christopher Marku1", "Stephen McFeel1","Joe Simo1")),
				new ArrayList<>(List.of("Chris Evan1", "Stephen McFeel1","Samuel L. Jackso1")),
				new ArrayList<>(List.of("Adventures1", "Action1"))
			);
		try {
			todoservice.addMovie(m2);
		}catch(IdAlreadyExist e) {
				System.out.println("Exception Handling : Id is Already Avaliable");
		}
	}

}
