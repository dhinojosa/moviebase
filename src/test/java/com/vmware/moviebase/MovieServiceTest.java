package com.vmware.moviebase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MovieServiceTest {

	private MovieService movieService;

	@BeforeMethod
	public void setUp() {
		movieService = new MovieService("VMWare Movie Night");
	}

	@Test
	public void addTwoMovieAndGetTheTotal() {
		// Subject Under Test
		movieService.addMovie(new Movie("E.T. - The Extra Terrestrial"));
		movieService.addMovie(new Movie("Wall-E"));
		assertEquals(movieService.getCount(), 2);
	}

	@Test
	public void addOneMovieAndGetTheTotal() {
		// Subject Under Test
		movieService.addMovie(new Movie("Wall-E"));
		assertEquals(movieService.getCount(), 1);
	}

	@Test
	public void getTheTotalWithNoMovies() {
		// Subject Under Test
		assertEquals(movieService.getCount(), 0);
	}

	@Test
	public void removeAMovieAndGetTheTotal() throws MovieException {
		movieService.addMovie(new Movie("E.T. - The Extra Terrestrial"));
		movieService.addMovie(new Movie("Wall-E"));
		movieService.removeByName("Wall-E");
		assertEquals(movieService.getCount(), 1);
	}

	@Test
	public void removeAMovieFromAnEmptyService() {
		try {
			movieService.removeByName("Wall-E");
			fail("Was exepecting an exception in removeAMovieFromAnEmptyService");
		} catch (MovieException e) {
			assertEquals(e.getMessage(), "There are no movies in the service");
		}
	}

	@Test
	public void removeAMovieThatDoesntExist() {
		movieService.addMovie(new Movie("E.T. - The Extra Terrestrial"));
		movieService.addMovie(new Movie("Wall-E"));
		try {
			movieService.removeByName("Titanic");
			fail("Was expecting an exception in removeAMovieThatDoesntExist");
		} catch (MovieException e) {
			assertEquals(e.getMessage(), "That movie does not exist in the service");
		}
	}
	
	@Test
	public void removeAMovieCalledStripesThatDoesntExist() {
		movieService.addMovie(new Movie("E.T. - The Extra Terrestrial"));
		movieService.addMovie(new Movie("Wall-E"));
		try {
			movieService.removeByName("Stripes");
			fail("Was expecting an exception in removeAMovieThatDoesntExist");
		} catch (MovieException e) {
			assertEquals(e.getMessage(), "That movie does not exist in the service");
		}
	}
}
