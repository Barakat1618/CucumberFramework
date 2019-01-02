Feature: Application Login


Scenario Outline: Home page login with invalid credentials
Given User enters the url "http://www.qaclickacademy.com/"
When The user enters a user name <username> and passowrd <password> and then clicks on submit button
Then The user must not be logged in

Examples:
|username          |password|
|Ali@gmail.com     |sabiya  |
|Sabiya@gmail.com  |ali     |



