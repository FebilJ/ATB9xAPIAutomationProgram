package com.thetestingacademy.ATB9xAPIAutomationProgram.ex05_PayLoadManagement;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;

public class APITesting_025_RestAssured_Payload_POJO {
	

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingID;
    String firstname;


    @Test
    public void test_POST(){

//        String payload_POST = "{\n" +
//                "    \"firstname\" : \"Jim\",\n" +
//                "    \"lastname\" : \"Brown\",\n" +
//                "    \"totalprice\" : 111,\n" +
//                "    \"depositpaid\" : true,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2018-01-01\",\n" +
//                "        \"checkout\" : \"2019-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Breakfast\"\n" +
//                "}";
        	//Introducing POJO in to store
        	Booking booking = new Booking();
        	 booking.setFirstname("Febil");
        	 booking.setLastname("jose");
             booking.setTotalPrice(123);
             booking.setDepositpaid(true);

             BookingDates bookingDates = new BookingDates();
             bookingDates.setCheckin("2024-01-01");
             bookingDates.setCheckout("2024-01-01");
             booking.setBookingDates(bookingDates);
             booking.setBookingDates(bookingDates);
             booking.setAdditionalneeds("Breakfast");

            System.out.println(booking);
            
            requestSpecification = RestAssured.given();
            requestSpecification.baseUri("https://restful-booker.herokuapp.com");
            requestSpecification.basePath("/booking");
            requestSpecification.contentType(ContentType.JSON);
            requestSpecification.body(booking).log().all();

            Response response = requestSpecification.when().post();

            //get validatable response to perform validation
            validatableResponse = response.then().log().all();
            validatableResponse.statusCode(200);
            
         // AssertJ( 3rd- Lib to Assertions)

            //assertThat(bookingID).isNotNull().isNotZero().isPositive();
            assertThat(firstname).isEqualTo("Febil").isNotEmpty().isNotNull().isNotBlank();
	}
}