Feature: Login into the Application

Scenario Outline: Positive path for Login functionality
Given Initialize a browser with Chrome
And Navigate to the "https://qaclickacademy.com/"
And Wait for a popup to be visible and click on the No thanx button and navigate to the Login page
When A user enters a <username> and a <password> and clicks on the login button
Then Verify that a user is on the page with an expected h1 headline
And Close the browser

Examples:
|username								|password							|
|private@spotter.com		|passwordPrivate			|
|enterprise@spotter.com	|passwordEnterprise		|
