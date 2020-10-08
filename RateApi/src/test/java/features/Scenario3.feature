Feature: Exchange rates API for Latest Foreign Exchange rates
  

  Scenario: validate the correct response supplied by the call 
    Given Rates API for Latest Foreign Exchange rates
    When An incorrect or incomplete url is provided e.g: https://api.ratesapi.io/api/ 
    Then  validate the correct response supplied by the call 
