package Bai14_JavaScriptExecutor;

import Common.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import vuTest.keywords.WebUI;

public class executeScript extends baseTest {

    @Test
    public void testScript01(){
        driver.get("https://cms.anhtester.com/");
//        driver.findElement(By.xpath("//a[text()='Login']")).click();

        //Click Object với Javascript
        JavascriptExecutor js = (JavascriptExecutor) driver; //Khai báo và khởi tạo đối tượng
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[text()='Login']")));

        //Lấy tên title
        String title = js.executeScript("return document.title;").toString();
        System.out.println("Page Title is: "+title);

        //Lấy Domain
        String domain = js.executeScript("return document.domain;").toString();
        System.out.println("Domain là: "+domain);

        WebUI.sleep(2);

        js.executeScript("document.getElementById('email').setAttribute('value','admin02@mailinator.com');");
        js.executeScript("document.getElementById('password').setAttribute('value','123456');");

        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[normalize-space()='Login']")));

        sleep(2);
    }

    @Test
    public void testScript02(){
        driver.get("https://cms.anhtester.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Highlight popup banner
        WebElement popUp = driver.findElement(By.xpath("//b[normalize-space()='Website Demo']"));
        js.executeScript("arguments[0].style.border='3px solid red'", popUp);
        sleep(2);

    }


}
