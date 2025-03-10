package automatiobexercisetests;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class ProductsTests {

    private WebDriver driver;


    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.navigate().to("https://www.automationexercise.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @Test
    public void ProductTests(){
        new HomePage(driver).ClickOnProductButton()
                .CheckThatUserShouldBeNavigatedToProductPageSuccessfully()
                .CheckThatSearchBarShouldBeDisplayed()
                .WriteInSearchBar()
                .CheckThatUserShouldBeNavigatedToTshirtProductsPageSuccessfully()
                .CheckThatResearchedProductShouldBeDisplayed();
    }



    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
