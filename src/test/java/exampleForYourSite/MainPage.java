package exampleForYourSite;

import core.BaseSeleniumPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage extends BaseSeleniumPage {

    @FindBy(xpath = "//textarea[@id='APjFqb']")
    private WebElement searchField;


    //Конструктор на главной странице
    public MainPage() {
        driver.get("https://google.com.ua");
        PageFactory.initElements(driver, this);
    }

    public void openMainPage() {
    }

    public String  getTitlePage() {
        return driver.getTitle();
    }

    public void searchSomething(String search) {
        searchField.click();
        searchField.sendKeys(search);
        searchField.sendKeys(Keys.ENTER);
    }

    public String getUrlPage() {
     return    driver.getCurrentUrl();
    }
}
