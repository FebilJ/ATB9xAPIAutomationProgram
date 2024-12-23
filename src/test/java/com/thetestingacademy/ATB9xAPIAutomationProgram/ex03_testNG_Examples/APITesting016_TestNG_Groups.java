package com.thetestingacademy.ATB9xAPIAutomationProgram.ex03_testNG_Examples;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class APITesting016_TestNG_Groups {

	@Test(groups = {"sanity", "qa","prod", "P0"})
    public void sanityRun() {
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"reg", "P1"})
    public void RegRun() {
        System.out.println("Reg");
        Assert.assertTrue(false);
    }

    @Test(groups = {"qa", "P0"})
    public void SmokeRun() {
        System.out.println("Smoke");
        Assert.assertTrue(false);
		}
}