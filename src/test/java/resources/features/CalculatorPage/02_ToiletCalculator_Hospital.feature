Feature: Calculator for toilet pans, basins and urinals Functionality Feature
  In order to determine how many toilet pans, basins and urinals to include in a building for given use,
  I want to run the cucumber test to verify Toilet calculator is working
  @execute
  Scenario: Toilet calculator when occupancy is not known functionality
    Given user navigates to toilet calculator
    And user do not know building occupancy
    And user knows building use is for "Hospital"
    When user enters the space details to calculate occupant densities
      | Dining, beverage and cafeteria spaces   	          | 250   |
      | Interview rooms 			                          | 150   |
      | Kitchens					                          | 50    |
      | Laundry and house keeping facilities		          | 50    |
      | Lobbies and foyers				                      | 300   |
      | Offices and staffrooms      		                  | 200   |
      | Personal service facilities 		                  | 50    |
      | Reception areas 			                          | 50    |
      | Toilets and subordinate spaces (no occupants counted) | 200   |
      | Beds						                          | 100   |
    Then number of toilet facilities should be calculated
    And one or more options to recommend should be displayed