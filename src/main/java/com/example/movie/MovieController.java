package com.example.movie;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
	
	private MovieService movieService;
	public MovieController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}


	@GetMapping(value="all",produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
//	@PreAuthorize("hasRole('ROLE_SpringAzureSecurity')")
	public List<Movie> getAllMovies() {
		
		List<Movie> movies  = movieService.getAllMovies();
		return movies;
		
	}
	
	@GetMapping("/moviesbygenre/{genre}/{year}")
	public String findAllMoviesByGenreAndYear(@PathVariable String genre,@PathVariable int year) {
		
		String movies  = movieService.findAllMoviesByGenreAndYear(genre,year);
		return movies;
		
	}
	
	@GetMapping("/{imdbId}")
	public Movie findAllMoviesByGenreAndYear(@PathVariable String imdbId) {
		
		Movie movie  = movieService.getMovieById(imdbId);
		return movie;
		
	}
}
