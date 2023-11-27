package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

abstract public class BaseSeleniumTest {
    protected WebDriver driver;
    private final String os = System.getProperty("os.name");

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        // для запуска на GitHub CI
        System.out.println(os);
        if (!os.contains("Linux")){
            driver = new ChromeDriver();
        } else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless","--no-sandbox",
                    "--disable-gpu","--disable-dev-shm-usage",
                    "--window-size=1920,1080","--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        BaseSeleniumPage.setDriver(driver);
    }

    public void takeScreenShot(){
        Allure.addAttachment(new Object() {}
                .getClass()
                .getEnclosingMethod()
                .getName(), new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
