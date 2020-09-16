Feature: Customers

Scenario: Add a new Customer
	Given User Launch Chrome Browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User Enters Email as "admin@yourstore.com" and password as "admin"
	And User Clicks on Login
	Then User can view Dashboard
	When User clicks on Customers Menu
	And clicks on customers Menuitem
	And clicks on Add New button
	Then User can view Add new Customer Page
	When User enter customer info
	And clicks on Save Button
	Then User can view confirmation message "The new customer has been added successfully."
	And close Browser
	
Scenario: Search Customer By EmailID
	Given User Launch Chrome Browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User Enters Email as "admin@yourstore.com" and password as "admin"
	And User Clicks on Login
	Then User can view Dashboard
	When User clicks on Customers Menu
	And clicks on customers Menuitem
	And Enter Customer Email
	When Click on search Button
	Then User should find Email in the SearchTable
	And close Browser