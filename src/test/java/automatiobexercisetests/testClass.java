package automatiobexercisetests;
import Pages.HomePage;
import Pages.LoginSignUpPage;
import Pages.RegistrationPage;
import Pages.RegistrationSuccessPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class testClass {

    private WebDriver driver;
    private HomePage homePage;
    private LoginSignUpPage loginSignUpPage;
    private RegistrationPage registrationPage;
    private RegistrationSuccessPage registrationSuccessPage;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.navigate().to("https://www.automationexercise.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @Test (priority = 1)
    public void CheckThatUserCanRegisterSuccessfully(){

//        String randomEmail = "moataz" + System.currentTimeMillis() + "@gmail.com";
        new HomePage(driver).ClickOnLoginSignUpPage()
                .CheckThatUrlOfLoginSignUpPageIsCorrect()
                .CheckThatSignUpFormTitleShouldBeDisplayed()
                .FillSignUpForm("Moataz", "moataz1254@gmail.com")
                .CheckThatEnterAccountInformationShouldBeDisplayed()
                .CheckThatUrlOfRegistrationPageIsCorrect()
                .FillRegistrationForm("12345", "moataz", "Elsayed", "ghgvfc",
                 "suez", "suez", "12345", "01019841085")
                .CheckThatUrlOfSuccessRegistrationIsCorrect()
                .CheckThatAccountCreatedShouldBeDisplayed()
                .ClickOnContinueButton()
                .CheckThatUserShouldBeNavigatedToHomePageSuccessfully()
                .CheckThatLogOutLinkShouldBeDisplayed()
                .CheckThatDeleteLinkShouldBeDisplayed();

    }

    @Test (priority = 2)
    public void CheckThatUserCanLogoutSuccessfully(){
        new HomePage(driver).ClickOnLogOutLink().CheckThatLoginFormTitleShouldBeDisplayed();

    }

    @Test (priority = 3)
    public void CheckThatUserCanLogInSuccessfully(){

       new LoginSignUpPage(driver).CheckThatLoginFormTitleShouldBeDisplayed()
               .FillLoginForm("12345", "moataz1254@gmail.com" )
               .CheckThatUserShouldBeNavigatedToHomePageSuccessfully()
               .CheckThatLogOutLinkShouldBeDisplayed()
               .CheckThatDeleteLinkShouldBeDisplayed();

    }

    @Test(priority = 4)
    public void UserCanDeleteAccountSuccessfully(){
        new HomePage(driver).ClickOnDeleteAccount()
                .CheckThatAccountShouldBeDeletedSuccessfully()
                .ClickOnContinueButton()
                .CheckThatLoginLinkShouldBeDisplayed();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
