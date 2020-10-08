Feature: Exchange rates API for Specific date Foreign Exchange rates
  

  Scenario: validate the correct response supplied by the call 
    Given Rates API for Specific date Foreign Exchange rates
    When A future date is provided in the url 
    Then  validate the correct response supplied by the call 