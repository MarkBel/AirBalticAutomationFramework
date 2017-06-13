Feature: Account updating

  @Account @Scenario
  Scenario: Update account on the Profile Page
    Given I am logged in
    When I go to Edit Profile Page
    And I update surname
    Then I get Error Message



