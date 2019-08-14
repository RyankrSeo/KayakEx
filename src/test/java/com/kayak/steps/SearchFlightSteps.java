package com.kayak.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.kayak.pages.SearchPage;
import com.kayak.utils.Commons;
import com.kayak.utils.ExcelUtility;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchFlightSteps extends Commons {
	SearchPage search;
	List<WebElement> resultList= new ArrayList<>();	
	
	@Given("I Go to Kayak.com")
	public void i_Go_to_Kayak_com() {
		search = new SearchPage();
		Assert.assertTrue("Kayak Logo is not found", search.kayakLogo.isDisplayed());
		
		ExcelUtility obj = new ExcelUtility();
		obj.openExcel(excelFilePath, "SearchFlight");
		List<Map<String, String>> excelDataList = obj.getCellDataList();
		System.err.println(excelDataList);
	}

	@When("I Enter {string} and {string} Cities")
	public void i_Enter_and_Cities(String orig, String dest) throws InterruptedException {
		ExplicitWaitElementBeClickable(search.originBox, 5);
		jsClick(search.originBox);
		
		ExplicitWaitElementBeClickable(search.originInput, 5);
		sendText(search.originInput, orig);

		ExplicitWaitElementBeClickable(search.destinationBox, 5);
		jsClick(search.destinationBox);
		
		ExplicitWaitElementBeClickable(search.destinationInput, 5);
		sendText(search.destinationInput, dest);

	}

	@When("I Select {string} and {string} Dates")
	public void i_Select_and_Dates(String departDate, String returnDate) {
		String[] dDateArry = departDate.split(" ");
		String departMonth = dDateArry[0];
		String departDay = dDateArry[1];
		
		String[] rDateArry = returnDate.split(" ");
		String returnMonth = rDateArry[0];
		String returnDay = rDateArry[1];
		
		selectDatefromDatePicker(search.departDateBox, departMonth, departDay);
		selectDatefromDatePicker(search.returnDateBox, returnMonth, returnDay);

	}

	public void selectDatefromDatePicker(WebElement dateBox, String month, String day) {
		
		//click depart date Box
		jsClick(search.departDateBox);
		
		boolean isRightSelected = false;
		//compare depart month and select
		while(!search.leftDisplayedMonth.getText().contains(month)) {
			if(search.rightDisplayedMonth.getText().contains(month)){
				//stop and select rigth month
				isRightSelected = true;
				break;
			}
			click(search.nextMonthNavigator);
		
			search.leftDisplayedMonth = driver.findElement(By.xpath("//*[@id='stl-jam-cal-monthsGrid']/div[2]/div/div"));
			search.rightDisplayedMonth = driver.findElement(By.xpath("//*[@id='stl-jam-cal-monthsGrid']/div[3]/div/div"));
		}
		//select datepicker for depart month
		List<WebElement> dateList = null;
		if(isRightSelected) {
			dateList = search.rightDates;
		}else {
			dateList = search.leftDates;
		}
		
		//select depart date from datepicker
		for(WebElement date:dateList) {
			if(date.getText().equals(day)) {
				click(date);
				break;
			}
		}
	}
	
	@When("I Click Search")
	public void i_Click_Search() {
	   click(search.searchBtn);
	}

	@When("On search results page, I select the search result N, where N is the input data")
	public void on_search_results_page_I_select_the_search_result_N_where_N_is_the_input_data() {
		ExplicitWaitElementBeClickable(search.bestResult, 30);
		click(search.bestResult);

	}

	@When("Assert the {string} and {string} Details are same as the one entered in the main screen")
	public void assert_the_and_Details_are_same_as_the_one_entered_in_the_main_screen(String orig, String dest) {
		
		resultList= driver.findElements(By.xpath("//div[@class='detailsWrapper']//span[@class='origin-destination']"));
		resultList.get(0).getText();
		resultList.get(1).getText();
		
		Assert.assertEquals("Expected not match", orig+" - "+dest , resultList.get(0).getText());
		Assert.assertEquals("Expected not match", dest+" - "+orig , resultList.get(1).getText());

	}

	@Then("Log all critical information of the selected flight option, for the reporting purpose")
	public void log_all_critical_information_of_the_selected_flight_option_for_the_reporting_purpose() {
	   for(int i=0; i<resultList.size(); i++) {
		   System.out.println(
				   search.airLine.get(i)+ " : " 
						   + search.departTime.get(i)+ " "
						   + search.departTimeMeridiem.get(i)+ " - "
						   + search.arrivalTime.get(i)+ " "
						   + search.arrivalTimeMeridiem.get(i)+ " "
						   + search.stops.get(i) +" "
						   + search.duration.get(i)+ " "
						   + search.from.get(i)+ " - "
						   + search.to.get(i));
		   if(i%2==0) System.out.println();
	   }
	}

}
