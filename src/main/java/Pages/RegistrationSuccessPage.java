package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegistrationSuccessPage {

    private WebDriver driver;

    public RegistrationSuccessPage (WebDriver driver)
    {
        this.driver = driver;
    }

    By SuccessRegistrationHeader = By.xpath("//h2[@data-qa='account-created']\n");
    String SuccessRegistrationTitle = "ACCOUNT CREATED!";
    By ContinueButton = By.xpath("//a[@data-qa='continue-button']\n");

    /**********************************Assertion**************************************/

    public RegistrationSuccessPage CheckThatUrlOfSuccessRegistrationIsCorrect(){

        String url2 =driver.getCurrentUrl();
        Assert.assertEquals(url2,"https://www.automationexercise.com/account_created");
        return this;
    }

    public RegistrationSuccessPage CheckThatAccountCreatedShouldBeDisplayed(){

        Assert.assertEquals(driver.findElement(SuccessRegistrationHeader).getText(), SuccessRegistrationTitle);
        return this;
    }


    /******************************************Actions**************************************************************/

    public HomePage ClickOnContinueButton(){
        driver.findElement(ContinueButton).click();
        return new HomePage(driver);
    }
}

