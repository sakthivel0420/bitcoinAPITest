package com.TestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
public class TestAPI {
	
	    WebDriver driver;

	    // Just a comment
	    public void setUp() {
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	        driver = new ChromeDriver();
	    }

	   
	    public void testJSONResponse() {
	        driver.get("https://api.coindesk.com/v1/bpi/currentprice.json");
	        String response = driver.findElement(By.tagName("pre")).getText();

	        JsonParser parser = new JsonParser();
	        JsonObject json = parser.parse(response).getAsJsonObject();

	        String time = json.get("time").getAsJsonObject().get("updated").getAsString();
	        String rate = json.get("bpi").getAsJsonObject().get("USD").getAsJsonObject().get("rate").getAsString();

	        Assert.assertNotNull(time);
	        Assert.assertNotNull(rate);
	    }

	    
	    public void tearDown() {
	        driver.quit();
	    }
	}



