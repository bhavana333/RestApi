package gluecode;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import cucumber.api.java.en.Then;

public class stepdefinition2 {
	Response response;
	public int var=0;
	@Given("^Rates API for Latest Foreign Exchange rates-2$")
	public void rates_API_for_Latest_Foreign_Exchange_rates() throws Exception {
		response = RestAssured.get("https://api.ratesapi.io/api/latest");
	}
	
	@When("^The API is available-2$")
	public void the_API_is_available() throws Exception {
		if(response.getStatusCode()==200) {
			 var++;			
		}
	}
	@Then("^verify the response-2$")
	public void verify_the_response() throws Exception {
		System.out.println("Scenario2 \n");
		if(var==1) {
			//Validating CONTENT TYPE from response
			String contentType = response.getContentType();
			Assert.assertEquals(contentType /* actual value */, "application/json" /* expected value */);
			
			//Validating text from response
			String responseBody = response.getBody().asString();
			Assert.assertEquals(responseBody.contains("PHP") /*Expected value*/, true /*Actual Value*/, "Response body does not contain PHP");
			Assert.assertEquals(responseBody.toLowerCase().contains("php") /*Expected value*/, true /*Actual Value*/, "Response body does not contain php");
			System.out.println("Response is verified");
		}
		else {
			System.out.println("API is not available");
		}
	}

}
