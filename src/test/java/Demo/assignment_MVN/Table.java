package Demo.assignment_MVN;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Table {

	    private WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	        
	        System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.get("https://qavbox.github.io/demo/webtable/");
	    }

	    @Test
	    public void verifyContent() {
	        
	        List<List<String>> expectedResult = new ArrayList<>();
	        
	        expectedResult.add(List.of("","Functional", "QTP", "Bugzilla",""));
	        expectedResult.add(List.of("","GUI", "Selenium", "TFS",""));
	        expectedResult.add(List.of("","Performance", "Coded UI", "QC ALM",""));
	        
	        List<List<String>> actualResult = extractTableData();
	        
	        Assert.assertEquals(actualResult, expectedResult, "Expected and Actual Table data does not match.");
	    }

	    private List<List<String>> extractTableData() {
	        List<List<String>> tableData = new ArrayList<>();
	        
	        WebElement table = driver.findElement(By.id("table01"));
	        
	        List<WebElement> rows = table.findElements(By.tagName("tr"));

	        for (int i = 0; i < rows.size(); i++) {
		        WebElement row = rows.get(i); 
		        List<WebElement> cells = row.findElements(By.tagName("td"));
		        List<String> rowData = new ArrayList<>(); 

		        
		        for (int j = 0; j < cells.size(); j++) {
		            WebElement cell = cells.get(j);
		            rowData.add(cell.getText().trim()); 
		        }

		        
		        if (!rowData.isEmpty()) {
		            tableData.add(rowData);
		        }
		    }

		    return tableData;
		    }
	    
	   @AfterClass
	    public void quit() {
	        driver.quit();
	    }
	}
	
