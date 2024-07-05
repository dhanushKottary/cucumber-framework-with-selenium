@SampleURL
Feature: Launch a sample URL

@parallelUsingJUnit @TestNG @testNGParallel
Scenario: Launch google
  Given User has launched the login URL "https://www.google.com"
  
  
@TestNG @testNGParallel
Scenario: Launch amazon
  Given User has launched the login URL "https://www.amazon.com"  
  
  
@TestNG @testNGParallel
Scenario: Launch browserStack
  Given User has launched the login URL "https://www.browserstack.com"   
  
  
  
@TestNG @testNGParallel
Scenario: Launch linkedin
  Given User has launched the login URL "https://www.linkedin.com"    
  
  

