package demoBlazeSite;

import core.BaseSeleniumTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BlazeTest extends BaseSeleniumTest {


    @Test
    public void loginUserTest() {
        MainPage mainPage = new MainPage().
                loginOnTheSite();
        Assert.assertTrue(mainPage.nameOfLoginnedUser.getText().contains(mainPage.login()));
    }

}
