package com.example.movie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController extends ResponseEntityExceptionHandler {

	
		@ExceptionHandler(MovieException.class)
		public ResponseEntity<Object> handleMovieException(MovieException ex,WebRequest request){
			
			List<String> list = new ArrayList<>();
			list.add(ex.getLocalizedMessage());
			ErrorResponse response = new ErrorResponse("Movie Details Doesn't Exist",list);
			return new ResponseEntity<Object>(response,HttpStatus.BAD_REQUEST);
		}
}
