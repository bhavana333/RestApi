package stepdefinition;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StepDefinition2 {
	Response response;
	int var=0;
	@Given("^Rates API for Specific date Foreign Exchange rates-(\\d+)$")
	public void rates_API_for_Specific_date_Foreign_Exchange_rates(int arg1) throws Exception {
		response = RestAssured.get("https://api.ratesapi.io/api/2010-01-12");  
	}

	@When("^The API is available for date$")
	public void the_API_is_available_for_date() throws Exception {
		if(response.getStatusCode()!=404) {
			 var++;		}
	    	  
	}

	@Then("^verify the success status of the date response$")
	public void verify_the_success_status_of_the_date_response() throws Exception {
		System.out.println("Scenario4 \n");
		if(var==1) {
			//Validating STATUS CODE from response
			  int statusCode = response.getStatusCode();
			  Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "InCorrect status code returned");
			  System.out.println("status code is success");
			//Validating STATUS LINE from response
			  String statusLine = response.getStatusLine();
			  Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "InCorrect status Line returned");
			  System.out.println("status line is success \n");
		}
		else {
			System.out.println("Given API is not avaialble \n");
		}
	}

	@Then("^verify the date response$")
	public void verify_the_date_response() throws Exception {
		System.out.println("Scenario5 \n");
		if(var==1) {
			//Validating CONTENT TYPE from response
			String contentType = response.getContentType();
			Assert.assertEquals(contentType /* actual value */, "application/json" /* expected value */);
			
			
			//Validating text from response
			String responseBody = response.getBody().asString();
			Assert.assertEquals(responseBody.contains("PHP") /*Expected value*/, true /*Actual Value*/, "Response body does not contain PHP");
			Assert.assertEquals(responseBody.toLowerCase().contains("php") /*Expected value*/, true /*Actual Value*/, "Response body does not contain php");
			System.out.println("Response is verified \n");
		}
		else {
			System.out.println("API is not available \n");
		}
	    
	}

	@When("^A future date is provided in the url$")
	public void a_future_date_is_provided_in_the_url() throws Exception {
		response = RestAssured.get("https://api.ratesapi.io/api/2020-11-12");
	}

	@Then("^validate the correct response for current date supplied by the call$")
	public void validate_the_correct_response_for_current_date_supplied_by_the_call() throws Exception {
		System.out.println("Scenario6 \n");
		System.out.println(response.getBody().asString());
		Assert.assertEquals(response.getStatusCode(),200);
	}


	
}
