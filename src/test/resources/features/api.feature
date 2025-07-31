@APITest
  Feature: User API


    Scenario: Get user list
      Given I have user list
      When I send GET request to user API
      And response status should be 200
