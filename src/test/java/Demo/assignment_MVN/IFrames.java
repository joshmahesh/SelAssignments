package Demo.assignment_MVN;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class IFrames {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Frames.html");
        driver.manage().window().maximize();
    }

    @Test
    public void switching() throws InterruptedException {        
    
        WebElement iframe = driver.findElement(By.id("singleframe"));        
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Testing iframe using selenium.");
        }

    @AfterClass
   public void quit() {
        driver.quit();
    }
    }