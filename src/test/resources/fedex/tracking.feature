Feature: Tracking

    Scenario: With missing tracking ID
        Given user is on the Home Page
        When display tracking with ID no-such-tracking-id
        Then tracking error is displayed