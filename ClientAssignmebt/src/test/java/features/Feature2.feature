Feature: Exchange rates API for Specific date Foreign Exchange rates
  
  
  Scenario: Verify the response for success status of given rates API
    Given Rates API for Specific date Foreign Exchange rates-2
    When The API is available for date
    Then verify the success status of the date response  
    
  Scenario: Verify the response for the given API
    Given Rates API for Specific date Foreign Exchange rates-2
    When The API is available for date
    Then verify the date response
    
  
  Scenario: validate the correct response supplied by the call 
    Given Rates API for Specific date Foreign Exchange rates-2
    When A future date is provided in the url
    Then  validate the correct response for current date supplied by the call