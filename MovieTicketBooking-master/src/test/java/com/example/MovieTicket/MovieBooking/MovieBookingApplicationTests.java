package com.example.MovieTicket.MovieBooking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.MovieTicket.MovieBooking.Entity.Movie;
import com.example.MovieTicket.MovieBooking.service.MovieServiceInterface;

@SpringBootTest
class MovieBookingApplicationTests {

	@Autowired
	private MovieServiceInterface todoservice;
	
	
	@Test
	void testCreateMovie() {
		Movie m=new Movie(3,"lack Panther","Joe Johnston ", "7.2", "Englis1",
				new ArrayList<>(List.of("Christopher Marku1", "Stephen McFeel1","Joe Simo1")),
				new ArrayList<>(List.of("Chris Evan1", "Stephen McFeel1","Samuel L. Jackso1")),
				new ArrayList<>(List.of("Adventures1", "Action1"))
			);
		todoservice.updateMovie(m,1);
		assertNotNull(todoservice.getMovie(3));			
	}
	
	@Test
	void updateMovie() {
		Movie m=new Movie(2,"Black Panther","Joe Johnston ", "7.2", "Englis1",
				new ArrayList<>(List.of("Christopher Marku1", "Stephen McFeel1","Joe Simo1")),
				new ArrayList<>(List.of("Chris Evan1", "Stephen McFeel1","Samuel L. Jackso1")),
				new ArrayList<>(List.of("Adventures1", "Action1"))
			);
		todoservice.addMovie(m);
		assertNotNull(todoservice.getMovie(2));			
	}
	
	@Test
	void deleteMovie() {
		Movie m=new Movie(4,"Black Panther","Joe Johnston ", "7.2", "Englis1",
				new ArrayList<>(List.of("Christopher Marku1", "Stephen McFeel1","Joe Simo1")),
				new ArrayList<>(List.of("Chris Evan2", "Stephen McF2el1","Samuel2L. Jackso2")),
				new ArrayList<>(List.of("Adventur2s1", "Actio21"))
			);
		todoservice.addMovie(m);
		String test1=todoservice.deleteMovie(4);
//		System.out.print(todoservice.deleteMovie(2));
//		if(todoservice.getMovie(2)==null) {
//			
//		}
		System.out.print(test1);
		assertEquals(test1,"Success In Deletion");
	}

}
