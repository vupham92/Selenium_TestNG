package BaiTap;

import Common.baseTest02;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class baiTap02 extends baseTest02 {

    @BeforeMethod
    public void testSignIn() {
        System.out.println("Login");
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).clear();

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        sleep(2);
    }

    @Test
    public void addCategory() {
        System.out.println("Add Category");
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        sleep(2);

        driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).click();
        sleep(2);

        //Input thông tin cho category mới
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("vutest02");

        //Xu lý dropdownlist động
        driver.findElement(By.xpath("//div[contains(text(),'No Parent')]")).click();
        sleep(1);
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("Demo");
        sleep(1);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        sleep(1);

        // Xử lý Field Type dropdown list tĩnh
        driver.findElement(By.xpath("//input[@id='order_level']")).sendKeys("5");
        Select select = new Select(driver.findElement(By.xpath("//select[@name='digital']")));
        select.selectByVisibleText("Digital");

        // Banner chon file
        driver.findElement(By.xpath("(//div[contains(text(),'Browse')])[1]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("sting");
        sleep(1);
        driver.findElement(By.xpath("(//img[@class='img-fit'])[1]")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();

        //Click save button
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        sleep(2);

        //Search lai cattegory vừa add
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("vutest");
        action.sendKeys(Keys.ENTER).perform();
        sleep(1);

        String searchElement = driver.findElement(By.xpath("//tbody//tr[1]//td[2]")).getText();
        System.out.println("Get Category item:"+ searchElement);
        Assert.assertEquals(searchElement, "vutest");
        sleep(1);


    }
}
