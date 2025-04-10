package Pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegistrationSuccessPage {

    private Driver driver;

    public RegistrationSuccessPage (Driver driver)
    {
        this.driver = driver;
    }

    By SuccessRegistrationHeader = By.xpath("//h2[@data-qa='account-created']\n");
    String SuccessRegistrationTitle = "ACCOUNT CREATED!";
    By ContinueButton = By.xpath("//a[@data-qa='continue-button']\n");

    /**********************************Assertion**************************************/

    @Step("Check That Url Of Success Registration Is Correct")
    public RegistrationSuccessPage CheckThatUrlOfSuccessRegistrationIsCorrect(){

        String url2 =driver.browser().getCurrentURL();
        Assert.assertEquals(url2,"https://www.automationexercise.com/account_created");
        return this;
    }

    @Step("Check That Account Created Should Be Displayed")
    public RegistrationSuccessPage CheckThatAccountCreatedShouldBeDisplayed(){

        Assert.assertEquals(driver.element().getTextOf(SuccessRegistrationHeader), SuccessRegistrationTitle);
        return this;
    }


    /******************************************Actions**************************************************************/

    @Step("Click On Continue Button")
    public HomePage ClickOnContinueButton(){
        driver.element().click(ContinueButton);
        return new HomePage(driver);
    }
}

