package Pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountDeletionPage {
    private Driver driver;

    public AccountDeletionPage (Driver driver)
    {

        this.driver = driver;
    }

    By AccountDeletedHeader = By.xpath("//b[text()='Account Deleted!']\n");
    String AccountDeletedTitle = "ACCOUNT DELETED!";
    By ContinueButton = By.xpath("//a[@data-qa='continue-button']\n");

    /**********************************Assertion**************************************/

    @Step("Check That Account Should Be Deleted Successfully")
    public AccountDeletionPage CheckThatAccountShouldBeDeletedSuccessfully(){

        Assert.assertEquals(driver.element().getTextOf(AccountDeletedHeader), AccountDeletedTitle);
        return this;
    }



    /*********************************Actions******************************************/

    @Step("Click On Continue Button")
    public HomePage ClickOnContinueButton(){
        driver.element().click(ContinueButton);
        return new HomePage(driver);
    }
}
