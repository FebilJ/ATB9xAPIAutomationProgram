package com.thetestingacademy.ATB9xAPIAutomationProgram.ex06_TestGitPush;

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

public class APITesting_024_RestAssured_Payload_Map {
	

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingID;
    String firstname;


    @Test
    public void test_POST(){

        String payload_POST = "{\n" +
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
        	//Introducing Map in to store
        	Map<String, Object> jsonBodyUsingMap = new LinkedHashMap();
        	jsonBodyUsingMap.put("firstname", "Jim");
        	jsonBodyUsingMap.put("lastname", "brown");
        	jsonBodyUsingMap.put("totalprice", "123");
        	jsonBodyUsingMap.put("depositpaid", "true");
        	
        	Map<String,Object> bookingDatesMap = new LinkedHashMap();
            bookingDatesMap.put("chekin","2018-01-01");
            bookingDatesMap.put("checkout","2019-01-01");
            
            jsonBodyUsingMap.put("bookingdates","bookingDatesMap");
            jsonBodyUsingMap.put("additionalNeeds","Breakfast");
            System.out.println(jsonBodyUsingMap);
            
            requestSpecification = RestAssured.given();
            requestSpecification.baseUri("https://restful-booker.herokuapp.com");
            requestSpecification.basePath("/booking");
            requestSpecification.contentType(ContentType.JSON);
            requestSpecification.body(payload_POST).log().all();

            Response response = requestSpecification.when().post();

            //get validatable response to perform validation
            validatableResponse = response.then().log().all();
            validatableResponse.statusCode(200);
            
         // AssertJ( 3rd- Lib to Assertions)

            assertThat(bookingID).isNotNull().isNotZero().isPositive();
            assertThat(firstname).isEqualTo("Pramod").isNotEmpty().isNotNull().isNotBlank();
	}
}