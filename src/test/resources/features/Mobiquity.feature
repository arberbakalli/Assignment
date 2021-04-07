@debug
Feature: Mobiquity

  Scenario Outline: Verify user exists
    Given I have access to users table
    When I want to verify if user "<user>" exists
    Then I should validate their credentials are valid
    Examples:
      | user         |
      | Delphine     |
      | random_17632 |

  Scenario: Verify user comments are in the proper format
    Given I have access to users table
    And I want to verify if user "Delphine" exists
    When I filter through his "comments"
    Then I should see them proper formatted

  Scenario: Create a user with valid credentials
    Given I want to create an user with valid credentials
    When I submit in the correct data
    Then I should see the user created successfully

  Scenario: Attempt to create a user with invalid credentials
    Given I attempt to create an user with invalid credentials
    When I submit in the wrong data
    Then I should see the correct error message

  Scenario: Update a user with valid credentials
    Given I want to update an user with valid credentials
    When I submit in the correct updated data
    Then I should see the user updated successfully

  Scenario: Attempt to Update a user with invalid credentials
    Given I attempt to update an user with invalid credentials
    When I submit in the wrong data
    Then I should see the correct error message

  Scenario: Delete a existing user
    Given I want to delete a existing user
    When I submit the delete request
    Then I should see the user deleted successfully

  Scenario Outline: Filter user with nested something
    Given I have access to users table
    And I want to collect data from user "<user>"
    When I filter through his "<filter>"
    Then I should see the users "<filter>"
    Examples:
      | user     | filter   |
      | Delphine | comments |
      | Delphine | photos   |
      | Delphine | albums   |
      | Delphine | todos    |
      | Delphine | posts    |