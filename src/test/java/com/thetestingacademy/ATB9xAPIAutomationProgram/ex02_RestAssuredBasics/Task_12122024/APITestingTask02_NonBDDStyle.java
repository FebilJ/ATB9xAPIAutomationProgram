package com.thetestingacademy.ATB9xAPIAutomationProgram.ex02_RestAssuredBasics.Task_12122024;

import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response; //it is an interface
import org.testng.Assert;

public class APITestingTask02_NonBDDStyle {


	@Description("Verify the Get All Post_Task02")
	@Test
	public void test_GET_ALL_POSTS() {
		
		  Response response = RestAssured
			        .given()
			        .baseUri("https://jsonplaceholder.typicode.com")
			        .basePath("/posts")
			        .when()
			        .get();

			    // Print status code
			    System.out.println("Status Code: " + response.getStatusCode());

			    // Print response body
			    System.out.println("Response Body: " + response.getBody().asString());

//			    // Print headers
//			    System.out.println("Headers: " + response.getHeaders());
		
		
		
//		RestAssured
//							.given()
//							.basePath("https://jsonplaceholder.typicode.com")
//							.basePath("/posts")
//							.when()
//							.log()
//							.all()
//							.get()
//							.then()
//							.log().all()
//							.statusCode(200);
		
//		 String responseBody = RestAssured
//			        .given()
//			        .baseUri("https://jsonplaceholder.typicode.com")
//			        .basePath("/posts")
//			        .when()
//			        		.get()
//			        .then()
//			        		.statusCode(200)
//			        .extract()
//			        .body()
//			        .asString();
//
//			    // Print response body
//			    System.out.println("Response Body: " + responseBody);
		
	}
	
	@Description("Verify the GET_SPECIFIC_POST_Task02")
	@Test
	public void test_GET_SPECIFIC_POST() {
		
		  Response response = RestAssured
			        .given()
			        .baseUri("https://jsonplaceholder.typicode.com")
			        .basePath("/posts/4")
			        .when()
			        .get();

			    // Print status code
			    System.out.println("Status Code: " + response.getStatusCode());

			    // Print response body
			    System.out.println("Response Body: " + response.getBody().asString());
	}
	
	@Description("Verify the GET_POST_BY_USER_Task02")
	@Test
	public void test_GET_POST_BY_USER() {
		
		  Response response = RestAssured
			        .given()
			        .baseUri("https://jsonplaceholder.typicode.com")
			        .basePath("/posts?userId=1")
			        .when()
			        .get();

			    // Print status code
			    System.out.println("Status Code: " + response.getStatusCode());

			    // Print response body
			    System.out.println("Response Body: " + response.getBody().asString());
	}
	
	
	@Description("Neg - GET_INVALID_POST_ID_Task02")
	@Test
	public void test_GET_INVALID_POST_ID() {
		
		  Response response = RestAssured
			        .given()
			        .baseUri("https://jsonplaceholder.typicode.com")
			        .basePath("/posts/999999")
			        .when()
			        .get();
		  			
		  				Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 404");
		  		

			    // Print status code
			    System.out.println("Status Code: " + response.getStatusCode());

			    // Print response body
			    System.out.println("Response Body: " + response.getBody().asString());
	}
}