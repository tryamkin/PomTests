package exampleForYourSite1.exampleForYourSite;

import core.BaseSeleniumTest;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureId;
import io.qameta.allure.Attachment;
import jdk.jfr.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import io.qameta.allure.Allure;



public class GooglePageTest extends BaseSeleniumTest {

    @Test(priority = 1)
    @Description("First test")
    @CustomAttribute(name = "Taras ")
    @AllureId("Allure smth annotation")
    @Attachment()
    public void firstTest (){
        MainPage mainPage = new MainPage();
        mainPage.openMainPage();
        Assert.assertEquals(mainPage.getTitlePage(),"Google");


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
    }


}
