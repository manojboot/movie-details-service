package com.example.movie;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/aws")
public class AWSS3Controller {

	private AWS3Service aws3Service;
	public AWSS3Controller(AWS3Service aws3Service) {
		super();
		this.aws3Service = aws3Service;
	}


	@PostMapping("/upload")
	public ResponseEntity<CommonResponse> upploadFileToS3(MultipartFile file) {
		
		 CommonResponse response = aws3Service.upploadFileToS3(file);
	     return ResponseEntity.ok(response);
		
	}
}
