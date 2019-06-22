@web @regression @darksky
Feature: Testing Darksky Features

  Background:
    Given I am on Darksky Home Page

    @darksky-1

    Scenario: Verify invalid signup error message
      Given I am on the darksky Register page
      When I click on Register button
      Then I verify error message "please fill out this field"


    @darksky-2

    Scenario: Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline

      Then I verify current temp is not greater or less then temps from daily timeline


    @darksky-3

    Scenario: Verify individual day temp timeline

      When I expand today's timeline
      Then I verify lowest and highest temp is displayed correctly


    @darksky-4

    Scenario: Verify timline is displayed in correct format
      Then I verify timeline is displayed with 2 hours incremented for NewYork with 12 values
