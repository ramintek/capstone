@test4
Feature: Retail Application Account Feature

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'ramin@gmail.com' and password 'Tek@1234567'
    And User click on login button
    And User should be logged into the Account

  @updateProfile
  Scenario: Verify User can update Profile Information
    When User click on Account option
    And User update Name and Phone
      | fullName | PhoneNumber |
    And User click on Update button
    Then User profile information should be updated

  #@updateProfile
  #Scenario: Verify User can update Profile Information
  #  When User click on Account option
  #  And User update Name 'Transformers' and Phone '99999999999'
  #  And User click on Update button
  # Then User profile information should be updated
  ## @updatePassword
  # Scenario: Verify User can Update password
  #  When User click on Account option
  # And User enter below information
  #    | previousPassword | newPassword | confirmPassword |
  #   | Tek@123456      | Tek@1234567  | Tek@1234567      |
  #   And User click on Change Password button
  #  Then another message should be displayed 'Password Updated Successfully'
  @addAddress
  Scenario: Verify User can add  an Address
    When User click on Account option
    And User click on  Add address option
    And User fill new address form with below information
      | country | fullName | PhoneNumber | StreetAddress | apt | city | state | zipCode |
    And User click Add Your Address button
    Then a message should be displayed for added address 'Address Added Successfully'

  @addPayment
  Scenario: Verify User can add a payment method
    When User click on Account option
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber | nameOnCard | expirationMonth | expirationYear | securityCode |
      |            | John Smith |               7 |           2027 |          369 |
    And User click on Add your card button
    Then A message should be displayed for added payment 'Payment Method added sucessfully'

  @addCreditCard
  Scenario: Verify User can edit Debit or Credit card
    When User click on Account option
    And User click on Edit option of card section
    And user edit information with below data
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 5555555555555555 | John Smith |               8 |           2029 |          999 |
    And user click on Update Your Card button
    Then a message should be displayed for payment update 'Payment Method updated Successfully'

  @remoteCreditCard
  Scenario: Verify User can remove Debit or Credit card
    When User click on Account option
    And User click on remove option of card section
    Then payment details should be removed

  @editAddress
  Scenario: Verify User can edit an Address added on account
    When User click on Account option
    And User click on edit address option
    And user fill new address form with below information
      | country | fullName | PhoneNumber | StreetAddress | apt | city | state | zipCode |
    And User click update Your Address button
    Then a message should be displayed 'Address Updated Successfully'

  @updatePassword
  Scenario: Verify User can Update password
    When User click on Account option
    And User enter below information
      | previousPassword | newPassword | confirmPassword |
      | Tek@1234567       | Tek@123456 | Tek@123456     |
    And User click on Change Password button
    Then another message should be displayed 'Password Updated Successfully'
