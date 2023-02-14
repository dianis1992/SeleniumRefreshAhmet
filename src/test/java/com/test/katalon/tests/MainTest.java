package com.test.katalon.pages;

import com.test.katalon.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends TestBase {
    // we have beforemethod and aftermethod

    @Test

    public void validateUrlAndHeader(){
        MainPage mainPage = new MainPage(driver);
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/");// assert is a class,
        Assert.assertEquals(mainPage.actualHeader(),"CURA Healthcare Service");

    }


}
