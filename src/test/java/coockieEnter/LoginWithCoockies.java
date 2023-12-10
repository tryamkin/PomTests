package coockieEnter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

import static io.restassured.RestAssured.given;

public class LoginWithCoockies {
    protected static WebDriver driver;

    public void setUpdrv(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox",
                "--disable-gpu","--disable-dev-shm-usage",
                "--window-size=1920,1080","--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }



    @Test
    public void openPage() {
        setUpdrv();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.get("https://www.demoblaze.com/");
    Cookie getCoockie = new Cookie("tokenp_","VXNlcjEyMzEyMzE3MDI4MjM=");
    driver.manage().addCookie(getCoockie);
    driver.navigate().refresh();

   Cookie cookieUser = driver.manage().getCookieNamed("user");
    driver.navigate().refresh();
        System.out.println(cookieUser);

        driver.get("https://www.demoblaze.com/");


      WebElement nameOfLoginnedUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nameofuser\"]")));
        Assert.assertTrue(nameOfLoginnedUser.isDisplayed());
        driver.close();
        driver.quit();

/*  код на RestAssured
        String sessionid =  given()
            .contentType(ContentType.MULTIPART)
            .cookie("cookieUser",cookieUser)
            .multiPart("username","Usert123123")
            .multiPart("password","Usert123123")
            .multiPart("cookieUser", cookieUser)
            .get("https://www.demoblaze.com/index.html")
            .then().log().all().extract().cookie("user");

        System.out.println(sessionid);*/
}

}
