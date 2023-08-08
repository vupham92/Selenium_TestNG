package Bai13_handlealertpopupiFrame;

import Common.baseTest_OLD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class learningHandlePopup extends baseTest_OLD {

    @Test
    public void testPopup() {
        driver.get("https://nxtgenaiacademy.com/multiplewindows/");
        System.out.println("aaa");
        driver.findElement(By.xpath("//button[normalize-space()='New Browser Tab']")).click();

        // Lưu lại lớp window đầu tiên - mã ID hơi dài, in ra sẽ thấy
        String MainWindow = driver.getWindowHandle();
        System.out.println(MainWindow);

        // Get all new opened tab Window.
        Set<String> windows = driver.getWindowHandles();

        //Set là một Collection để lưu các phần tử giá trị KHÔNG trùng lặp.
        //Cách duyệt từng phần tử không trùng lặp trong Collection (Set) - Java Basic
        for (String i : windows) {
            System.out.println(i);
            if (!MainWindow.equals(i)) {
                driver.switchTo().window(i);
                sleep(2);
                System.out.println("Đã chuyển qua lớp window con");

                //Một số hàm hỗ trợ
                System.out.println(driver.switchTo().window(i).getTitle());
                System.out.println(driver.switchTo().window(i).getCurrentUrl());

//                driver.findElement(By.name("emailid")).sendKeys("abc@gmail.com");
//                driver.findElement(By.name("btnLogin")).click();
                WebElement newTitle = driver.findElement(By.xpath("//h2[contains(.,'Most Affordable Selenium Online Course')]"));
                Assert.assertEquals(newTitle.getText(), "Welcome To India's Most Affordable Selenium Online Course", "Title Không Đúng");
                sleep(1);

                //Get text trang sau khi submit
//                System.out.println(driver.findElement(By.xpath("//table//td//h2")).getText());

                //close the child window
                sleep(1);
                driver.close();
            }
        }

        // Switching to Parent window (Main Window)
        driver.switchTo().window(MainWindow);
        System.out.println("Đã chuyển về lớp Window chính: " + driver.getCurrentUrl());

        sleep(2);
    }
}
