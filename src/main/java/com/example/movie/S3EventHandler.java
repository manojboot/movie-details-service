package com.example.movie;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StreamUtils;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class S3EventHandler implements RequestHandler<S3Event, String> {
	
	@Autowired
	private AWSConfig awsConfig;
	
	@Override
	public String handleRequest(S3Event s3Event, Context context) {
		// TODO Auto-generated method stub
		log.info("Lambda function is called to process file uploads -- " +s3Event.toString());
		String bucketName = s3Event.getRecords().get(0).getS3().getBucket().getName();
		String fileName = s3Event.getRecords().get(0).getS3().getObject().getKey();
		
		log.info("File in S3 is :" +fileName +"Uploaded into Bucketname : "+bucketName +"at time :" +s3Event.getRecords().get(0).getEventTime());
		try (InputStream is = awsConfig.s3Configuration().getObject(bucketName, fileName).getObjectContent()) {
            log.info("File Contents : "+StreamUtils.copyToString(is, StandardCharsets.UTF_8));
        }catch (IOException e){
            e.printStackTrace();
            return "Error reading contents of the file";
        }
        return null;
	}
	
	

}
