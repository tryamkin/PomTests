package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

abstract public class BaseSeleniumTest {
    protected WebDriver driver;
    private final String os = System.getProperty("os.name");

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        //
        System.out.println(os);
        if (os.contains("Windows")){
            driver = new ChromeDriver();
        } else {
            driver = new ChromeDriver(new ChromeOptions().addArguments("--headless"));
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        BaseSeleniumPage.setDriver(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
