package practice_Assertion;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;

public class Soft_Assertion {
    public static void main(String[] args) throws InterruptedException, IOException {
        // none static need to make object
        SoftAssert soft = new SoftAssert();

        WebDriverManager.chromedriver().setup();
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://it.microtechlimited.com/");
        driver.manage().window().maximize();

        //screenShot
        Soft_Assertion.screenShotName(driver,"Landing Page Application");

        String s = driver.findElement(By.xpath("//h1[text()='Welcome to MicroTech NA.']")).getText();
        soft.assertEquals(s,"Welcome to microtech Na----");
        //get title
        System.out.println(driver.getTitle());
        //Assert.assertTrue(driver.getTitle().equals("MicroTech NA"));// testNG Hard Assertion
        // testNG soft assertion
        soft.assertTrue(driver.getTitle().equals("MicroTech NAi"));// soft.asserAll();
        Thread.sleep(1000);
        System.out.println("XXXXXXXX");


        // testNG Assertion ....Hard
        Assert.assertTrue(driver.getTitle().equals("MicroTech NA"));
        Thread.sleep(2000);


        //login
        driver.findElement(By.xpath("//a[text()='LOG IN']")).click();
        Thread.sleep(1000);

        //employee.....username
        driver.findElement(By.xpath("//input[@name='mailuid']")).sendKeys("testpilot@gmail.com");
        Thread.sleep(1000);
        //screenShoot
        Soft_Assertion.screenShotName(driver,"Employee Login Page (userName)");
        //password
        driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("1234");
        Thread.sleep(1000);
        //screenShot
        Soft_Assertion.screenShotName(driver,"Employee Login Page (userName.passWord)");
        //login button
        driver.findElement(By.xpath("//input[@name='login-submit']")).click();
        //screenShot
        Soft_Assertion.screenShotName(driver,"Employee Home Page");

        Thread.sleep(1000);
        driver.close();
        soft.assertAll(); // without Assertion will not Work



    }
    public static void screenShotName(WebDriver driver, String name) throws IOException {
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // project file
        FileUtils.copyFile(source,new File("C:\\Java\\workspaceintellij\\windowHandling\\screenShot\\"+name+".png"));
        // computer file
        FileUtils.copyFile(source,new File("C:\\Java\\screenShotIntellij\\"+name+".png"));
    }

}
