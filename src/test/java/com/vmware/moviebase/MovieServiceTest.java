package com.vmware.moviebase;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class MovieServiceTest {
   
	@Test
	public void addTwoMovieAndGetTheTotal() {
		//Subject Under Test
		MovieService movieService = new MovieService("VMWare Movie Night");  
		movieService.addMovie(new Movie("E.T. - The Extra Terrestrial"));
		movieService.addMovie(new Movie("Wall-E"));
		assertEquals(movieService.getCount(), 2);
	}
	
	@Test
	public void addOneMovieAndGetTheTotal() {}
	
	@Test
	public void getTheTotalWithNoMovies() {}
}
