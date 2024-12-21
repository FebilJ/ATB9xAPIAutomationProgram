package com.thetestingacademy.ATB9xAPIAutomationProgram.ex02_RestAssuredBasics.GET;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting007_GET_BDDStyle {
	//TODO Auto-generated method stub
	
	@Description("Verify the GET Req Positive_007")
    @Test
    public void test_GET_Req_POSITIVE() {
        String pin_code = "388620";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pin_code)
                .when()
                .log()
                .all()
                .get()
                .then()
                .log().all()
                .statusCode(200);
    }
	
	@Description("Verify the GET Req Negative_007")
    @Test
    public void test_GET_Req_NEGATIVE() {
        String pin_code = "-1";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pin_code)
                .when()
                .log()
                .all()
                .get()
                .then()
                .log().all()
                .statusCode(200);
    }

}