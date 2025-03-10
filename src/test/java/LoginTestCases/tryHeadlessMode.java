package LoginTestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;

public class tryHeadlessMode {
    WebDriver MyDriver;

    @BeforeMethod
    public void OpenBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        MyDriver = new ChromeDriver(options);
        MyDriver.manage().window().maximize();
    }

    @Test
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