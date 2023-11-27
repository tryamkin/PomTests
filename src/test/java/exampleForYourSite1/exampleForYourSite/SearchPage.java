package exampleForYourSite1.exampleForYourSite;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BaseSeleniumPage {

    @FindBy(xpath = "//div[@id='result-stats']")
    private WebElement searcResult;

    //Обязательный конструктор
    public SearchPage() {
        PageFactory.initElements(driver, this);
    }


    public Long setSearchResults() {
        System.out.println(searcResult.getText());
        String s = searcResult.getText().replaceAll("[^\\d]", "").substring(0, 10);
        return Long.parseLong(s);

    }
}
