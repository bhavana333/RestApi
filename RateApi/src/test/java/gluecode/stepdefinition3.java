package gluecode;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepdefinition3 {
	Response response;
	@Given("^Rates API for Latest Foreign Exchange rates-3$")
	public void rates_API_for_Latest_Foreign_Exchange_rates() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		response = RestAssured.get("https://api.ratesapi.io/api/latest");
	   
	}
	@When("^An incorrect or incomplete url is provided e\\.g: https://api\\.ratesapi\\.io/api/$")
	public void an_incorrect_or_incomplete_url_is_provided_e_g_https_api_ratesapi_io_api() throws Exception {
		response =  RestAssured.get("https://api.ratesapi.io/api/");
	}

	@Then("^validate the correct response supplied by the call-3$")
	public void validate_the_correct_response_supplied_by_the_call() throws Exception {
		System.out.println("Scenario3");
		System.out.println(response.getBody().asString());
		Assert.assertEquals(response.getStatusCode(), 400,"Given URL is available");
}
}
 