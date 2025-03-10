package LoginTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Objects;
import java.util.Scanner;


public class LoginWebDriver {

    WebDriver MyDriver;
    String TheBrowser;

    @BeforeMethod
    @Parameters({"browser"}) // TestNG سيقوم بتمرير المتصفح من testng.xml
    public void OpenBrowser(@Optional("chrome") String TheBrowser) {  // قيمة افتراضية = "chrome"
        System.out.println("Selected browser: " + TheBrowser.toLowerCase());

        if (Objects.equals(TheBrowser, "chrome")) {
            MyDriver = new ChromeDriver();
        } else if (Objects.equals(TheBrowser, "firefox")) {
            MyDriver = new FirefoxDriver();
        } else {
            System.out.println("Invalid browser! Exiting...");
            System.exit(0);
        }

        MyDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        MyDriver.navigate().to("https://the-internet.herokuapp.com/login");
        MyDriver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void validLogin() {
        WebDriverWait wait = new WebDriverWait(MyDriver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("tomsmith");
        MyDriver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        MyDriver.findElement(By.className("radius")).click();
    }

    @AfterMethod
    public void QuitDriver() {
        if (MyDriver != null) {
            MyDriver.quit();
        }
    }
}