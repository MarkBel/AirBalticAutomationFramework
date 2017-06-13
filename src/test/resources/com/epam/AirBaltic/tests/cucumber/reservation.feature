Feature: Ticket reservation process

    Background:
      Given I am logged in
      When I go to Book A Flight Form
      And I fill Book A Flight Form
      And I go to Flights And Ticket Types Page
      And I go to Passengers Page
      And I go to Travel Extras Page

    @Reservation @Scenario
    Scenario: Get Error If Terms And Conditions Are Not Accepted
      And I go to Summary Page
      And I choose payment method
      Then I click submit and get error message

      @Reservation @Scenario
      Scenario: Number Of Chosen Seats For One Person Should Be One
        Then I choose two seats for one person and see that only one seat can be selected