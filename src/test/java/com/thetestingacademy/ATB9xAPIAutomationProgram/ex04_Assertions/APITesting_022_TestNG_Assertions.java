package com.thetestingacademy.ATB9xAPIAutomationProgram.ex04_Assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class APITesting_022_TestNG_Assertions {
	

    @Test
    public void test_hardAssertExample(){
        System.out.println("Start of the program");
        Boolean is_neeru_male = false;
       // Assert.assertTrue(is_neeru_male);
        System.out.println("End of the program");

        Assert.assertEquals("Akshay","Akshay");
    }

    @Test
    public void test_soft_AssertExample(){

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false);
        System.out.println("This line will be executed");
        softAssert.assertAll(); //This will report all collected errors
	}
}