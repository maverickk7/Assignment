package codeingtest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class ExtractTheDetailsOfTheMovieTests {

	public String  movieReleaseDate= "17 December 2021";
	public String  movieCountry= "India";
	@Test
public void extractTheDetailsOfTheMovieTest() throws InterruptedException {
		System.setProperty("webdriver.opera.driver", "D:\\operadriver.exe");
		WebDriver driver=new OperaDriver();
		
//		maximize browser window
		driver.manage().window().maximize();
		
// 		launch the URL		
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		
		ExctractTheDetailsOfTheMovieFactory obj= new ExctractTheDetailsOfTheMovieFactory(driver);
		
//		Entered movie name into search box
		obj.enterMovieName("Pushpa: The Rise");
		Thread.sleep(3000);
		
//		clicked on search button		
		obj.clickOnSearchButton();
		Thread.sleep(3000);
		
//		verify that release date is correct		
		obj.verifyReleaseDate(movieReleaseDate);
		
//		verify that country is correct	
		obj.verifyCountry(movieCountry);
		
//		closed the browser	
		driver.quit();
}
}
