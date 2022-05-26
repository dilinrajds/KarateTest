Feature: To test GET by mock service

  Scenario: To test GET by mock service
  
    * def urlPath  = '/api/users/2'
    Given url 'https://reqres.in'
    Given path urlPath
    When method get
    * def response1 = responseStatus == 200 ? { response } : karate.call('callApiFail.feature')
    * print response1

   * def urlPath  = '/apusers/1' 
    Given url 'https://reqres.in'
    Given path urlPath
    When method get
    * def response2 = responseStatus == 200 ? { response } : karate.call('callApiFail.feature')
    * print response2
    
    * def urlPath  = '/apusers/2'
    Given url 'https://reqres.in'
    Given path urlPath
    When method get
    * def response3 = responseStatus == 200 ? { response } : karate.call('callApiFail.feature')
    * print response3