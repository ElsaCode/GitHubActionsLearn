Feature: Login to Saucedemo

  Scenario: Sign Up with accepted username and password
    Given user on the login page
    When user fill in the username field with "standard_user"
    When user fill in the password field with "secret_sauce"
    And user click on the Login button
    Then browser closes

  Scenario: User enter wrong password
    Given user on the login page
    When user fill in the username field with "standard_user"
    When user enter wrong password with "secret"
    And user click on the Login button
    And user view error message with "Epic sadface: Username and password do not match any user in this service"
    Then browser closes

  Scenario: User enter long username
    Given user on the login page
    When user fill in the username field with "sssssssssssssssssssss"
    When user fill in the password field with "secret_sauce"
    And user click on the Login button
    And user view error message with "Epic sadface: Username and password do not match any user in this service"
    Then browser closes


