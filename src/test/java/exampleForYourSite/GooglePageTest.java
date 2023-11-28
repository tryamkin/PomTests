package exampleForYourSite;
import core.BaseSeleniumTest;
import io.qameta.allure.*;
import jdk.jfr.Description;
import jdk.jfr.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Test;
import utils.TestValues;

@Label("First package")
public class GooglePageTest extends BaseSeleniumTest {

    @Test(priority = 1)
    @Description("First test open Browser")
    @Owner("Owner Name")
    @Severity(SeverityLevel.CRITICAL)
    @CustomAttribute(name = "Taras ")
    @Step("First step ")
    @Issue(value = "R2D2 ")
    public void firstTest() {
        MainPage mainPage = new MainPage().
                openUrlPage();
        Assert.assertTrue(mainPage.getTitlePage().contains("Google"));
    }

    @Test(priority = 2)
    @Description("Second test open Browser")
    public void searchSomethingTest() {
        SearchPage searchPage = new MainPage().
                searchSomething(TestValues.SEARCH_EXAMPLE);
        Assert.assertTrue(searchPage.getUrlPage().contains("search"));

    }


    @Test(priority = 3)
    public void searchTResultTest() {
        SearchPage searchResult = new MainPage().
                openUrlPage().
                searchSomething(TestValues.SEARCH_EXAMPLE);
        Assert.assertTrue(searchResult.setSearchResults() > 1000);

    }

    @Test
    public void calcTest() {
        CalcPage calcPage = new MainPage().
                openUrlPage().
                calc();
        Assert.assertEquals(calcPage.getAnswer(), 4);
        takeScreenShot();
    }

    @Test
    public void exampleSimpleTest(){
        driver.get(TestValues.URL);
        driver.getTitle();
        WebElement inputField = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        inputField.click();
        inputField.sendKeys(TestValues.SEARCH_EXAMPLE);
        inputField.sendKeys(Keys.ENTER);
        driver.getTitle();
        Assert.assertTrue(driver.getCurrentUrl().contains("search"));


    }

}
