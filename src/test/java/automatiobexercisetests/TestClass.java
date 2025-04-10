package automatiobexercisetests;
import DriverFactory.Driver;
import Pages.HomePage;
import Pages.LoginSignUpPage;
import Pages.RegistrationPage;
import Pages.RegistrationSuccessPage;
import org.testng.annotations.*;

public class TestClass {

    public ThreadLocal<Driver> driver;
    private HomePage homePage;
    private LoginSignUpPage loginSignUpPage;
    private RegistrationPage registrationPage;
    private RegistrationSuccessPage registrationSuccessPage;



    @BeforeClass
    public void setup() {
        driver = new ThreadLocal<>();
        driver.set(new Driver());
    }

    @Test (priority = 1)
    public void CheckThatUserCanRegisterSuccessfully(){

      // String randomEmail = "moataz" + System.currentTimeMillis() + "@gmail.com";
        new HomePage(driver.get()).ClickOnLoginSignUpPage()
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
        new HomePage(driver.get()).ClickOnLogOutLink().CheckThatLoginFormTitleShouldBeDisplayed();

    }

    @Test (priority = 3)
    public void CheckThatUserCanLogInSuccessfully(){

       new LoginSignUpPage(driver.get()).CheckThatLoginFormTitleShouldBeDisplayed()
               .FillLoginForm("12345", "moataz1254@gmail.com" )
               .CheckThatUserShouldBeNavigatedToHomePageSuccessfully()
               .CheckThatLogOutLinkShouldBeDisplayed()
               .CheckThatDeleteLinkShouldBeDisplayed();

    }

    @Test(priority = 4)
    public void UserCanDeleteAccountSuccessfully(){
        new HomePage(driver.get()).ClickOnDeleteAccount()
                .CheckThatAccountShouldBeDeletedSuccessfully()
                .ClickOnContinueButton()
                .CheckThatLoginLinkShouldBeDisplayed();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.get().Quit();
    }
}
