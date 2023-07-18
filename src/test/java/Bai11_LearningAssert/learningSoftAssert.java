package Bai11_LearningAssert;

import Common.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class learningSoftAssert extends baseTest {
    @Test
    public void testSoftAssert(){
        driver.get("http://testphp.vulnweb.com/login.php");

        //Khỏi tạo objective SoftAssert
        SoftAssert softassert = new SoftAssert();

        //Kiểm tra Tiêu đề của Page
        String headerSignInPage = driver.getTitle();
        String expectedSignInPage = "login page123";
        softassert.assertEquals(headerSignInPage, expectedSignInPage, "Header signin page không đúng");


        //Kiểm tra nút Browse Categories có hiển thị
        WebElement menu_category = driver.findElement(By.xpath("//a[normalize-space()='Browse categories']"));
        softassert.assertEquals(menu_category.isDisplayed(),false ,"Menu Có hiển thị");

        //Bước cuối cùng của softassert là ALL
        softassert.assertAll();

    }


}
