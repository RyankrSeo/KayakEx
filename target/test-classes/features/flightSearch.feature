Feature: 

	Scenario Outline: basic search scenario for kayak website
	Given I Go to Kayak.com 
	When I Enter "<Origin>" and "<Destination>" Cities
	And I Select "<Departure>" and "<Return>" Dates
	When I Click Search
	And On search results page, I select the search result N, where N is the input data
	And Assert the "<Origin>" and "<Destination>" Details are same as the one entered in the main screen
	Then Log all critical information of the selected flight option, for the reporting purpose
	
	Examples: 
	|Origin|Destination|Departure|Return|
	|BWI|LAS|August 14|October 30|
	|CLT|JFK|August 14|November 30|
	|LAX|ORD|August 30|December 30|
