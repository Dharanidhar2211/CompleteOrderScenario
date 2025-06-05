
@tag
Feature: ErrorValidation
  I want to use this template for my feature file

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce page
    When Logged in with valid username<email> and password <password>
    Then "Incorrect email or password." message is  Displayed 

    Examples: 
      | email 									 | password 							|
      | dharanidhar220@gmail.com |     Ilovecricket@123		|
      
