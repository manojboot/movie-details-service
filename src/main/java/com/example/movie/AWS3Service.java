package com.example.movie;

import java.io.ObjectInputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
public class AWS3Service {

	private AWSConfig awsConfig;

	public AWS3Service(AWSConfig awsConfig) {
		super();
		this.awsConfig = awsConfig;
	}

	@Value("${springboot.aws.bucketname}")
	private String bucketName;


	public CommonResponse upploadFileToS3(MultipartFile file) {
		CommonResponse response = new CommonResponse();
	    try {
	        ObjectMetadata metaData = new ObjectMetadata();
	        metaData.setContentLength(file.getSize());
	        awsConfig.s3Configuration().putObject(bucketName, file.getOriginalFilename(), file.getInputStream(), metaData);
	        response.setDescription("File Uploaded SuccessFully");
	        response.setStatusCode("200");
	    } catch (Exception e) {
	       e.printStackTrace();
	    }
	    return response;
	}
}
