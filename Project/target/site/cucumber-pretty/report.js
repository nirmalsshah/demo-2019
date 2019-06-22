$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("darksky.feature");
formatter.feature({
  "line": 2,
  "name": "Testing Darksky Features",
  "description": "",
  "id": "testing-darksky-features",
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
      "name": "@darksky"
    }
  ]
});
formatter.before({
  "duration": 8839843751,
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
  "location": "darkskySD.iAmOnDarkSkyPage()"
});
formatter.result({
  "duration": 578845286,
  "status": "passed"
});
formatter.scenario({
  "line": 32,
  "name": "Verify timline is displayed in correct format",
  "description": "",
  "id": "testing-darksky-features;verify-timline-is-displayed-in-correct-format",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 30,
      "name": "@darksky-4"
    }
  ]
});
formatter.step({
  "line": 35,
  "name": "I verify timeline is displayed with two hours incremented for LosAngeles",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "LosAngeles",
      "offset": 62
    }
  ],
  "location": "darkskySD.verifyTwoHourIncrement(String)"
});
formatter.result({
  "duration": 2583015065,
  "status": "passed"
});
formatter.after({
  "duration": 185170454,
  "status": "passed"
});
});