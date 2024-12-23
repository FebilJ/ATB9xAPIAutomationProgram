package com.thetestingacademy.ATB9xAPIAutomationProgram.ex02_RestAssuredBasics.POST;

import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class APITesting009_POST_NonBDDStyle {
		
		RequestSpecification r;
		Response response;
		ValidatableResponse vr;
		
		@Description("Verify the POST Req Postive")
		@Test
		    public void test_POST_NONBDDStyle(){

		    String payload = " {\n" +
		            "    \"username\" : \"admin\",\n" +
		            "    \"password\" : \"password123\"\n" +
		            "}";

		     RestAssured.given()
		    					  .baseUri("https://restful-booker.herokuapp.com")
		    					  .basePath("/auth")
		    					  .contentType(ContentType.JSON)
		    					  .log().all().body(payload)
		    					  .when().log().all().post()
		    					  .then().log().all().statusCode(200);
		    }
	} 