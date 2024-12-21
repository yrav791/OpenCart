package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

	
	public SearchPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(name="search") WebElement text_item;
	@FindBy(xpath="//span[@class='input-group-btn']//button") WebElement btn_search;
	@FindBy(xpath="//h2[normalize-space()='Products meeting the search criteria']") WebElement msgHeading;
	
	public void setSearchText(String itemName) {
		text_item.sendKeys(itemName);
	}
	
	public void clickSearchBtn() {
		btn_search.click();
	}
	
	public boolean getConfirmationMsg() {
		try {
		return msgHeading.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
}
