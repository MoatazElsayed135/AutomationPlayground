package Pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSignUpPage {

    private Driver driver;

    By SignUpFormHeader = By.xpath("//h2[text()='New User Signup!']\n");
    String SignUpFormTitle = "New User Signup!";

    By LoginFormHeader = By.xpath("//h2[text()='Login to your account']\n");
    String LoginFormTitle = "Login to your account";

    By SignUpNameField = By.name("name");
    By SignUpEmailField = By.xpath("//input[@data-qa='signup-email']\n");
    By SignUpButton = By.xpath("//button[@data-qa='signup-button']\n");

    By LoginPasswordField = By.name("password");
    By LoginEmailField = By.xpath("//input[@data-qa='login-email']\n");
    By LoginButton = By.xpath("//button[@data-qa='login-button']\n");
    By InCorrectLoginCredentials = By.xpath("//form[@action=\"/login\"]/p");
    By ExistingEmailError = By.xpath("//p[@style='color: red;' and text()='Email Address already exist!']\n");

    String InCorrectLoginMessage = "Your email or password is incorrect!";
    String ExistingEmailMessage = "Email Address already exist!";


    public LoginSignUpPage (Driver driver)
    {

        this.driver = driver;
    }


    /**************************Assertion*******************************************************/
    @Step("Check That SignUpForm Title Should Be Displayed")
    public LoginSignUpPage CheckThatSignUpFormTitleShouldBeDisplayed() {
        Assert.assertEquals(driver.element().getTextOf(SignUpFormHeader), SignUpFormTitle);
        return this;
    }
    @Step("Check That Login Form Title Should Be Displayed")
    public LoginSignUpPage CheckThatLoginFormTitleShouldBeDisplayed() {
        Assert.assertEquals(driver.element().getTextOf(LoginFormHeader), LoginFormTitle);
        return this;
    }

    @Step("Check That Url Of LoginSignUpPage Is Correct")
    public LoginSignUpPage CheckThatUrlOfLoginSignUpPageIsCorrect(){

        String url =driver.browser().getCurrentURL();
        Assert.assertEquals(url,"https://www.automationexercise.com/login");
        return this;
    }
    @Step("Check That Existing Email Error Should Be Displayed")
    public LoginSignUpPage CheckThatExistingEmailErrorShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(ExistingEmailError));
        Assert.assertEquals(driver.element().getTextOf(ExistingEmailError), ExistingEmailMessage);
        return this;
    }
    @Step("Check That InCorrect Credentials Message Should Be Displayed")
    public LoginSignUpPage CheckThatInCorrectCredentialsMessageShouldBeDisplayed() {
        Assert.assertEquals(driver.element().getTextOf(InCorrectLoginCredentials), InCorrectLoginMessage);
        return this;
    }

    /*************************************Action********************************************/

    @Step("Fill Sign Up Form")
    public RegistrationPage FillSignUpForm(String name , String email){
        driver.element().type(SignUpNameField ,name);
        driver.element().type(SignUpEmailField,email);
        driver.element().click(SignUpButton);
        return new RegistrationPage(driver);
    }

    @Step("Fill Login Form")
    public HomePage FillLoginForm(String password , String email){
        driver.element().type(LoginPasswordField, password);
        driver.element().type(LoginEmailField ,email);
        driver.element().click(LoginButton);
        return new HomePage(driver);
    }
}

