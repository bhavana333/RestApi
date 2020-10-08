Feature: Exchange rates API for Latest Foreign Exchange rates
  

  Scenario: Verify the response for success status of given rates API
    Given Rates API for Latest Foreign Exchange rates-1
    When The API is available-1
    Then verify the success status of the response-1
    
  Scenario: Verify the response for the given API
    Given Rates API for Latest Foreign Exchange rates-1
    When The API is available-1
    Then verify the response-1
    
  Scenario: validate the correct response supplied by the call 
    Given Rates API for Latest Foreign Exchange rates-1
    When An incorrect or incomplete url is provided e.g: https://api.ratesapi.io/api/ 
    Then  validate the correct response supplied by the call-1
    