package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.time.Duration;


abstract public class BaseSeleniumTest implements ITestListener {
    protected static WebDriver driver;
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
        Allure.addAttachment(new Throwable()
                .getStackTrace()[1]
                .getMethodName(), new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }



    public void onTestFailure(ITestResult result) {
        Allure.addAttachment("Anytext", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }




    @AfterClass

    public void tearDown(){
        takeScreenShot();

        //   Allure.addAttachment("AnytextForScreenshot"+ Object.class.getName(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        driver.close();
        driver.quit();
    }

}
