package exampleGooglePage;

import core.BaseSeleniumTest;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Test;


public class GooglePageTest extends BaseSeleniumTest {

    @Test
    @Description("First test")
    @CustomAttribute(name = "Taras ")
    public void firstTest (){
        MainPage mainPage = new MainPage();
        mainPage.openMainPage();
        Assert.assertEquals(mainPage.getTitlePage(),"Google");

    }

    @Test
    public void searchSomethingTest(){
        MainPage mainPage = new MainPage();
        mainPage.searchSomething("Selenium");
        Assert.assertTrue(mainPage.getUrlPage().contains("search"));
    }


    @Test (priority = 2)
    public void searchTResultTest(){
        SearchPage searchPage = new SearchPage();
        Assert.assertTrue(searchPage.setSearchResults()>1000);
    }
    @Test (priority = 1)
    public void searchTResultTest1(){
        SearchPage searchPage = new SearchPage();
        Assert.assertTrue(searchPage.setSearchResults()>1000);
    }

}
