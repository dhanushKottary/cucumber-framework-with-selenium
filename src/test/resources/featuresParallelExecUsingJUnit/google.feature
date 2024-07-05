@SampleURL
Feature: Launch a sample URL

@parallelUsingJUnit @TestNG
Scenario: Launch google
  Given User has launched the login URL "https://www.google.com"
  
  
@TestNG
Scenario: Launch amazon
  Given User has launched the login URL "https://www.amazon.com"  

