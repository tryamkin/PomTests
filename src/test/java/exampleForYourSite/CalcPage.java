package exampleForYourSite;
import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalcPage extends BaseSeleniumPage {

   /*
   WebElement webElement = driver.findElement(By.xpath("//span[@id='cwos']")) ;
   By Byelem = By.xpath("//span[@id='cwos']");*/

   @FindBy(xpath = "//span[@id='cwos']")
    private WebElement answer;

    public CalcPage() {
        PageFactory.initElements(driver,this);
    }

    public int getAnswer (){
        System.out.println(answer.getText() +  " answer");
        return Integer.parseInt(answer.getText()) ;
    }



}
