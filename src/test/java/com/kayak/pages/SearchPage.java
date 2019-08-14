package com.kayak.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kayak.utils.BaseClass;

public class SearchPage extends BaseClass{
	
	@FindBy (id="logo")
	public WebElement kayakLogo;

	@FindBy (xpath="//div[contains(@id, '-origin-airport-display')]")
	public WebElement originBox;
	
	@FindBy (xpath="//div[contains(@id, '-destination-airport-display')]")
	public WebElement destinationBox;
	
	@FindBy (xpath="//input[@name='origin']")
	public WebElement originInput;
	
	@FindBy (xpath="//input[@name='destination']")
	public WebElement destinationInput;
	
	@FindBy (xpath="//div[contains(@id, 'dateRangeInput-display-start')]")
	public WebElement departDateBox;
	
	@FindBy (xpath="//*[@id='stl-jam-cal-prevMonth']")
	public WebElement prevMonthNaviator;
	
	@FindBy (xpath="//*[@id='stl-jam-cal-nextMonth']")
	public WebElement nextMonthNavigator;
	
	// Left Displayed Month DatePikcer
	@FindBy (xpath="//*[@id='stl-jam-cal-monthsGrid']/div[2]/div/div")
	public WebElement leftDisplayedMonth;
	
	// Dates from Left DatePicker
	@FindBy (xpath="//*[@id='stl-jam-cal-monthsGrid']/div[2]/div/div[@class='weeks ']/div/div/div")
	public List<WebElement> leftDates;
	
	// Right Displayed Month DatePicker
	@FindBy (xpath="//*[@id='stl-jam-cal-monthsGrid']/div[3]/div/div")
	public WebElement rightDisplayedMonth;
	
	// Dates from Right DatePicker
	@FindBy (xpath="//*[@id='stl-jam-cal-monthsGrid']/div[3]/div/div[@class='weeks ']/div/div/div")
	public List<WebElement> rightDates;
	
	@FindBy (xpath="//div[contains(@id, 'dateRangeInput-display-end')]")
	public WebElement returnDateBox;
	
	@FindBy (xpath="//*[@title='Search flights']")
	public WebElement searchBtn;
	
	@FindBy (xpath="//div[@class='best-flights-list-results']")
	public WebElement bestResult;
	
	@FindBy (xpath="//div[@class='section times']//div[@class='top']/span[1]/span[1]")
	public List<WebElement> departTime;
	
	@FindBy (xpath="//div[@class='section times']//div[@class='top']/span[1]/span[2]")
	public List<WebElement> departTimeMeridiem;
	
	@FindBy (xpath="//div[@class='section times']//div[@class='top']/span[3]/span[1]")
	public List<WebElement> arrivalTime;
	
	@FindBy (xpath="//div[@class='section times']//div[@class='top']/span[3]/span[2]")
	public List<WebElement> arrivalTimeMeridiem;
	
	@FindBy (xpath="//div[@class='section times']//div[@class='top']//following-sibling::div")
	public List<WebElement> airLine;
	
	@FindBy (xpath="//div[@class='section stops']//div[@class='top']")
	public List<WebElement> stops;
	
	@FindBy (xpath="//div[@class='section duration']//div[@class='top']")
	public List<WebElement> duration;
	
	@FindBy (xpath="//div[@class='section duration']//div[@class='bottom']/span[1]")
	public List<WebElement> from;
	
	@FindBy (xpath="//div[@class='section duration']//div[@class='bottom']/span[2]")
	public List<WebElement> to;
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
}
