package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductPage {

    private WebDriver driver;

    public ProductPage(WebDriver driver)
    {

        this.driver = driver;
    }

    By SearchBar= By.id("search_product");
    By SearchBarButton= By.id("submit_search");

    By ResearchedHeader = By.xpath("//h2[text()='Searched Products']\n");
    String ResearchedTitle = "SEARCHED PRODUCTS";

    By MenCategory = By.xpath("//a[text()='Men']");

    /****************************************************Assertion**********************************************/

    public ProductPage CheckThatUserShouldBeNavigatedToProductPageSuccessfully(){

        String url =driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.automationexercise.com/products");
        return this;
    }
    public ProductPage CheckThatUserShouldBeNavigatedToTshirtProductsPageSuccessfully(){

        String url =driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.automationexercise.com/products?search=T-shirt");
        return this;
    }
    public ProductPage CheckThatSearchBarShouldBeDisplayed(){
        Assert.assertTrue(driver.findElement(SearchBar).isDisplayed());
        return this;
    }

    public ProductPage CheckThatResearchedProductShouldBeDisplayed (){
        Assert.assertEquals(driver.findElement(ResearchedHeader).getText(), ResearchedTitle);
        return this;
    }

    /******************************************************Actions*********************************************/

    public ProductPage WriteInSearchBar(){
        driver.findElement(SearchBar).sendKeys("T-shirt");
        driver.findElement(SearchBarButton).click();
        return this;
    }
    public ProductPage SelectMenCategory(){
        driver.findElement(MenCategory).click();
        return this;
    }


}
