package com.example.movie;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieException extends RuntimeException{

	
	private static final long serialVersionUID = -5185166520474339733L;
	private String message;
	public MovieException(String message) {
		super();
		this.message = message;
	}
	public MovieException() {
		super();
		
	}

	
}
