package exampleForYourSite;

import core.BaseSeleniumPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestValues;

import java.util.logging.Logger;


public class MainPage extends BaseSeleniumPage {

    @FindBy(xpath = "//textarea[@id='APjFqb']")
    private WebElement searchField;

    //Конструктор на главной странице
    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public void openMainPage() {
        driver.get(TestValues.URL);
        Logger log = Logger.getLogger(MainPage.class.getName());
        log.info("open Page " + driver.getCurrentUrl());
    }

    public String getTitlePage() {
        return driver.getTitle();
    }

    public SearchPage searchSomething(String search) {
        openMainPage();
        searchField.click();
        searchField.sendKeys(search);
        searchField.sendKeys(Keys.ENTER);
        return new SearchPage();
    }

    public String getUrlPage() {
        return driver.getCurrentUrl();

    }

    public MainPage openUrlPage() {
        openMainPage();
        driver.getCurrentUrl();
        return this;
    }

    public CalcPage calc() {
        openMainPage();
        searchField.click();
        searchField.sendKeys("2+2=");
        searchField.sendKeys(Keys.ENTER);
        return new CalcPage();
    }

}
