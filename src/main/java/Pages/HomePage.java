package Pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

    private Driver driver;
    By LoginSignUpLink = By.xpath("//a[@href=\"/login\"]");
    By LogOutLink = By.xpath("//a[@href='/logout']\n");
    By DeleteAccountLink = By.xpath("//a[@href='/delete_account']\n");
    By LoginLink = By.xpath("//a[@href='/login']\n");

    By ProductButton = By.xpath("//a[@href='/products']\n");


    public HomePage(Driver driver)
    {

        this.driver = driver;
    }

    /****************************************************Assertion**********************************************/

    @Step("Check That User Should Be Navigated To Home Page Successfully")
    public HomePage CheckThatUserShouldBeNavigatedToHomePageSuccessfully(){

        String url =driver.browser().getCurrentURL();
        Assert.assertEquals(url,"https://www.automationexercise.com/");
        return this;
    }

    @Step("Check That LogOut Link Should Be Displayed")
    public HomePage CheckThatLogOutLinkShouldBeDisplayed(){
        Assert.assertTrue(driver.element().isDisplayed(LogOutLink));
        return this;
    }

    @Step("Check That Delete Link Should Be Displayed")
    public HomePage CheckThatDeleteLinkShouldBeDisplayed(){
        Assert.assertTrue(driver.element().isDisplayed(DeleteAccountLink));
        return this;
    }

    @Step("Check That Login Link Should Be Displayed")
    public HomePage CheckThatLoginLinkShouldBeDisplayed(){
        Assert.assertTrue(driver.element().isDisplayed(LoginLink));
        return this;
    }

    /******************************************************Actions*********************************************/

    @Step("Click On LoginSignUp Page")
    public LoginSignUpPage ClickOnLoginSignUpPage(){
        driver.element().click(LoginSignUpLink);
        return new LoginSignUpPage(driver);
    }

    @Step("Click On LogOut Link")
    public LoginSignUpPage ClickOnLogOutLink(){
        driver.element().click(LogOutLink);
        return new LoginSignUpPage(driver);
    }

    @Step("Click On Delete Account")
    public AccountDeletionPage ClickOnDeleteAccount(){
        driver.element().click(DeleteAccountLink);
        return new AccountDeletionPage(driver);
    }

    @Step("Click On Product Button")
    public ProductPage ClickOnProductButton(){
        driver.element().click(ProductButton);
        return new ProductPage(driver);
    }
}
