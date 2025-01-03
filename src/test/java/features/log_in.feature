Feature: Validating reqres log in endpoint

  Scenario Outline: Successful login with valid credentials
    Given I have valid login credentials with "<email>" and "<password>"
    When I send a POST request to the login endpoint
    Then I should receive a 200 status code
    And Server must return correct "<token>"

    Examples:
      | email              | password   | token             |
      | eve.holt@reqres.in | cityslicka | QpwL5tke4Pnpja7X4 |

  Scenario Outline: Login with invalid credentials
      Given I have invalid login credential with "<email>"
      When I send a POST request to the login endpoint
      Then I should receive a 400 status code
      And Server must return "<errorMsg>"

      Examples:
        | email              | errorMsg |
        | peter@klaven | Missing password |


