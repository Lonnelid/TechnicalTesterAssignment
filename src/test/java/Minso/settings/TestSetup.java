package Minso.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

public class TestSetup extends TestData {

     protected WebDriver driver;
     protected WebDriverWait wait;


    @BeforeClass
    public void beforeClassSetup() {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofMillis(20000));
    }

    @AfterClass
    public void quitDriverAfterClass () {
        driver.quit();
    }

}
