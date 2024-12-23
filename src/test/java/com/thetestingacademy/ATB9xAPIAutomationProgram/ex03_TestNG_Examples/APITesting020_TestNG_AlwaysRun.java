package com.thetestingacademy.ATB9xAPIAutomationProgram.ex03_TestNG_Examples;

import org.testng.annotations.Test;

import org.testng.annotations.Parameters;
import junit.framework.Assert;

public class APITesting020_TestNG_AlwaysRun {

	@Test
    public void test01(){
        Assert.assertTrue(true);
    }

    @Test(alwaysRun = true) //this function will run always
    public void test02(){
        Assert.assertTrue(true);
    }

    @Test
    public void test03(){
        Assert.assertTrue(true);
		}
}