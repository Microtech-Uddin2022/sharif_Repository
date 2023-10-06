package browserTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CrossBrowserTestingPropertiesFiles {
    public static void main(String[] args) throws IOException {
        // static/whole path file
        //String path = "C:\\Java\\workspaceintellij\\windowHandling\\config.properties";
        // dynamic by . (dot) (ABD)
        String path = ".\\config.properties";
        Properties prop = new Properties();

        //File file = new File("config.properties");

        // streaming connecting the file
        FileInputStream fis = new FileInputStream(path);
        // loading the streaming file
        prop.load(fis);

        WebDriver driver;
        driver = null;

        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else {
            System.out.println("Provide a valid Browser Name");
        }
        driver.get("https://www.cnn.com");
        driver.manage().window().maximize();
    }
}
