@SampleURL
Feature: Launch a sample URL

@parallelUsingJUnit @TestNG @testNGParallel
Scenario: Launch google
  Given User has launched the login URL "https://www.google.com"
  
  
@TestNG @testNGParallel @device_Windows @author_Dhanush
Scenario: Launch amazon
  Given User has launched the login URL "https://www.amazon.com"  
  
  
@TestNG @testNGParallel @device_Windows @author_Dhanush
Scenario: Launch browserStack
  Given User has launched the login URL "https://www.browserstack.com"   
  
  
  
@TestNG @testNGParallel
Scenario: Launch linkedin
  Given User has launched the login URL "https://www.linkedin.com"   
  Then Error message "Username and password do not match any user in this service" is displayed 
  
  

