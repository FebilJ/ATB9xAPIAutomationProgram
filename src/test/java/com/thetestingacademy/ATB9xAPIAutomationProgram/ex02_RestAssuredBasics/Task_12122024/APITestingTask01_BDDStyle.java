package com.thetestingacademy.ATB9xAPIAutomationProgram.ex02_RestAssuredBasics.Task_12122024;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.restassured.RestAssured;

public class APITestingTask01_BDDStyle {

	@Description("Verify the Get All Post_Task01")
    @Test
    public void test_Get_All_Post() {
        //String pin_code = "388620";
        RestAssured
                .given()
		        .baseUri("https://jsonplaceholder.typicode.com")
                //.basePath("/IN/" + pin_code)
                .when()
                .log()
                .all()
                .get()
                .then()
                .log().all()
                .statusCode(200);
    }
	
	@Description("Verify Get Specific Post_Task01")
	@Test
	public void test_GET_Specific_Post() {
		RestAssured
					.given()
			        .baseUri("https://jsonplaceholder.typicode.com")
			        .basePath("/posts/1")
			        .when()
			        .log()
			        .all()
			        .get()
			        .then()
			        .log().all()
			        .statusCode(200);
	}
		
	@Description("Verify GET_POST_BY_USER_Task01")
	@Test
	public void test_GET_POST_BY_USER() {
		RestAssured
					.given()
			        .baseUri("https://jsonplaceholder.typicode.com")
			        .basePath("/posts?userId=1")
			        .when()
			        .log()
			        .all()
			        .get()
			        .then()
			        .log().all()
			        .statusCode(200);
	}
		
	@Description("Neg - GET_INVALID_POST_ID_Task01")
	@Test
	public void test_GET_INVALID_POST_ID() {
		RestAssured
					.given()
					.baseUri("https://jsonplaceholder.typicode.com")
				    .basePath("/posts/999999")
			        .when()
			        .log()
			        .all()
			        .get()
			        .then()
			        .log().all()
			        .statusCode(200);
	}
}