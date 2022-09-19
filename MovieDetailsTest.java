package codingtest;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MovieDetailsTest {
		
	@Test
	public void extractTheDetailsOfTheMovieTest() throws InterruptedException {
			System.setProperty("webdriver.opera.driver", "D:\\operadriver.exe");
			WebDriver driver=new OperaDriver();

//			maximize browser window
			driver.manage().window().maximize();
		/////////////////////     wikipedia      //////////////////////////	
//	 		launch the URL		
			driver.get("https://en.wikipedia.org/wiki/Main_Page");
	
			MovieDetailsPom obj= new MovieDetailsPom(driver);
			
//			Entered movie name into search box
			obj.enterMovieNamewiki("Pushpa: The Rise");
			Thread.sleep(3000);
			
//			clicked on search button		
			obj.clickOnSearchButtonwiki();
			Thread.sleep(3000);	
			
//			Stored string of release date and country of origin from wikipedia
			String actual = obj.releaseDateWiki.getText();
			String actual1 = obj.countrytextWiki.getText();
			
//	/////////////////////////		IMDB      launch the url imdb			////////////////////////
			driver.get("https://www.imdb.com/?ref_=nv_home");

			// entered movie name on imdb site
			obj.enterMovieNameIMDB("Pushpa: The Rise - Part 1");
			
			// clicked on search button
			obj.clickOnSearchButtonIMDB();
			
			// Clicked on search result
			obj.clickSearchResultIMDB();
			
//		Stored string of release date and country of origin from IMDB
			String expected = obj.releaseDateIMDB.getText();
			String expected1 = obj.countrytextImdb.getText();
			
//		used soft assertion
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(actual, expected);
			soft.assertEquals(actual1, expected1);
			System.out.println("Country matched");
			soft.assertAll();			

			driver.quit();		
}
	
                         
}
