package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountDeletionPage {
    private WebDriver driver;

    public AccountDeletionPage (WebDriver driver)
    {

        this.driver = driver;
    }

    By AccountDeletedHeader = By.xpath("//b[text()='Account Deleted!']\n");
    String AccountDeletedTitle = "ACCOUNT DELETED!";
    By ContinueButton = By.xpath("//a[@data-qa='continue-button']\n");

    /**********************************Assertion**************************************/

    public AccountDeletionPage CheckThatAccountShouldBeDeletedSuccessfully(){

        Assert.assertEquals(driver.findElement(AccountDeletedHeader).getText(), AccountDeletedTitle);
        return this;
    }



    /*********************************Actions******************************************/

    public HomePage ClickOnContinueButton(){
        driver.findElement(ContinueButton).click();
        return new HomePage(driver);
    }
}
