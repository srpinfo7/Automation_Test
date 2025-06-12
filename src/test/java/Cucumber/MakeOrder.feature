#Author: Sameer Ranjan Panda

@tag
Feature: Order an item from ecommerce site

Background:
Given Landed to Loginpage


  @Regression
  Scenario Outline: Positive test for making order
    Given Login to application using <name> and <password>
    When add the <product> to the cart
    And Order the <product> and Checkout the country India
    Then "THANKYOU FOR THE ORDER." confirmation message verify.

    Examples: 
      | name  					 | password  | product  					|
      | sameer@gmail.com | Sameer@123| zara coat 3 				|
      | sameer@gmail.com | Sameer@123| ADIDAS ORIGINAL    |
