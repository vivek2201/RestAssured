Feature: validating Place APIs
@AddPlaceAPI
  Scenario Outline: Verify if place is added successfully added using AddPlaceAPI
    Given Add Place Payload "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" with "POST" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place_Id created  maps to "<name>" using "GetPlaceAPI"
    Examples:
    |name|language|address|
    |Frontline house|French-IN|29, side layout, cohen 09|
   # |Priya|English|Melbourne|
   
   @DeletePlaceAPI
   Scenario: if Delete Place functionality is working fine
   Given DeletePlace Payload
   When user calls "DeletePlaceAPI" with "POST" http request
   Then the API call got success with status code 200
    And "status" in response body is "OK"
   
   