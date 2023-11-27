package exampleForYourSite;

import core.BaseSeleniumPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;


public class MainPage extends BaseSeleniumPage {

    @FindBy(xpath = "//textarea[@id='APjFqb']")
    private WebElement searchField;


    //Конструктор на главной странице
    public MainPage() {

        Logger log = Logger.getLogger(MainPage.class.getName());
        log.info("open");
        PageFactory.initElements(driver, this);
    }

    public void openMainPage() {
        driver.get("https://google.com.ua");
    }

    public String  getTitlePage() {
        return driver.getTitle();
    }

    public void searchSomething(String search) {
        openMainPage();
        searchField.click();
        searchField.sendKeys(search);
        searchField.sendKeys(Keys.ENTER);
    }

    public String getUrlPage() {

        return    driver.getCurrentUrl();
    }
}
