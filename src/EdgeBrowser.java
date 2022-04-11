import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class EdgeBrowser {
    public static void main(String[] args) {
        String baseURL = "https://opensource-demo.orangehrmlive.com/";
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
        WebDriver driver =  new EdgeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String title = driver.getTitle();
        System.out.println(title);
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        WebElement emailID = driver.findElement(By.id("txtUsername"));
        emailID.sendKeys("prime123@gamil.com");
        WebElement passWORD = driver.findElement(By.id("txtPassword"));
        passWORD.sendKeys("prime123");
        driver.close();
    }
}
