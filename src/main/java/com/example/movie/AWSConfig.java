package com.example.movie;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AWSConfig {

	    @Value("${springboot.aws.bucketname}")
	    private String bucketName;
	    @Value("${springboot.aws.accesskey}")
	    private String accessKey;
	    @Value("${springboot.aws.secretkey}")
	    private String secretkey;
		@Bean
		public AmazonS3 s3Configuration() {
			
			AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey,secretkey);
			
					return AmazonS3ClientBuilder
									.standard()
									.withRegion("ap-south-1")
									.withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
									.build();
		}
}
