package codingtest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MovieDetailsPom {
		
	WebDriver driver;
	// for wiki
	@FindBy(xpath = "//input[@name='search']")
	WebElement searchTextfield;
	
	@FindBy(xpath = "//input[@id='searchButton']")
	WebElement searchButtonWiki;
	
	@FindBy(xpath = "(//td[@class='infobox-data'])[10]/div/ul/li")
	WebElement releaseDateWiki;
	
	@FindBy(xpath = "//table[@class='infobox vevent']/tbody/tr[14]/td")
	WebElement countrytextWiki;
	
// for imdb	
	@FindBy(xpath = "//input[@id='suggestion-search']")
	WebElement searchTextfieldimdb;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchButtonimdb;
	
	@FindBy(xpath = "//a[text()='Pushpa: The Rise - Part 1']")
	WebElement searchResultimdb;
	
	@FindBy(xpath = "(//a[@class='ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link'])[24]")
	WebElement releaseDateIMDB;
	
	@FindBy(xpath = "(//div[@class='sc-f65f65be-0 ktSkVi'])[2]/ul/li/following-sibling::li/div/ul/li/a")
	WebElement countrytextImdb;
	
	public  MovieDetailsPom(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//		WIKI
	public void enterMovieNamewiki(String movieName) {
		searchTextfield.sendKeys(movieName);
	}
	public void clickOnSearchButtonwiki() {
		searchButtonWiki.click();
	}

	
	//		IMDB
	public void enterMovieNameIMDB(String movieName) {
		searchTextfieldimdb.sendKeys(movieName);
	}
	public void clickOnSearchButtonIMDB() {
		searchButtonimdb.click();
	}
	public void clickSearchResultIMDB() {
		searchResultimdb.click();
	}
	

}
