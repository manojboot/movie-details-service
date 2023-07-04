package com.example.movie;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

	@Query("{imdbId:?0}")
	public Optional<Movie> getMovieByImdbId(String imdbId);
}
