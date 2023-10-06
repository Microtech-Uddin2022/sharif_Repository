package practice_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.Assert;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hard_Assertion {
    public static void main(String[] args) throws InterruptedException {

        //WebDriverManager.chromedriver().setup();
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://it.microtechlimited.com/");
        driver.manage().window().maximize();

        //get title
        System.out.println(driver.getTitle());
        assertTrue(driver.getTitle().equals("MicroTech NA.")); // no need to make object (static)
        //Assert.assertTrue(driver.getTitle().equals("MicroTech NA.")); // none static
        Thread.sleep(1000);

        //login
        driver.findElement(By.xpath("//a[text()='LOG IN']")).click();
        Thread.sleep(1000);
        //username
        driver.findElement(By.xpath("//input[@name='mailuid']")).sendKeys("testpilot@gmail.com");
        Thread.sleep(1000);
        //password
        driver.findElement(By.xpath("//input[@name='pwd']")).click();
        Thread.sleep(1000);
        //login button
        driver.findElement(By.xpath("//input[@name='login-submit']")).click();



    }
}
