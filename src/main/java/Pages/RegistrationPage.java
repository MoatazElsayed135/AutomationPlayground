package Pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPage {

    private Driver driver;


    public RegistrationPage (Driver driver)
    {
        this.driver = driver;
    }

    By RegistrationHeader = By.xpath("//h2[b[text()='Enter Account Information']]\n");
    String RegistrationTitle = "ENTER ACCOUNT INFORMATION";
    By PasswordField = By.id("password");
    By FirstNameField = By.id("first_name");
    By LastNameField = By.id("last_name");
    By AddressField = By.id("address1");
    By CountryField = By.id("country");
    By StateField = By.id("state");
    By CityField = By.id("city");
    By ZipCodeField = By.id("zipcode");
    By MobileNumberField = By.id("mobile_number");
    By CreateAccountButton = By.xpath("//button[@data-qa='create-account']\n");

    /**********************************Assertion**************************************/

    @Step("Check That Enter Account Information Should Be Displayed")
    public RegistrationPage CheckThatEnterAccountInformationShouldBeDisplayed (){
        Assert.assertEquals(driver.element().getTextOf(RegistrationHeader),RegistrationTitle);
        return this;
    }

    @Step("Check That Url Of Registration Page Is Correct")
    public RegistrationPage CheckThatUrlOfRegistrationPageIsCorrect(){

        String url =driver.browser().getCurrentURL();
        Assert.assertEquals(url,"https://www.automationexercise.com/signup");
        return this;
    }



    /*********************************Actions******************************************/

    @Step("Fill Registration Form")
    public RegistrationSuccessPage FillRegistrationForm(String password , String firstName, String lastName
            ,String address,String state,String city,String zipCode,String mobileNumber)
    {
        driver.element().type(PasswordField,password);
        driver.element().type(FirstNameField,firstName);
        driver.element().type(LastNameField,lastName);
        driver.element().type(AddressField,address);

        // اختيار الدولة من القائمة المنسدلة
        Select select = new Select(driver.get().findElement(CountryField));
        select.selectByVisibleText("United States");

        driver.element().type(StateField,state);
        driver.element().type(CityField,city);
        driver.element().type(ZipCodeField,zipCode);
        driver.element().type(MobileNumberField,mobileNumber);
        driver.element().click(CountryField);
        driver.browser().scrollToBottom();
        driver.element().click(CreateAccountButton);
        return new RegistrationSuccessPage(driver);
    }
}
