Feature:

  Background:
    * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:8080')
    * url urlBase
    * configure report = false

  Scenario: Healthcheck - 200 OK
    Given path '/health'
    When method get
    Then status 200
    And match response == 'UP';

  Scenario: getting all users
    Given path '/users'
    When method get
    Then status 200

  Scenario: creating a user
    * def user =
    """
    {
      name: 'Taylor',
      age: 27, 
      email: 'taylor@mail.com',
    }
    """

    * path '/user'
    * request user
    * method post
    * status 201
    
