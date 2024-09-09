package Demo.assignment_MVN;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowHandling {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
    }

    @Test
    public void switching() throws InterruptedException {
        driver.findElement(By.linkText("Click Here")).click();

        
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(windowHandles);

        driver.switchTo().window(windowHandlesList.get(1));
        
        String newTabTitle = driver.getTitle();
        Assert.assertEquals(newTabTitle, "New Window");
        
        driver.close();
        driver.switchTo().window(windowHandlesList.get(0));
        
        String basePageTitle = driver.getTitle();
        Assert.assertEquals(basePageTitle, "The Internet");
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
    }