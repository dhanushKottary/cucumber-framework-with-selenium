Feature: Check add to cart functionality

@DependencyInjection
Scenario Outline: User is able to add and remove item from cart
 Given User has launched the login URL "https://www.saucedemo.com/v1/"
 And User has entered credentials
 | username | password |
 | <username> | <password> |
 And User has clicked login button
 When User added "Sauce Labs Backpack" item to cart
 Then User removed item from the cart
 Then Verify the item is removed from the cart
 
 Examples:
   | username  |  password  |
   | standard_user | secret_sauce |
 