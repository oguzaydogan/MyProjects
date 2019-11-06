$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("hotels.feature");
formatter.feature({
  "line": 2,
  "name": "Hotels Test",
  "description": "",
  "id": "hotels-test",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@web"
    },
    {
      "line": 1,
      "name": "@hotels"
    }
  ]
});
formatter.before({
  "duration": 4119630896,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am on hotels.com Home Page",
  "keyword": "Given "
});
formatter.match({
  "location": "HotelsSD.setHotelsPage()"
});
formatter.result({
  "duration": 30962023292,
  "status": "passed"
});
formatter.scenario({
  "line": 37,
  "name": "List of all of hotel within 10 miles radius of airport or downtown",
  "description": "",
  "id": "hotels-test;list-of-all-of-hotel-within-10-miles-radius-of-airport-or-downtown",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 36,
      "name": "@FA2-305"
    }
  ]
});
formatter.step({
  "line": 38,
  "name": "I am on default locations search result screen",
  "keyword": "Given "
});
formatter.step({
  "line": 39,
  "name": "I verify system displays all hotels within 10 miles radius of airport",
  "keyword": "Then "
});
formatter.step({
  "line": 40,
  "name": "I verify Hilton Hotel is within radius",
  "keyword": "And "
});
formatter.match({
  "location": "HotelsSD.iAmOnDefaultLocationsSearchResultScreen()"
});
formatter.result({
  "duration": 5343314451,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 43
    }
  ],
  "location": "HotelsSD.iVerifySystemDisplaysAllHotelsWithinMilesRadiusOfAirport(int)"
});
formatter.result({
  "duration": 57715018068,
  "error_message": "java.lang.AssertionError: Out of range expected radius mile expected [true] but found [false]\n\tat org.testng.Assert.fail(Assert.java:93)\n\tat org.testng.Assert.failNotEquals(Assert.java:512)\n\tat org.testng.Assert.assertTrue(Assert.java:41)\n\tat stepdefinition.HotelsSD.iVerifySystemDisplaysAllHotelsWithinMilesRadiusOfAirport(HotelsSD.java:163)\n\tat ✽.Then I verify system displays all hotels within 10 miles radius of airport(hotels.feature:39)\n",
  "status": "failed"
});
formatter.match({
  "location": "HotelsSD.iVerifyHiltonHotelIsWithinRadius()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 254616724,
  "status": "passed"
});
});