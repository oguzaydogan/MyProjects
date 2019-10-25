$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("darksky.feature");
formatter.feature({
  "line": 2,
  "name": "Darksky Test",
  "description": "",
  "id": "darksky-test",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@web"
    },
    {
      "line": 1,
      "name": "@regression"
    },
    {
      "line": 1,
      "name": "@homework"
    },
    {
      "line": 1,
      "name": "@darkSky"
    }
  ]
});
formatter.before({
  "duration": 3414651001,
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
  "name": "I am on Darksky Home Page",
  "keyword": "Given "
});
formatter.match({
  "location": "DarkSkySD.setDarkSkyPage()"
});
formatter.result({
  "duration": 490144771,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Verify invalid signup error message",
  "description": "",
  "id": "darksky-test;verify-invalid-signup-error-message",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@FA2-304"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I click on Dark Sky API link",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I click on Sign Up link",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I click on Register button",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I verify error message \"Please fill out this field\"",
  "keyword": "Then "
});
formatter.match({
  "location": "DarkSkySD.iClickOnDarkSkyAPILink()"
});
formatter.result({
  "duration": 260225447,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.iClickOnSignUpLink()"
});
formatter.result({
  "duration": 167240754,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.iClickOnRegisterButton()"
});
formatter.result({
  "duration": 70432446,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Please fill out this field",
      "offset": 24
    }
  ],
  "location": "DarkSkySD.iVerifyErrorMessage(String)"
});
formatter.result({
  "duration": 66779478,
  "status": "passed"
});
formatter.after({
  "duration": 119593913,
  "status": "passed"
});
formatter.before({
  "duration": 1424414424,
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
  "name": "I am on Darksky Home Page",
  "keyword": "Given "
});
formatter.match({
  "location": "DarkSkySD.setDarkSkyPage()"
});
formatter.result({
  "duration": 84021158,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline",
  "description": "",
  "id": "darksky-test;verify-current-temperature-should-not-be-greater-or-less-than-the-temperature-from-daily-timeline",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 14,
      "name": "@FA2-236"
    }
  ]
});
formatter.step({
  "line": 16,
  "name": "I created a temperature list from Daily Timeline",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "I got current temperature",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I verify current temp is not greater or less then temps from daily timeline",
  "keyword": "Then "
});
formatter.match({
  "location": "DarkSkySD.iCreateDailyTempList()"
});
formatter.result({
  "duration": 469227311,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.iGetCurrentTemp()"
});
formatter.result({
  "duration": 30833038,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.iVerifyCurrentTempFromDailyTl()"
});
formatter.result({
  "duration": 97542,
  "status": "passed"
});
formatter.after({
  "duration": 127795737,
  "status": "passed"
});
formatter.before({
  "duration": 2072446070,
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
  "name": "I am on Darksky Home Page",
  "keyword": "Given "
});
formatter.match({
  "location": "DarkSkySD.setDarkSkyPage()"
});
formatter.result({
  "duration": 14757955,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Verify individual day temp timeline",
  "description": "",
  "id": "darksky-test;verify-individual-day-temp-timeline",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 20,
      "name": "@FA2-220"
    }
  ]
});
formatter.step({
  "line": 22,
  "name": "I scroll down the page",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "I expand todays timeline",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "I got Todays min and max temperature",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "I got Todays min and max temperature displays",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "I verify lowest and highest temp is displayed correctly",
  "keyword": "Then "
});
formatter.match({
  "location": "DarkSkySD.iScrollDownThePage()"
});
formatter.result({
  "duration": 7645446,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.iExpandTodaysTimeline()"
});
formatter.result({
  "duration": 543534613,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.iGotTodaysMinAndMaxTemperature()"
});
formatter.result({
  "duration": 56208976,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.iGotTodaysMinAndMaxTemperatureDisplays()"
});
formatter.result({
  "duration": 126335583,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.iVerifyLowestAndHighestTempIsDisplayedCorrectly()"
});
formatter.result({
  "duration": 74401,
  "status": "passed"
});
formatter.after({
  "duration": 109030120,
  "status": "passed"
});
formatter.before({
  "duration": 2002190237,
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
  "name": "I am on Darksky Home Page",
  "keyword": "Given "
});
formatter.match({
  "location": "DarkSkySD.setDarkSkyPage()"
});
formatter.result({
  "duration": 14015315,
  "status": "passed"
});
formatter.scenario({
  "line": 29,
  "name": "Verify timeline is displayed in correct format",
  "description": "",
  "id": "darksky-test;verify-timeline-is-displayed-in-correct-format",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 28,
      "name": "@FA2-77"
    }
  ]
});
formatter.step({
  "line": 30,
  "name": "I got hours list from Timeline",
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "I check current time and next two hours incremented",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "I verify timeline is displayed with two hours incremented",
  "keyword": "Then "
});
formatter.match({
  "location": "DarkSkySD.iGotHoursListFromTimeline()"
});
formatter.result({
  "duration": 464404985,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.iCheckCurrentTimeAndNextTwoHoursIncremented()"
});
formatter.result({
  "duration": 11582734,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.iVerifyTimelineIsDisplayedWithTwoHoursIncremented()"
});
formatter.result({
  "duration": 97465,
  "status": "passed"
});
formatter.after({
  "duration": 105250301,
  "status": "passed"
});
});