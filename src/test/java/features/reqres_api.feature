Feature: Test Reqres api with rest assured

  @SmokeTest
  Scenario Outline: Reqres GET API test
    Given The valid endpoint to fetch users
    When The request is send to server with page numbers as "<page>"
    Then The first user record has email as "<email>"

    Examples:
    | page | email|
    | 2    |  michael.lawson@reqres.in |
    | 1    | george.bluth@reqres.in    |


    @SmokeTest
    Scenario Outline: Reqres POST API test
      Given The valid endpoint with payload to create user
      When The request is send to the server
      Then The new user must be created with name as "<username>"

      Examples:
      | username |
      | effy |