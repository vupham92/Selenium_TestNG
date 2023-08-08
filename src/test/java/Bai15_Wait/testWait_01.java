package Bai15_Wait;

import Common.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import vuTest.keywords.WebUI;

import java.time.Duration;

public class testWait_01 extends baseTest {

    @Test

    public void addBrandCMS() {
        driver.get("https://cms.anhtester.com/login");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();

        //Khai báo WebdriverWait = Explict Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //Chờ đợi menu brand đến khi visible để thao tác
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Brand']")));

        WebUI.waitForElementVisible(driver, By.xpath("//span[normalize-space()='Brand']"), 5);

        driver.findElement(By.xpath("//span[normalize-space()='Brand']")).click();

        String headerBrandName = driver.findElement(By.xpath("//div[@class='card-header']")).getText();
        Assert.assertEquals(headerBrandName, "Add New Brand", "Title trang đúng");
    }
}
