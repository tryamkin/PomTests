package exampleForYourSite;

import core.BaseSeleniumTest;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Test;


public class GooglePageTest extends BaseSeleniumTest {

    @Test(priority = 1)
    @Description("First test from Description")
    @Owner("Owner Name")
    @Severity(SeverityLevel.CRITICAL)
    @CustomAttribute(name = "Taras ")
    @Step ("First step ")
    @Issue(value = "R2D2 ")
    public void firstTest (){
        MainPage mainPage = new MainPage();
        mainPage.openMainPage();
        Assert.assertEquals(mainPage.getTitlePage(),"Google");
        takeScreenShot();
    }

    @Test (priority = 2)
    public void searchSomethingTest(){
        MainPage mainPage = new MainPage();
        mainPage.searchSomething("Selenium");
        Assert.assertTrue(mainPage.getUrlPage().contains("search"));

    }


    @Test(priority = 3)
    public void searchTResultTest(){
        SearchPage searchPage = new SearchPage();
        Assert.assertTrue(searchPage.setSearchResults()>1000);
        takeScreenShot();
    }


}
