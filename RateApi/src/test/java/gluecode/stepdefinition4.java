package gluecode;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepdefinition4 {
	Response response;
	int var=0;
	@Given("^Rates API for Specific date Foreign Exchange rates$")
	public void rates_API_for_Specific_date_Foreign_Exchange_rates() throws Exception {
	    
		response = RestAssured.get("https://api.ratesapi.io/api/2010-01-12");
	    	}
	@When("^The API is available$")
	public void the_API_is_available() throws Exception {
	   
		if(response.getStatusCode()!=404) {
			 var++;			
		}
	}

	@Then("^verify the success status of the response$")
	public void verify_the_success_status_of_the_response() throws Exception{
	   
		System.out.println("Scenario4 \n");
		if(var==1) {
			//Validating STATUS CODE from response
			  int statusCode = response.getStatusCode();
			  Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "InCorrect status code returned");
			  System.out.println("status code is success");
			//Validating STATUS LINE from response
			  String statusLine = response.getStatusLine();
			  Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "InCorrect status Line returned");
			  System.out.println("status line is success");
		}
		else {
			System.out.println("Given API is not avaialble");
		}
	}




}
