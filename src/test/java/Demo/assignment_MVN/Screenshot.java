package Demo.assignment_MVN;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;


public class Screenshot {
	    
	    private WebDriver driver;
	   // private WebDriverWait wait;

	    @BeforeClass
	    public void setUp() {
	      
	        System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
	        driver = new ChromeDriver();
	       // wait = new WebDriverWait(driver, 10);
	        
	        // Navigate to the demo site
	        driver.get("https://staging-app-user.blunode.in/sign_up");
	    }

	    @Test
	    public void testFormSubmission() throws IOException {
	        // Locate form elements
	    	
	    	 File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		     FileUtils.copyFile(screenshotFile,new File(".\\Screenshots\\BeforeFillingData.png"));
		        
	        driver.findElement(By.name("firstName")).sendKeys("Josh");
	        driver.findElement(By.name("lastName")).sendKeys("Software");
	        driver.findElement(By.name("email")).sendKeys("josh12@gmail.com");
	        driver.findElement(By.name("phoneNumber")).sendKeys("9870123456");
	        driver.findElement(By.name("password")).sendKeys("Josh@12345");
	        driver.findElement(By.name("confirmPassword")).sendKeys("Josh@12345");
	        
	        File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(screenshotFile1,new File(".\\Screenshots\\AfterFillingData.png"));
	            
	    }

	    @AfterClass
	    public void tearDown() {
	        // Close the browser
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}
