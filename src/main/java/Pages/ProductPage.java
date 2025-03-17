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

    By MenShirtsHeader = By.xpath("//h2[text()='Men - Tshirts Products']\n");
    String MenShirtsTitle = "MEN - TSHIRTS PRODUCTS";

    By MenCategory = By.xpath("//a[@href='#Men']");
    By MenShirts = By.xpath("//a[text()='Tshirts ']\n");

    /****************************************************Assertion**********************************************/

    public ProductPage CheckThatUserShouldBeNavigatedToProductPageSuccessfully(){

        String url =driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.automationexercise.com/products");
        return this;
    }
    public ProductPage CheckThatUserShouldBeNavigatedToTshirtProductsSuccessfully(){

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
    public ProductPage CheckThatMenShirtsProductsShouldBeDisplayed (){
        Assert.assertEquals(driver.findElement(MenShirtsHeader).getText(), MenShirtsTitle);
        return this;
    }

    /******************************************************Actions*********************************************/

    public ProductPage WriteInSearchBar(){
        driver.findElement(SearchBar).sendKeys("T-shirt");
        driver.findElement(SearchBarButton).click();
        return this;
    }
    public ProductPage SelectMenShirtsCategory(){
        driver.findElement(MenCategory).click();
        driver.findElement(MenShirts).click();
        return this;
    }


}
