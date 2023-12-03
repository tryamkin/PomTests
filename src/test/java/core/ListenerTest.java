package core;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

import static core.BaseSeleniumPage.driver;


public class ListenerTest  implements ITestListener {





    public void onFinish(ITestContext arg0) {
        System.out.println("Tests finished - OK ");
    }


    @Override
    public void onTestFailure(ITestResult arg0) {
        System.out.println("Test failed AAAA!!!!");

    }



}
