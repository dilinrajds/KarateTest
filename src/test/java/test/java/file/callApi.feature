Feature: To test GET by mock service

  @first
  Scenario: To test GET by mock service
    * def utils = Java.type('test.java.file.SimpleMockServerTestRunner')
    * def port = new utils().getServerPort();
    * print port
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
    * def response1 = responseStatus == 200 ? { response } : karate.call('callApiFail.feature')
    * print response1
    * def urlPath  = '/apusers/2'
    Given url 'https://reqres.in'
    Given path urlPath
    When method get
    * def response1 = responseStatus == 200 ? { response } : karate.call('callApiFail.feature')
    * print response1
