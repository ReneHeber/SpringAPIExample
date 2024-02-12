Feature:

  Background:
    * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:8080')
    * url urlBase

  Scenario: Healthcheck - 200 OK
    Given path '/health'
    When method get
    Then status 200
    And match response == 'UP';