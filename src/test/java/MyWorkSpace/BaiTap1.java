package MyWorkSpace;

import Common.baseTest_OLD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class BaiTap1 extends baseTest_OLD {
    @Test
    public void testSignin(){
        driver.get("https://cms.anhtester.com/login");

        Actions action = new Actions(driver);

        WebElement user_txt = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement password_txt = driver.findElement(By.xpath("//input[@id='password']"));

        action.sendKeys(user_txt, "admin@example.com").build().perform();
        action.sendKeys(password_txt, "123456").build().perform();

        sleep(2);


        System.out.println("Sign in successfully");

    }

    @Test
    public void addNewCategory(){
        WebElement product_menu = driver.findElement(By.xpath("//span[normalize-space()='Products']"));
        WebElement category_menu = driver.findElement(By.xpath("//span[normalize-space()='Category']"));
        WebElement addNew_category = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        WebElement name_txtbox = driver.findElement(By.xpath("//input[@id='name']"));
        WebElement banner_browse = driver.findElement(By.xpath("(//div[contains(text(),'Browse')])[1]"));
        WebElement search_textbox_banner = driver.findElement (By.xpath("//input[@placeholder='Search your files']"));
        WebElement add_file_btn = driver.findElement(By.xpath("//button[normalize-space()='Add Files']"));

    }

}
