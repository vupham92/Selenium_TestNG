package Bai13_handlealertpopupiFrame;

import Common.baseTest_OLD;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class learningHandleAlert extends baseTest_OLD {

    @Test
    public void TestAlert01(){
        driver.get("https://demo.guru99.com/test/delete_customer.php");
        sleep(1);
        driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("0001");
        sleep(1);
        driver.findElement(By.xpath("//input[@name='cusid']")).submit();
        sleep(1);

        //Khai báo chuyển tới Alert
        Alert alert = driver.switchTo().alert();

        //Get message trên Alert
        String alertMessage = alert.getText();
        System.out.println("Alert Message là: "+alertMessage);

        //ấn submit
        alert.accept();
        sleep(1);
    }

    @Test
    public void testAlertContent(){
        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.xpath("")).click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("anhVuTester");
        alert.accept();

        WebElement messageConfirm = driver.findElement(By.xpath("//span[@id='promptResult']"));

        Assert.assertEquals(messageConfirm.getText(), "anhVuTester");
    }
}
