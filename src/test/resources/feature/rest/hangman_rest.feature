Feature: Hangman REST
  As an API user I want to start a hangman instance

  Scenario: Starting Hangman
    When I call start endpoint
    Then the response is ...