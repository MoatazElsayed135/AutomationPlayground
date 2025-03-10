package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

    private WebDriver driver;
    By LoginSignUpLink = By.xpath("//a[@href=\"/login\"]");
    By LogOutLink = By.xpath("//a[@href='/logout']\n");
    By DeleteAccountLink = By.xpath("//a[@href='/delete_account']\n");
    By LoginLink = By.xpath("//a[@href='/login']\n");

    By ProductButton = By.xpath("//a[@href='/products']\n");


    public HomePage(WebDriver driver)
    {

        this.driver = driver;
    }

    /****************************************************Assertion**********************************************/

    public HomePage CheckThatUserShouldBeNavigatedToHomePageSuccessfully(){

        String url =driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.automationexercise.com/");
        return this;
    }

    public HomePage CheckThatLogOutLinkShouldBeDisplayed(){
        Assert.assertTrue(driver.findElement(LogOutLink).isDisplayed());
        return this;
    }

    public HomePage CheckThatDeleteLinkShouldBeDisplayed(){
        Assert.assertTrue(driver.findElement(DeleteAccountLink).isDisplayed());
        return this;
    }

    public HomePage CheckThatLoginLinkShouldBeDisplayed(){
        Assert.assertTrue(driver.findElement(LoginLink).isDisplayed());
        return this;
    }

    /******************************************************Actions*********************************************/

    public LoginSignUpPage ClickOnLoginSignUpPage(){
        driver.findElement(LoginSignUpLink).click();
        return new LoginSignUpPage(driver);
    }

    public LoginSignUpPage ClickOnLogOutLink(){
        driver.findElement(LogOutLink).click();
        return new LoginSignUpPage(driver);
    }

    public AccountDeletionPage ClickOnDeleteAccount(){
        driver.findElement(DeleteAccountLink).click();
        return new AccountDeletionPage(driver);
    }

    public ProductPage ClickOnProductButton(){
        driver.findElement(ProductButton).click();
        return new ProductPage(driver);
    }
}
