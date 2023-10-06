package windowHandle_Handles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiApplications_Handle {
    public static void main(String[] args) throws InterruptedException {
        //WebDriverManager.chromedriver().setup();
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.navigate().to("https://www.ebay.com/");

        String firstWindow = driver.getWindowHandle();
        System.out.println("1st: " + firstWindow);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.amazon.com/");

        String secondWindow = driver.getWindowHandle();
        System.out.println("2nd: " + secondWindow);
        Thread.sleep(1000);

        //type Casting for scrollDown
        //in selenium don't have any scroll down class. so we need help by JavaScriptExecutor.
        JavascriptExecutor js = (JavascriptExecutor)driver;
        Thread.sleep(2000);

        //scrollDown window
        WebElement element = driver.findElement(By.cssSelector("a[id='icp-touch-link-language'] span[class='icp-color-base']"));
        Thread.sleep(2000);


        js.executeScript("arguments[0].scrollIntoView();",element);
        Thread.sleep(1000);
        element.click();


    }
}
