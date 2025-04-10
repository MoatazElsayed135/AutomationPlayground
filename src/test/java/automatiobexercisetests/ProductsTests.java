package automatiobexercisetests;

import DriverFactory.Driver;
import Pages.HomePage;
import Pages.ProductPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class ProductsTests {

    public ThreadLocal<Driver> driver;


    @BeforeClass
    @Parameters(value = {"browserName"})
    public void setup(@Optional("CHROME") String browserName) {
        driver = new ThreadLocal<>();
        driver.set(new Driver(browserName));
        driver.get().browser().navigateToURL("https://www.automationexercise.com/");
    }


    @Test(priority = 1)
    public void ProductTests(){
        new HomePage(driver.get()).ClickOnProductButton()
                .CheckThatUserShouldBeNavigatedToProductPageSuccessfully()
                .CheckThatSearchBarShouldBeDisplayed()
                .WriteInSearchBar()
                .CheckThatUserShouldBeNavigatedToTshirtProductsSuccessfully()
                .CheckThatResearchedProductShouldBeDisplayed();
    }

    @Test(priority = 2)
    public void SelectMenShirts(){
        new ProductPage(driver.get())
                .SelectMenShirtsCategory()
                .CheckThatMenShirtsProductsShouldBeDisplayed();
    }



    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.get().Quit();
    }
}
