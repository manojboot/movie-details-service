//package com.example.demo;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import com.example.movie.Movie;
//import com.example.movie.MovieController;
//import com.example.movie.MovieService;
//
//@RunWith(MockitoJUnitRunner.class)
//public class AWSControllerTest {
//
//	@InjectMocks
//	MovieController awss3Controller;
//	@Mock
//	MovieService aws3Service;
//
//	
//	@Test
//	public void upploadFileToS3Test_With_Response200() {
//		
//		Mockito.when(aws3Service.getAllMovies()).thenReturn(new ArrayList<>());
//		List<Movie> response = awss3Controller.getAllMovies();
//		assertNotNull(response);
//	}
//}
