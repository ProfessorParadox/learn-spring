package com.projects.AWSwithJavaSDK;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.rekognition.RekognitionClient;
import software.amazon.awssdk.services.rekognition.model.RekognitionException;
import software.amazon.awssdk.services.rekognition.model.DetectFacesRequest;
import software.amazon.awssdk.services.rekognition.model.DetectFacesResponse;
import software.amazon.awssdk.services.rekognition.model.Image;
import software.amazon.awssdk.services.rekognition.model.Attribute;
import software.amazon.awssdk.services.rekognition.model.FaceDetail;
import software.amazon.awssdk.services.rekognition.model.AgeRange;
import software.amazon.awssdk.core.SdkBytes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class DetectFaces {

	public static void main(String[] args) {

		/*final String USAGE = "\n" + "Usage: " + "   <sourceImage>\n\n" + "Where:\n"
				+ "   sourceImage - the path to the image (for example, C:\\AWS\\pic1.png). \n\n";

		if (args.length != 1) {
			System.out.println(USAGE);
			System.exit(1);
		}

		String sourceImage = args[0];*/
		String sourceImage = "C:\\temp\\aws\\myimage.jpg";
		Region region = Region.AP_SOUTH_1;
		RekognitionClient rekClient = RekognitionClient.builder().region(region).build();

		detectFacesinImage(rekClient, sourceImage);
		rekClient.close();
	}

	public static void detectFacesinImage(RekognitionClient rekClient, String sourceImage) {

		try {
			InputStream sourceStream = new FileInputStream(new File(sourceImage));
			SdkBytes sourceBytes = SdkBytes.fromInputStream(sourceStream);

			// Create an Image object for the source image.
			Image souImage = Image.builder().bytes(sourceBytes).build();

			DetectFacesRequest facesRequest = DetectFacesRequest.builder().attributes(Attribute.ALL).image(souImage)
					.build();

			DetectFacesResponse facesResponse = rekClient.detectFaces(facesRequest);
			List<FaceDetail> faceDetails = facesResponse.faceDetails();

			for (FaceDetail face : faceDetails) {
				AgeRange ageRange = face.ageRange();
				System.out.println("The detected face is estimated to be between " + ageRange.low().toString() + " and "
						+ ageRange.high().toString() + " years old.");

				System.out.println("There is a smile : " + face.smile().value().toString());
			}

		} catch (RekognitionException | FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}

}