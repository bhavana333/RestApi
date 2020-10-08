Feature: Exchange rates API for Latest Foreign Exchange rates
  

  Scenario: Verify the response for success status of given rates API
    Given Rates API for Latest Foreign Exchange rates
    When The API is available 
    Then verify the success status of the response