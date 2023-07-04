package com.example.movie;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

	private MovieRepository movieRepository;
	private MoviePagingRepository moviePagingRepository;
	public MovieService(MovieRepository movieRepository,MoviePagingRepository moviePagingRepository) {
		super();
		this.movieRepository = movieRepository;
		this.moviePagingRepository = moviePagingRepository;
	}
	
	
	public List<Movie> getAllMovies() {
		
		Pageable paging = PageRequest.of(1, 200);
		Page<Movie> pagedMovies =  moviePagingRepository.findAll(paging);
		List<Movie> movies;
		if(pagedMovies.hasContent()) {
			 movies = pagedMovies.getContent();
		}else {
			 throw new MovieException("Movie details doesnot exist");
		}
		return movies;
	}
	
	
	public String findAllMoviesByGenreAndYear(String genre,int year) {
		
		long count = moviePagingRepository.count();
		System.out.println(count);
		Optional<Movie> movies = moviePagingRepository.findAllByGenreAndYear(genre,year);
		if(movies.isEmpty()) {
			 throw new MovieException("Movie details doesnot exist");
		}else {
			movies.get();
		}
		return movies.get().getTitle();
	}
	
	public Movie getMovieById(String imdbId) {
		
		Movie movie;
		Optional<Movie> movies = movieRepository.getMovieByImdbId(imdbId);
		if(movies.isEmpty()) {
			 throw new MovieException("Movie details doesnot exist");
		}else {
			movie = movies.get();
		}
		return movie;
	}
}
