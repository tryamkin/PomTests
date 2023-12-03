package exampleForYourSite;
import core.BaseSeleniumTest;
import core.ListenerTest;
import io.qameta.allure.*;
import jdk.jfr.Description;
import jdk.jfr.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestValues;

@Label("First package")
@Listeners(ListenerTest.class)
public class GooglePageTest extends BaseSeleniumTest {

    @DataProvider
    public Object[][] data () {
        return new Object[][]{
                {"Test"},{"Sel"},{"hello"}
        };
    }


    @Test(priority = 1)
    @Description("First test open Browser")
    @Owner("Owner Name Could be here")
    @Severity(SeverityLevel.CRITICAL)
    @CustomAttribute(name = "Taras ")
    @Step("First step ")
    @Issue(value = "R2D2orYourValue ")
    public void firstTest() {
        MainPage mainPage = new MainPage().
                openUrlPage();
        Assert.assertTrue(mainPage.getTitlePage().contains("Google"));

    }

    @Test(dataProvider = "data",priority = 2)
    @Description("Second test open Browser")
    public void searchSomethingTest(String param) {
        SearchPage searchPage = new MainPage().
                searchSomething(param);
        System.out.println(searchPage.getUrlPage());
        System.out.println(param);
        Assert.assertTrue(searchPage.getUrlPage().contains(param));

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
       // takeScreenShot();
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
