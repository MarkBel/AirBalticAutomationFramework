Feature: Ticket price

  @Price @Scenario
  Scenario: Total Price Consists Of Departure Price And Return Price Test
     Given I am logged in
     When I go to Book A Flight Form
     And I fill Book A Flight Form
     And I go to Flights And Ticket Types Page
     And I accept fare
     And I go to Travel Extras Page
     Then I see Summary Price is Counted Correct

  @Price @Scenario
  Scenario: Child Ticket Is 25 Percent Less Than Adult
    Given I go to Book A Flight Form
    When I fill Book A Flight Form
    And I add a child
    And I go to Flights And Ticket Types Page
    Then I see fare condition is observed