package com.vmware.moviebase;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

	private int count = 0;
	private List<Movie> movies = new ArrayList<Movie>();  //NEW!
    
    
	public MovieService(String title) {
	}

	public void addMovie(Movie movie) {
		count++;
		movies.add(movie);                                //NEW!
	}

	public int getCount() {
		return count;
	}

	public void removeByName(String name) throws MovieException {
		if (count == 0)
			throw new MovieException("There are no movies in the service");
		
		for (Movie m : movies) {
			if (m.getName().equals(name)) {
				movies.remove(m);
				count--;
				return;
			}
		}
		
		throw new MovieException("That movie does not exist in the service");
	}
}
