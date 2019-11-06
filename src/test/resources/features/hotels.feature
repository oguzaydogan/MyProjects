@web @hotels
Feature: Hotels Test

  Background:
    Given I am on hotels.com Home Page

  @FA2-311
  Scenario Outline: Verify room count dropdown
    Then I select <select_rooms> from room dropdown
    And I verify <number_of_room_dropdown> is displayed

    Examples:
      |select_rooms | number_of_room_dropdown |
      |1            | 1                       |
      |2            | 2                       |
      |3            | 3                       |
      |4            | 4                       |
      |5            | 5                       |
      |6            | 6                       |
      |7            | 7                       |
      |8            | 8                       |
      |9+           | 0                       |

  @FA2-303
  Scenario Outline: Verify user can only view the result by selected property class
    Given I am on default locations search result screen
    When I select property class <stars>
    Then I verify system displays only <stars> hotels on search result

    Examples:
      | stars   |
      | 5 stars |
      | 4 stars |
      | 3 stars |

  @FA2-305
  Scenario: List of all of hotel within 10 miles radius of airport or downtown
    Given I am on default locations search result screen
    Then I verify system displays all hotels within 10 miles radius of airport
    And I verify Hilton Hotel is within radius

  @FA2-312
  Scenario: Verify todays deal price value
    Given I am on default locations search result screen
    Then I verify todays deal is less than $200
