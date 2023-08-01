package Bai13_handlealertpopupiFrame;

import Common.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

public class learningHandleiFrame extends baseTest {

    @Test
    public void testLearningHandleiFrame(){
        driver.navigate().to("https://anhtester.com/contact");
        sleep(9);
        System.out.println("iframe total: " + driver.findElements(By.tagName("iframe")).size());
        sleep(3);

        //----Switch to content of Messenger--------
        driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.tagName("strong")).getText());

        //----Switch to icon of Messenger---------

        //1. Switch to Parent WindowHandle
        driver.switchTo().parentFrame();

        //2. Switch to iframe icon of Messenger
        driver.switchTo().frame(1);
        driver.findElement(By.tagName("svg")).click(); //Nhấn icon để ẩn messenger chat đi

        sleep(2);

    }

}
