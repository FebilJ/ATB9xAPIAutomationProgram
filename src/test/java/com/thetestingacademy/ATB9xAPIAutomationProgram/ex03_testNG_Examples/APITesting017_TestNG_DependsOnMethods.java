package com.thetestingacademy.ATB9xAPIAutomationProgram.ex03_testNG_Examples;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class APITesting017_TestNG_DependsOnMethods {

	 @Test
	    public void serverStartedOk() {
	        System.out.println("I will run first");
	        Assert.assertTrue(true);
	    }

	    @Test(dependsOnMethods = "serverStartedOk")
	    public void method1() {
	        System.out.println("method1");
	        Assert.assertTrue(true);
	    }

	    @Test(dependsOnMethods = "serverStartedOk")
	    public void method2() {
	        System.out.println("method1");
	        Assert.assertTrue(true);
		}
}