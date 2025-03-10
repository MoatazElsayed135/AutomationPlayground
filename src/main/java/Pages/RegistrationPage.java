package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPage {

    private WebDriver driver;


    public RegistrationPage (WebDriver driver)
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

    public RegistrationPage CheckThatEnterAccountInformationShouldBeDisplayed (){
        Assert.assertEquals(driver.findElement(RegistrationHeader).getText(), RegistrationTitle);
        return this;
    }

    public RegistrationPage CheckThatUrlOfRegistrationPageIsCorrect(){

        String url =driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.automationexercise.com/signup");
        return this;
    }



    /*********************************Actions******************************************/

    public RegistrationSuccessPage FillRegistrationForm(String password , String firstName, String lastName
            ,String address,String state,String city,String zipCode,String mobileNumber)
    {
        driver.findElement(PasswordField).sendKeys(password);
        driver.findElement(FirstNameField).sendKeys(firstName);
        driver.findElement(LastNameField).sendKeys(lastName);
        driver.findElement(AddressField).sendKeys(address);

        // اختيار الدولة من القائمة المنسدلة
        Select select = new Select(driver.findElement(CountryField));
        select.selectByVisibleText("United States");

        driver.findElement(StateField).sendKeys(state);
        driver.findElement(CityField).sendKeys(city);
        driver.findElement(ZipCodeField).sendKeys(zipCode);
        driver.findElement(MobileNumberField).sendKeys(mobileNumber);
        driver.findElement(CountryField).click();
        driver.findElement(CreateAccountButton).click();
        return new RegistrationSuccessPage(driver);
    }
}
