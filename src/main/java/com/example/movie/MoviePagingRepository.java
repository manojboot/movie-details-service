package com.example.movie;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviePagingRepository extends PagingAndSortingRepository<Movie, String>{

	
	public Optional<Movie> findAllByGenreAndYear(String genre,int year);
}
