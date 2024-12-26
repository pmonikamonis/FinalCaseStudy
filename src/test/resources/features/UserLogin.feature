Feature: Conduit CRUD Functions 
 
Scenario:  Login into App 
Given User is on Login page 
When User provide "pmonikamonis@gmail.com" and "Moni0809" 
Then User should be on Home Page 

Scenario: Create new Article 
Given User should be on New Article Page 
When User enters Article details 
 | title | Desc | Content | tag | 
 | Selenium-7 | Handson | Test | Automation |
Then Article must be created 

Scenario: View Article 
Given User should be on Global Feed page
When User select an article "Selenium-7" 
#Then Article detail page must be displayed 
Then Article detail page should be displayed

Scenario: Update an Article 
Given Article detail page must be displayed
When User update article detail 
Then Article detail must be updated 

Scenario: Delete an Article 
Given Article detail page must be displayed
When User delete article  
Then Article must be deleted 