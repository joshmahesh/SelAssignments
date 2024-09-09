package Demo.assignment_MVN;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDrop {

	    private WebDriver driver;
	   
	    @BeforeMethod
	    public void setUp() {
	        System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
	        driver = new ChromeDriver();
	        
	        }

	    @Test
	    public void verifyDragAndDrop() {
	        
	    	driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
	        driver.findElement(By.id("mainContainer"));
	        
	        WebElement source = driver.findElement(By.id("box3"));
	        WebElement target = driver.findElement(By.id("box103"));

	         Actions actions = new Actions(driver);

	        actions.dragAndDrop(source, target).perform();
	                       
	        String expectedColor = ("rgba(0, 255, 0, 1)");
	        String actualColor = source.getCssValue("background-color");
	        
	        Assert.assertEquals(actualColor, expectedColor);
	        
	        //Testing comment for Gitbb

	    }
	    @AfterMethod
	    public void close() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}