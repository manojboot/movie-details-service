package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.movie.AWSS3Controller;

@SpringBootTest
public class AWSControllerTest {

	@InjectMocks
	private AWSS3Controller awss3Controller;
	
	@Test
	public void upploadFileToS3Test_With_Response200() {
		
		awss3Controller.upploadFileToS3(null);
	}
}
