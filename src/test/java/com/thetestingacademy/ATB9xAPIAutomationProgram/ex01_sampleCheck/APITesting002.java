package com.thetestingacademy.ATB9xAPIAutomationProgram.ex01_sampleCheck;

import io.restassured.RestAssured;
public class APITesting002 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Hello");
		
		//Gherkins Syntax
		//Given() -> Pre re. -URL, Headers, Auth, Body....
		//When() -> HTTP method?  -GET/POST/PUT/PATCH, DELETE.....
		//Then() -> Validation -> 200 OK, firstname == FEBIL
		
		//Full URL - https://api.zippopotam.us/IN/370205
		//base URI - https://api.zippopotam.us
		//Path - IN/370205
		
		RestAssured
							.given()
										.baseUri("https://api.zippopotam.us")
										.basePath("IN/370205")
							.when()
										.get()
							.then().log().all().statusCode(200);
	}
}