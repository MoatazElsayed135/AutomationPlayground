package automatiobexercisetests;

import DriverFactory.Driver;
import Pages.HomePage;
import Pages.LoginSignUpPage;
import Pages.RegistrationPage;
import Pages.RegistrationSuccessPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginSignUpTest {


    public ThreadLocal<Driver> driver;


    @BeforeClass
    @Parameters(value = {"browserName"})
    public void setup(@Optional("CHROME") String browserName) {
        driver = new ThreadLocal<>();
        driver.set(new Driver(browserName));
        driver.get().browser().navigateToURL("https://www.automationexercise.com/");
    }

    @Test (priority = 1)
    public void ExistingEmailError(){
        new HomePage(driver.get()).ClickOnLoginSignUpPage()
                .CheckThatSignUpFormTitleShouldBeDisplayed()
                .FillSignUpForm("Moataz Elsayed", "motazoza116256513@gmail.com");
        new LoginSignUpPage(driver.get()).CheckThatExistingEmailErrorShouldBeDisplayed();


    }
    @Test(priority = 2)
    public void InCorrectCredentialsMessage(){
        new HomePage(driver.get()).ClickOnLoginSignUpPage()
                .CheckThatSignUpFormTitleShouldBeDisplayed()
                .FillLoginForm("2165165", "hjgj@hgj.com");
        new LoginSignUpPage(driver.get()).CheckThatInCorrectCredentialsMessageShouldBeDisplayed();

    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.get().Quit();
    }
}
