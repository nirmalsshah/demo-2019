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
  "duration": 4202664100,
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
  "duration": 464536257,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Verify invalid signup error message",
  "description": "",
  "id": "testing-darksky-features;verify-invalid-signup-error-message",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@darksky-1"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "I am on the darksky Register page",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "I click on Register button",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I verify error message \"please fill out this field\"",
  "keyword": "Then "
});
formatter.match({
  "location": "darkskySD.verifyIamOnDarkSkyPage()"
});
formatter.result({
  "duration": 641931030,
  "status": "passed"
});
formatter.match({
  "location": "darkskySD.IClickOnRegisterButton()"
});
formatter.result({
  "duration": 72381405,
  "status": "passed"
});
formatter.match({
  "location": "darkskySD.IVerifyErrorMessage()"
});
formatter.result({
  "duration": 9522330,
  "status": "passed"
});
formatter.after({
  "duration": 168223172,
  "status": "passed"
});
});