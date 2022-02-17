Feature: Calculator for toilet pans, basins and urinals Functionality Feature
  In order to determine how many toilet pans, basins and urinals to include in a building for given use and number of people,
  I want to verify Toilet calculator is working

  Scenario Outline: Toilet calculator when occupancy is known functionality
    Given user navigates to Toilet calculator
    When user knows building <building_occupancy>
    And user knows building <building_use>
    Then number of toilet facilities should be calculated
    And one or more options to recommend should be displayed
    Examples:
      | building_occupancy | building_use |
      | 100                | Museum       |
