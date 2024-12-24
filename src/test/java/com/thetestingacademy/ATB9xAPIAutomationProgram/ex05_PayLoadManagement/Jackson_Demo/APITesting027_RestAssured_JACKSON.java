package com.thetestingacademy.ATB9xAPIAutomationProgram.ex05_PayLoadManagement.Jackson_Demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class APITesting027_RestAssured_JACKSON {
	
	 	RequestSpecification requestSpecification;
	    ValidatableResponse validatableResponse;
	    @Test
	    public void test_Create_Booking_Positive(){

	        // Step1 - POST
	        // URL -> Base URI + base Path
	        // HEADER
	        // BODY
	        // Auth - NO

	        // Step 2
	        // prepare the Payload ( Object -> JSON String)
	        // send the request

	        //Step 3
	        // Validate Response ( JSON String -> Object)
	        // FirstName,
	        // Status Code
	        // Time Response

	        Booking booking = new Booking();
	        booking.setFirstname("febil");
	        booking.setLastname("jose");
	        booking.setTotalprice(112);
	        booking.setDepositpaid(true);

	        Bookingdates bookingdates = new Bookingdates();
	        bookingdates.setCheckin("2024-02-01");
	        bookingdates.setCheckout("2024-02-01");
	        booking.setBookingdates(bookingdates);
	        booking.setAdditionalneeds("Breakfast");

	        System.out.println(booking);
	        
	     // Serialization in Jackson Java Object -> JSON Conversion
	        ObjectMapper objectMapper;
	        objectMapper = new ObjectMapper();
	        String jsonStringBooking;
	        try {
	            jsonStringBooking = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
	        } catch (JsonProcessingException e) {
	            throw new RuntimeException(e);
	        }
	        
	        //Rest Assured-----------------------------------
	        requestSpecification = RestAssured.given();
	        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
	        requestSpecification.basePath("booking");
	        requestSpecification.contentType(ContentType.JSON);
	        requestSpecification.body(jsonStringBooking).log().all();

	        Response response = requestSpecification.when().post();
	        String jsonResponseString  = response.asString();

	        validatableResponse = response.then().log().all();
	        validatableResponse.statusCode(200);
	        
	        // Pay load Extraction------------------
	        
	        // Case1 - extract() - Direct Extraction
	        String firstname1 = response.then().extract().path("booking.firstname");
	        System.out.println(firstname1);

	        // Case 2 - jsonPath.getString("")  JSON Path Extraction

	        JsonPath jsonPath = new JsonPath(response.asString());
	        String bookingId = jsonPath.getString("bookingid");
	        String firstname = jsonPath.getString("booking.firstname");
	        System.out.println(bookingId);
	        System.out.println(firstname);

	        // Case 3 - DeSerialization in Jackson- Extraction -----Mostly used
	        BookingResponse bookingResponse = null;
	        try {
	            bookingResponse = objectMapper.readValue(response.asString(), BookingResponse.class);
	        } catch (JsonProcessingException e) {
	            throw new RuntimeException(e);
	        }
	        
	        //Assertions by AssertJ-------------------------
	        assertThat(bookingResponse.getBookingid()).isNotZero().isNotNull();
	        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("febil").isNotNull().isNotEmpty();
	    }
}