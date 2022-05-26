Feature: To test GET by mock service

  Scenario: To test GET by mock service
    Given url 'http://localhost:9092/'+ urlPath
    When method get
    Then status 200
