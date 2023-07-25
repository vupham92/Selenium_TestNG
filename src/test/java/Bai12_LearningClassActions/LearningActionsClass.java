package Bai12_LearningClassActions;

import Common.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;



public class LearningActionsClass extends baseTest {
//    @Test
    public void TestSendKeys(){
        driver.get("https://www.google.com/");

        // Element search box
        WebElement element = driver.findElement(By.xpath("//input[@name='q']"));

        // Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        // Dùng action để gọi hàm sendkeys điền dữ liệu. Không dùng sendKeys của WebElement
        action.sendKeys(element, "Anh Tester").build().perform();
        sleep(2);

    }

    @Test
    public void doubleClick() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//div[@class='col-lg-7']//h2[@class='section__title'][contains(text(),'Anh Tester')]"));

        Actions action = new Actions(driver);

        action.doubleClick(element).build().perform();
        Thread.sleep(2000);
    }

    @Test
    public void contextClick() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//div[@class='col-lg-7']//h2[@class='section__title'][contains(text(),'Anh Tester')]"));

        Actions action = new Actions(driver);

        action.contextClick(element).build().perform();
        Thread.sleep(2000);
    }

    @Test
    public void moveToElement() throws InterruptedException {
        driver.get("https://anhtester.com/");
        sleep(2);
        WebElement element = driver.findElement(By.xpath("//h2[contains(text(),'Kiến thức Automation Testing')]"));

        Actions action = new Actions(driver);

        //Move to element (di chuyển tới title Kiến thức Automation Testing)
        action.moveToElement(element).build().perform();

        sleep(2);
    }
    @Test
    public void dragAndDrop(){
        driver.get("https://demo.guru99.com/test/drag_drop.html");
        sleep(2);

        // Element which needs to drag.
        WebElement From = driver.findElement(By.xpath("//*[@id='credit2']/a"));
        // Element on which need to drop.
        WebElement To = driver.findElement(By.xpath("//*[@id='bank']/li"));

        Actions action = new Actions(driver);

        // Gọi hàm dragAndDrop giữa Element
        action.dragAndDrop(From, To).release().build().perform();

        sleep(2);

        // Drag and Drop by Pixel.
        WebElement from_5000 = driver.findElement(By.xpath("//*[@id='fourth']/a[1]"));
        action.dragAndDropBy(from_5000, 168, 40).release().build().perform();

        sleep(2);
    }
}
