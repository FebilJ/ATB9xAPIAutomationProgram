package com.thetestingacademy.ATB9xAPIAutomationProgram.ex03_testNG_Examples;

import org.testng.annotations.Test;

import org.testng.annotations.Parameters;
import junit.framework.Assert;

public class APITesting021_TestNG_InvocationCount {

	 @Test(invocationCount = 3) //number of run this function
	    public void test01(){
	        Assert.assertTrue(true);
		}
}