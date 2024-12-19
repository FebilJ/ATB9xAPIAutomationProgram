package com.thetestingacademy.ATB9xAPIAutomationProgram.ex02_RestAssuredBasics.GET;

import io.restassured.RestAssured;

public class APITesting006_GET_BDDStyle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String pincode = "560016";

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when().log().all().get()
                .then().log().all().statusCode(200);

        pincode = "-1";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when().log().all().get()
                .then().log().all().statusCode(404);
		
	}

}