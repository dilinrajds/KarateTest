Feature: Test SET With Karate Core

  Scenario: 1. Test SET With Karate Core
    * def jsonData =
      """
      {
      "name": "Dilin",
      "age" : "999",
      "city" : "Kerala"
      }
      """
      
     * def jsonData2 =
      """
      {
      "name": "ABC",
      "age" : "999",
      "city" : "Kerala"
      }
      """
    * print jsonData
    
* print response_object.person1[0]

* set response_object.person1[0] = jsonData

* set response_object.person1[1] = jsonData2

* print response_object.person1[0]    
* print response_object.person1[1]
* print response_object
