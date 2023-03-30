@test1
Feature: TEK Retail Application SignIn feature

  Background: 
    Given User is on retail website
    When User click on Sign in option

  Scenario: Verify user can sign in into Retail Application
    And User enter email 'ramin@gmail.com' and password 'Tek@123456'
    And User click on login button
    Then User should be logged into the Account

  # @signInMultiply
  #Scenario Outline: Verify user can sign in into Retail Application
  #  And User enter email '<email>' and password '<password>'
  #  And User click on login button
  #  Then User should be logged into Account
  # Examples:
  #  | email               | password   |
  # | raminqas@gmail.com  | Tek@123456 |
  #| raminqass@gmail.com | Tek@123456 |
  Scenario: Verify user can create an acount into Retail Website
    And User click on Create New Account button
    And User fill the signUp information with below data
      | fullName | email | password   | confirmPassword |
      |          |       | Tek@123456 | Tek@123456      |
    And User click on SignUp button
    Then User should be logged into the Account
