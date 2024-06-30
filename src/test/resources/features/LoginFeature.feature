@Login
Feature: Check user login functionality

Background: Launching the URL
Given User has launched the login URL "https://www.saucedemo.com/v1/"


@Valid @Important
Scenario Outline: User login with valid credentials
 #Given User has launched the login URL "https://www.saucedemo.com/v1/"
 And User has entered credentials
 | username | password |
 | <username> | <password> |
 When User has clicked login button
 Then User lands on "Products" page
 
 Examples:
   | username  |  password  |
   | standard_user | secret_sauce |
   | problem_user | secret_sauce |
 
@Invalid
Scenario: User login with invalid credentials
 #Given User has launched the login URL "https://www.saucedemo.com/v1/"
 And User has entered credentials
 | username | password |
 | standard_user | wrongpassword |
 When User has clicked login button
 Then Error message "Username and password do not match any user in this service" is displayed