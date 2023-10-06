package windowHandle_Handles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v114.fedcm.model.Account;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Set;

public class WindowHandle_Handles {
    public static void main(String[] args) throws InterruptedException {

        //WebDriverManager.chromedriver().setup();
        WebDriver driver;
        driver = new ChromeDriver();

        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

//        String  firstWindow = driver.getWindowHandle();
//        System.out.println("12345");

//        String wId = driver.getWindowHandle();
//
//        System.out.println(wId);

        // String firstWindow = driver.getWindowHandle();

        // Search Box X-Path
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Samsung S22");

        // Search button X-Path
        driver.findElement(By.id("nav-search-submit-button")).click();

        // Click the first option
        driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();



        // Second Window
        Set<String> s = driver.getWindowHandles();// changeable that's why make arraylist
        ArrayList ar = new ArrayList<>(s);

        System.out.println("Window0: " + ar.get(0));
        System.out.println("Window Samsung: " + ar.get(1));

        driver.switchTo().window((String) ar.get(1));

        // Click add to cart button
        driver.findElement(By.id("add-to-cart-button")).click();

        Thread.sleep(4000);

        //Actions act = new Actions(driver);
        //act.sendKeys(Keys.ESCAPE).build().perform();
        // driver.findElement(By.className("a-button-input")).click();

        // Add to cart in pop up window
        driver.findElement(By.xpath("//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']")).click();




        //Switched to Parent Window
        driver.switchTo().window((String) ar.get(0));

        //clear search box
        driver.findElement(By.xpath("//input[@type='text']")).clear();
        Thread.sleep(2000);
        //laptop
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Laptop");
        Thread.sleep(2000);
        //search
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(2000);

        //New Laptop Click
        driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
        Thread.sleep(3000);
//        Thread.sleep(1000);
//        driver.findElement(By.id("add-to-cart-button")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
//        Worked Properly


        Set<String> abc = driver.getWindowHandles();
        ArrayList xyz = new ArrayList<>(abc);

        driver.switchTo().window((String) xyz.get(0));
        System.out.println("Window Laptop: " + xyz.get(2));

        driver.switchTo().window((String) xyz.get(2));
        //driver.switchTo().window((String) xyz.get(1));

        //Thread.sleep(2000);
        driver.findElement(By.id("add-to-cart-button")).click();

        Thread.sleep(2000);
        //Actions act1 = new Actions(driver);

        driver.findElement(By.xpath("//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']")).click();

        driver.switchTo().window((String) xyz.get(2));
        Thread.sleep(2000);
        driver.close();

        Thread.sleep(2000);
        //driver.quit();


    }
}
