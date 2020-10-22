Feature: Test the status of latest foreign exchange rates API
Scenario: Verify the latest foreign exchange API response
Given Rates API for latest foreign exchange rates
When Provided API is Available
Then Verify the status code of the response is success