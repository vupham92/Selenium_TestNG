package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class baseTest02 {

    public static WebDriver driver;

    @BeforeTest
    public void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    //Đóng browser
    @AfterTest
    public void closeDriver() {
        sleep(2);
        driver.quit();

    }

    public static void sleep(double seconds) {
        try {
            Thread.sleep((long) (1000L * seconds));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
