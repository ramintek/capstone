@test2
Feature: This feature is use for testing UI of Retail page

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'ramin@gmail.com' and password 'Tek@123456'
    And User click on login button
    And User should be logged into the Account

  @searchProduct
  Scenario: Verify user can search a product
    Given User is on retail website
    When User search for "pokemon" product
    Then The product should be displayed

  @verifyShop
  Scenario: Verify Shop by Department sidebar
    Given User is on retail website
    When User click on All section
    Then below options are present in shop by department sidebar
      | Electronics | Computers | Smart Home | Sports | Automative |

  @verifyDept
  Scenario Outline: Verify Department sidebar options
    Given User is on retail website
    When User click on All section
    And User on '<department>'
    Then below options are present in department
      | <optionOne> | <optionTwo> |

    Examples: 
      | department  | optionOne                      | optionTwo                |
      | Electronics | TV & Video                     | Video Games              |
      | Computers   | Accessories                    | Networking               |
      | Smart Home  | Smart Home Lightning           | Plugs and Outlets        |
      | Sports      | Athletic Clothing              | Exercise & Fitness       |
      | Automative  | Automative Parts & Accessories | MotorCycle & Powersports |

  @addToCart
  Scenario: Verify User can add an item to cart
    And User change the category to 'Smart Home'
    And User search for an item 'Kasa outdoor smart plug'
    And User click on Search icon
    And User click on item
    And User select quantity '2'
    And User click add to Cart button
    Then the cart icon quantity should change to '2'

  @placeOrder
  Scenario: Verify User can place an order without Shipping address and payment Method on file
    And User change the category to 'Smart Home'
    And User search for an item 'kasa outdoor smart plug'
    And User click on Search icon
    And User click on item
    And User select quantity '2'
    And User click add to Cart button
    Then the cart icon quantity should change to '2'
    And User click on Cart option
    And User click on Proceed to Checkout button
    And User clicks Add a new address link for shipping address
    And User fills new address form with below information
      | country | fullName | PhoneNumber | StreetAddress | apt | city | state | zipCode |
    ##   And User click Add Your Address button
    And User click Add a credit card or Debit Card for Payment method
    And User fills Debit or credit card information
      | cardNumber | nameOnCard | expirationMonth | expirationYear | securityCode |
      |            |            |               5 |           2025 |          525 |
    ## And User click on Add your card button
    And User click on Place Your Order
    Then order message should be displayed 'Order Placed, Thanks'

  @placeOrderWith
  Scenario: Verify User can place an order with Shipping address and payment Method on file
    And User changes category to 'Electronics'
    And User search for an item 'Apex Legends'
    And User click on Search icon
    And User click on item
    And User select quantity '5'
    And User click add to Cart button
    Then the cart icon quantity should change to '5'
    And User click on Cart option
    And User click on Proceed to Checkout button
    And User click on Place Your Order
    Then order message should be displayed 'Order Placed, Thanks'
