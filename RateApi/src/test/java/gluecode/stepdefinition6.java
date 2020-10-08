package gluecode;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class stepdefinition6 {
		Response response;
		@Given("^Rates API for Specific date Foreign Exchange rates$")
		public void rates_API_for_Specific_date_Foreign_Exchange_rates() throws Exception{
			response = RestAssured.get("https://api.ratesapi.io/api/2010-01-12");
		    	}

		@When("^A future date is provided in the url e\\.g: https://api\\.ratesapi\\.io/api/2020-22-11")
		public void an_incorrect_or_incomplete_url_is_provided_e_g_https_api_ratesapi_io_api() throws Exception {
			response = RestAssured.get("https://api.ratesapi.io/api/2020-12-11");

		}

		@Then("^validate the correct response supplied by the call$")
		public void validate_the_correct_response_supplied_by_the_call() throws Exception {
			System.out.println("Scenario6");
			System.out.println(response.getBody().asString());
			Assert.assertEquals(response.getStatusCode(), 404,"Given URL is available");
	}

	}
