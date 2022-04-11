import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowser {
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;
    static String browser = "chrome";

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            System.out.println("Browser not  found");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(baseUrl);
        String title = driver.getTitle();
        System.out.println(title);
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        WebElement logIN =driver.findElement(By.id("txtUsername"));
        logIN.sendKeys("prime123@gmail.com");
        WebElement passWord = driver.findElement(By.id("txtPassword"));
        passWord.sendKeys("prime123");
        driver.close();
    }
}
