@web @regression @homework @darkSky
Feature: Darksky Test

Background:
Given I am on Darksky Home Page

@FA2-304
Scenario: Verify invalid signup error message
  When I click on Dark Sky API link
  And I click on Sign Up link
  And I click on Register button
  Then I verify error message "Please fill out this field"

@FA2-236
Scenario: Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline
  When I created a temperature list from Daily Timeline
  And I got current temperature
  Then I verify current temp is not greater or less then temps from daily timeline

@FA2-220
Scenario: Verify individual day temp timeline
  When I scroll down the page
  And I expand todays timeline
  And I got Todays min and max temperature
  And I got Todays min and max temperature displays
  Then I verify lowest and highest temp is displayed correctly

@FA2-77
Scenario: Verify timeline is displayed in correct format
  When I got hours list from Timeline
  And I check current time and next two hours incremented
  Then I verify timeline is displayed with two hours incremented