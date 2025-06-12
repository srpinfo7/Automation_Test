@tag
Feature: Error Validation
 
  @Errorvalidation
  Scenario Outline: Login Error validation
    Given Landed to Loginpage
    When  Login to application using <name> and <password>
    Then "Incorrect email or password." message appeared.

    Examples: 
   		| name  					 | password  |
      | sameer@gmail.com | Sameer@12 |
      | samer@gmail.com  | Sameer@123|