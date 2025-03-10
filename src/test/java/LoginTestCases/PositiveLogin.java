package LoginTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PositiveLogin {

    ChromeDriver MyChrome;

    @BeforeMethod
    public void OpenBrowser()
    {
        MyChrome = new ChromeDriver();
        MyChrome.navigate().to("https://the-internet.herokuapp.com/login");
        MyChrome.manage().window().maximize();
    }

    @Test(priority = 1)
    public void ValidLogin()
    {
        SoftAssert soft = new SoftAssert();

        MyChrome.findElement(By.id("username")).sendKeys("tomsmith");
        MyChrome.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        MyChrome.findElement(By.className("radius")).click();

        // assertion
        String url =MyChrome.getCurrentUrl();
        soft.assertEquals(url,"https://the-internet.herokuapp.com/secure");

        String message= MyChrome.findElement(By.id("flash")).getText();
        soft.assertTrue(message.contains("You logged into a secure area!"));

//        MyChrome.findElement(By.className("secondary")).click();
//        String url2 =MyChrome.getCurrentUrl();
//        Assert.assertEquals(url2,"https://the-internet.herokuapp.com/login");

        boolean Logout = MyChrome.findElement(By.className("secondary")).isDisplayed();
        soft.assertTrue(Logout);

        soft.assertAll();








    }

    @Test(priority = 2)
    public void InvalidLogin()
    {


    }

    @AfterMethod
    public void QuitDriver() throws InterruptedException {
        Thread.sleep(3000);
        MyChrome.quit();
    }
}
