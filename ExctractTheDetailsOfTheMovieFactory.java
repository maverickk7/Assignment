package codeingtest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExctractTheDetailsOfTheMovieFactory {

WebDriver driver; 
	
	@FindBy(xpath = "//input[@name='search']")
	WebElement searchTextfield;
	
	@FindBy(xpath = "//input[@id='searchButton']")
	WebElement searchButton;
	
	@FindBy(xpath = "//*[@id='mw-content-text']//tr/th//div[text()='Release date']/parent::th/following-sibling::td//li")
	WebElement releaseDate;
	
	@FindBy(xpath = "//*[@id='mw-content-text']//tr/th[text()='Country']/following-sibling::td")
	WebElement country;
	
	
	public ExctractTheDetailsOfTheMovieFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterMovieName(String movieName) {
		searchTextfield.sendKeys(movieName);
	}
	public void clickOnSearchButton() {
		searchButton.click();
	}
	public void verifyReleaseDate(String movieReleaseDate) {
		assertEquals(releaseDate.getText(), movieReleaseDate,"Release date is not matched for pushpa movie");
	}
	
	public void verifyCountry(String movieCountry) {
		assertEquals(country.getText(), movieCountry,"Country is not matched for pushpa movie");
	}
}
