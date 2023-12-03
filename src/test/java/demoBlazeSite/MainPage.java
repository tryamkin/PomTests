package demoBlazeSite;

import core.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;



public class MainPage extends BaseSeleniumPage {

    @FindBy(xpath = "//*[@id=\"login2\"]")
    WebElement loginLink;
    @FindBy(xpath = "//input[@id='loginusername']")
    WebElement loginusername;
    @FindBy(xpath = "//input[@id='loginpassword']")
    WebElement loginpassword;
    @FindBy(xpath = "//button[normalize-space()='Log in']")
    WebElement buttonLogIn;
    @FindBy(xpath = "//*[@id=\"nameofuser\"]")
    WebElement nameOfLoginnedUser;


    public MainPage() {
        PageFactory.initElements(driver, this);
    }


    public String login() {
        return "User123123";
    }

    public String pussword() {
        return "User123123";
    }

    public void openMainPage() {
        driver.get("https://www.demoblaze.com/");
    }

    public void switchToActiveForm() {
        driver.switchTo().activeElement();

    }

    public void feelLoginForm() {
        loginusername.sendKeys(Keys.ENTER, login());
        loginpassword.sendKeys(Keys.ENTER, pussword());
        buttonLogIn.click();
    }

    public WebElement nameOfLoggedUser() {
        return nameOfLoginnedUser;
    }

    public MainPage loginOnTheSite() {
        openMainPage();
        loginLink.click();
        switchToActiveForm();
        feelLoginForm();
        //todo - вынести в отдельный метод

        nameOfLoginnedUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nameofuser\"]")));
        return this;
    }


}
