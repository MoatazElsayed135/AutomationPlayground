package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSignUpPage {

    private WebDriver driver;

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
    By ExistingEmailError = By.xpath("//p[@style='color: red;']");

    String InCorrectLoginMessage = "Your email or password is incorrect!";
    String ExistingEmailMessage = "Email Address already exist!";


    public LoginSignUpPage (WebDriver driver)
    {

        this.driver = driver;
    }


    /**************************Assertion*******************************************************/
    public LoginSignUpPage CheckThatSignUpFormTitleShouldBeDisplayed() {
        Assert.assertEquals(driver.findElement(SignUpFormHeader).getText(), SignUpFormTitle);
        return this;
    }
    public LoginSignUpPage CheckThatLoginFormTitleShouldBeDisplayed() {
        Assert.assertEquals(driver.findElement(LoginFormHeader).getText(), LoginFormTitle);
        return this;
    }

    public LoginSignUpPage CheckThatUrlOfLoginSignUpPageIsCorrect(){

        String url =driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.automationexercise.com/login");
        return this;
    }
    public LoginSignUpPage CheckThatExistingEmailErrorShouldBeDisplayed() {
        Assert.assertEquals(driver.findElement(InCorrectLoginCredentials).getText(), ExistingEmailMessage);
        return this;
    }
    public LoginSignUpPage CheckThatInCorrectCredentialsMessageShouldBeDisplayed() {
        Assert.assertEquals(driver.findElement(ExistingEmailError).getText(), InCorrectLoginMessage);
        return this;
    }

    /*************************************Action********************************************/

    public RegistrationPage FillSignUpForm(String name , String email){
        driver.findElement(SignUpNameField).sendKeys(name);
        driver.findElement(SignUpEmailField).sendKeys(email);
        driver.findElement(SignUpButton).click();
        return new RegistrationPage(driver);
    }

    public HomePage FillLoginForm(String password , String email){
        driver.findElement(LoginPasswordField).sendKeys(password);
        driver.findElement(LoginEmailField).sendKeys(email);
        driver.findElement(LoginButton).click();
        return new HomePage(driver);
    }
}

