package automatiobexercisetests;

import Pages.HomePage;
import Pages.LoginSignUpPage;
import Pages.RegistrationPage;
import Pages.RegistrationSuccessPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginSignUpTest {

    private WebDriver driver;


    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.navigate().to("https://www.automationexercise.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @Test (priority = 1)
    public void ExistingEmailError(){
        new HomePage(driver).ClickOnLoginSignUpPage()
                .CheckThatSignUpFormTitleShouldBeDisplayed()
                .FillSignUpForm("Moataz Elsayed", "motazoza116256513@gmail.com");
        new LoginSignUpPage(driver).CheckThatExistingEmailErrorShouldBeDisplayed();

    }
    @Test(priority = 2)
    public void InCorrectCredentialsMessage(){
        new HomePage(driver).ClickOnLoginSignUpPage()
                .CheckThatSignUpFormTitleShouldBeDisplayed()
                .FillLoginForm("2165165", "hjgj@hgj.com");
        new LoginSignUpPage(driver).CheckThatInCorrectCredentialsMessageShouldBeDisplayed();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
