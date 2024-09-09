package Demo.assignment_MVN;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUpload {

	    private WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	        
	        System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.get("https://the-internet.herokuapp.com/upload");
	    }

	    @Test
	    public void verifyUpload() {
	        
	       driver.findElement(By.name("file")).sendKeys("C:\\Users\\Mahesh\\Selenium\\Assignment_MVN\\Excel.xlsx");
	       driver.findElement(By.id("file-submit")).click();
	       
	       
	       String actualText = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();
	       String expText = "File Uploaded!";
	       
	       Assert.assertEquals(actualText, expText);
	    }

	   @AfterClass
	    public void quit() {
	        driver.quit();
	    }
	}