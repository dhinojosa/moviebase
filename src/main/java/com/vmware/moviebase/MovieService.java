package com.vmware.moviebase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MovieService {

	private Set<String> movies = new HashSet<String>();  //NEW!
    
	public MovieService(String title) {
	}

	public void addMovie(Movie movie) throws MovieException {
		if (movies.contains(movie.getName())) 
			throw new MovieException("Movie already exists"); 
		movies.add(movie.getName());                                //NEW!
	}

	public int getCount() {
		return movies.size();
	}

	public void removeByName(String name) throws MovieException {
		if (getCount() == 0)
			throw new MovieException("There are no movies in the service");
		
		if (!movies.remove(name)) {
			throw new MovieException("That movie does not exist in the service");	
		}
	}
}
