package com.example.movie;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "movies")
public class Movie {
	
	@Id
	private String id;
	private String title;
	private int year;
	private String imdbId;
	private String genre;
	private int viewerVotes;

}
