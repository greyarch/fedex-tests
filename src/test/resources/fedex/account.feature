Feature: Login

    Scenario: Verify log in menu
        Given user is on the Home Page
        When user tries to log in
        Then user gets to the Account Page