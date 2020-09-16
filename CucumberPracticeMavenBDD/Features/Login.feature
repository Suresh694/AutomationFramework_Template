Feature: Login

Scenario: Successful Login with Valid Credentials
	Given User Launch Chrome Browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User Enters Email as "admin@yourstore.com" and password as "admin"
	And User Clicks on Login
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User clicks on Logout link
	Then Page Title should be "Your store. Login"
	And close Browser
	
Scenario Outline: Login Data Driven
	Given User Launch Chrome Browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User Enters Email as "<email>" and password as "<password>"
	And User Clicks on Login
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User clicks on Logout link
	Then Page Title should be "Your store. Login"
	And close Browser
	
	Examples:
		|email | password |
		|admin@yourstore.com | admin |
		|admin@yourstore.com|notadmin|
	