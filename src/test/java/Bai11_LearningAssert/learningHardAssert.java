package Bai11_LearningAssert;

import Common.baseTest_OLD;
import org.testng.Assert;
import org.testng.annotations.Test;

public class learningHardAssert extends baseTest_OLD {


    @Test(priority = 1)
    public void RunTest() {

        driver.get("https://anhtester.com");

        String expectedTitle = "Anh Tester Automation Testing";
        String originalTitle = driver.getTitle();

        System.out.println("*** KẾT Quả Là ***");

//        Assert.assertEquals(originalTitle, expectedTitle);
        Assert.assertTrue(originalTitle.equals(expectedTitle));

        System.out.println("*** In ra kết quả nếu so sánh Đúng ***");
    }

}
