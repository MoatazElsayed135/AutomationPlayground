package Pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductPage {

    private Driver driver;

    public ProductPage(Driver driver)
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

    @Step("Check That User Should Be Navigated To Product Page Successfully")
    public ProductPage CheckThatUserShouldBeNavigatedToProductPageSuccessfully(){

        String url =driver.browser().getCurrentURL();
        Assert.assertEquals(url,"https://www.automationexercise.com/products");
        return this;
    }
    @Step("Check That User Should Be Navigated To T-shirt Products Successfully")
    public ProductPage CheckThatUserShouldBeNavigatedToTshirtProductsSuccessfully(){

        String url =driver.browser().getCurrentURL();
        Assert.assertEquals(url,"https://www.automationexercise.com/products?search=T-shirt");
        return this;
    }
    @Step("Check That Search Bar Should Be Displayed")
    public ProductPage CheckThatSearchBarShouldBeDisplayed(){
        Assert.assertTrue(driver.element().isDisplayed(SearchBar));
        return this;
    }

    @Step("Check That Researched Product Should Be Displayed")
    public ProductPage CheckThatResearchedProductShouldBeDisplayed (){
        Assert.assertEquals(driver.element().getTextOf(ResearchedHeader), ResearchedTitle);
        return this;
    }
    @Step("Check That Men Shirts Products Should Be Displayed")
    public ProductPage CheckThatMenShirtsProductsShouldBeDisplayed (){
        Assert.assertEquals(driver.element().getTextOf(MenShirtsHeader), MenShirtsTitle);
        return this;
    }

    /******************************************************Actions*********************************************/

    @Step("Write In Search Bar")
    public ProductPage WriteInSearchBar(){
        driver.element().type(SearchBar,"T-shirt");
        driver.element().click(SearchBarButton);
        return this;
    }
    @Step("Select Men Shirts Category")
    public ProductPage SelectMenShirtsCategory(){
        driver.element().click(MenCategory);
        driver.element().click(MenShirts);
        return this;
    }


}
