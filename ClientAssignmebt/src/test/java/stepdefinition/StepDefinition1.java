package stepdefinition;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StepDefinition1 {
	Response response;
	public int var=0;
	
	@Given("^Rates API for Latest Foreign Exchange rates-(\\d+)$")
	public void rates_API_for_Latest_Foreign_Exchange_rates(int arg1) throws Exception {
		response = RestAssured.get("https://api.ratesapi.io/api/latest");  
	}

	@When("^The API is available-(\\d+)$")
	public void the_API_is_available(int arg1) throws Exception {
		if(response.getStatusCode()==200) {
			 var++;			
		}
	   
	}

	@Then("^verify the success status of the response-(\\d+)$")
	public void verify_the_success_status_of_the_response(int arg1) throws Exception {
		System.out.println("Scenario1 \n");
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

	@Then("^verify the response-(\\d+)$")
	public void verify_the_response(int arg1) throws Exception {
		System.out.println("Scenario2 \n");
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

	@When("^An incorrect or incomplete url is provided e\\.g: https://api\\.ratesapi\\.io/api/$")
	public void an_incorrect_or_incomplete_url_is_provided_e_g_https_api_ratesapi_io_api() throws Exception {
		response =  RestAssured.get("https://api.ratesapi.io/api/");
	}

	@Then("^validate the correct response supplied by the call-(\\d+)$")
	public void validate_the_correct_response_supplied_by_the_call(int arg1) throws Exception {
		System.out.println("Scenario3 \n");
		System.out.println(response.getBody().asString() + "\n");
		Assert.assertEquals(response.getStatusCode(), 400,"Given URL is available");
	    
	}

	


}
