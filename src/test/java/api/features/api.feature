@api
  Feature: User API


    Scenario: Get user list
      Given I have user list
      When I send GET request to user API
      And response status should be 200

    Scenario: Update user with PUT
      Given I set base URI to reqres
      When I send PUT request to update user with userID 2 with name "Elsa"
      And response status should be 200

    Scenario: Partially update user with PATCH
        Given I set base URI to reqres
        When I send PATCH request to partially update user with userID 2 with new name "Princess"
        And response status should be 200

    Scenario: Delete user
      Given I set base URI to reqres
      When I send DELETE request for user with userID 2
      And response status should be 204