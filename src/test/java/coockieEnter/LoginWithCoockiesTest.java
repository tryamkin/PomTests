package coockieEnter;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.ByteArrayInputStream;
import java.time.Duration;


public class LoginWithCoockiesTest {
    protected static WebDriver driver;

    public void takeScreenShot(){
        Allure.addAttachment(new Throwable()
                .getStackTrace()[1]
                .getMethodName(), new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }

    public void setUpdrv() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox",
                "--disable-gpu", "--disable-dev-shm-usage",
                "--window-size=1920,1080", "--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }


    @Test
    public void loginWithCoockiesTest() {
        setUpdrv();
        driver.get("https://www.demoblaze.com/");
        takeScreenShot();
        logWithCoockies();
        tearDown();
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
        public void logWithCoockies(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Cookie getCoockie = new Cookie("tokenp_", "VXNlcjEyMzEyMzE3MDI4MjM=");
            driver.manage().addCookie(getCoockie);
            driver.navigate().refresh();
            Cookie cookieUser = driver.manage().getCookieNamed("user");
            driver.navigate().refresh();
            System.out.println(cookieUser);
            driver.get("https://www.demoblaze.com/");
            WebElement nameOfLoginnedUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nameofuser\"]")));
            Assert.assertTrue(nameOfLoginnedUser.isDisplayed());
            takeScreenShot();
        }

        public void tearDown(){
            driver.close();
            driver.quit();
        }
}
