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

	private String  movieReleaseDate= "17 December 2020";
	private String  movieCountry= "India";
	@Test
private void extractTheDetailsOfTheMovieTest() throws InterruptedException {
		System.setProperty("webdriver.opera.driver", "D:\\operadriver.exe");
		WebDriver driver=new OperaDriver();
		driver.manage().window().maximize();
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Pushpa: The Rise");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='searchButton']")).click();
		Thread.sleep(3000);
		WebElement releaseDate = driver.findElement(By.xpath("//*[@id='mw-content-text']//tr/th//div[text()='Release date']/parent::th/following-sibling::td//li"));
		assertEquals(releaseDate.getText(), movieReleaseDate,"Release date is not matched for pushpa movie");
		WebElement country = driver.findElement(By.xpath("//*[@id='mw-content-text']//tr/th[text()='Country']/following-sibling::td"));
		assertEquals(country.getText(), movieCountry,"Country is not matched for pushpa movie");
		
		driver.quit();
}
}
