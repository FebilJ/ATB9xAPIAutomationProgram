package com.thetestingacademy.ATB9xAPIAutomationProgram.ex02_RestAssuredBasics.PATCH;

import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class APITesting012_PATCH_NONBDDStyle {
		
		RequestSpecification r;
		Response response;
		ValidatableResponse vr;
		
	    @Description("Verify the Patch Request for the Restful Booker APIs")
		@Test
		public void test_patch_non_bdd(){
	    	
	    	String token = "e6ffdd48c67cb60";
	        String bookingid = "360";
	        
	        String payload ="{\n" +
	                "    \"firstname\" : \"Jim\",\n" +
	                "    \"lastname\" : \"Brown\",\n" +
	                "    \"totalprice\" : 111,\n" +
	                "    \"depositpaid\" : true,\n" +
	                "    \"bookingdates\" : {\n" +
	                "        \"checkin\" : \"2018-01-01\",\n" +
	                "        \"checkout\" : \"2019-01-01\"\n" +
	                "    },\n" +
	                "    \"additionalneeds\" : \"Breakfast\"\n" +
	                "}";

		    RequestSpecification r = RestAssured.given();
		    									 r.baseUri("https://restful-booker.herokuapp.com");
		    									 r.basePath("/booking/" + bookingid);
		    									 r.contentType(ContentType.JSON);
		    									 r.cookie("token", token);
		    									 r.body(payload).log().all();

		    Response response1 = r.when().put();
		    
		    ValidatableResponse vr = response1.then().log().all().statusCode(403);
		    }
	} 