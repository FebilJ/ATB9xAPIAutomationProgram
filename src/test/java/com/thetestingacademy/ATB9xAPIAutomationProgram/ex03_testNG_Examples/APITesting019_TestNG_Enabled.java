package com.thetestingacademy.ATB9xAPIAutomationProgram.ex03_testNG_Examples;

import org.testng.annotations.Test;

import org.testng.annotations.Parameters;
import junit.framework.Assert;

public class APITesting019_TestNG_Enabled {

	@Test
    public void test01(){
        Assert.assertTrue(true);
    }

    @Test(enabled = false) //this function will be ignored
    public void test02(){
        Assert.assertTrue(true);
    }

    @Test
    public void test03(){
        Assert.assertTrue(true);
		}
}