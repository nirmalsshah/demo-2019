$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Hotels.feature");
formatter.feature({
  "line": 2,
  "name": "Testing Hotels.com features",
  "description": "",
  "id": "testing-hotels.com-features",
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
      "name": "@Hotels"
    }
  ]
});
formatter.scenarioOutline({
  "line": 9,
  "name": "Verify user can only view the result by selected property class",
  "description": "",
  "id": "testing-hotels.com-features;verify-user-can-only-view-the-result-by-selected-property-class",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 7,
      "name": "@Hotels-1"
    }
  ]
});
formatter.step({
  "line": 11,
  "name": "I select property class \u003cstars\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I verify system displays only \u003cstars\u003e hotels on search result",
  "keyword": "Then "
});
formatter.examples({
  "line": 14,
  "name": "",
  "description": "",
  "id": "testing-hotels.com-features;verify-user-can-only-view-the-result-by-selected-property-class;",
  "rows": [
    {
      "cells": [
        "stars"
      ],
      "line": 15,
      "id": "testing-hotels.com-features;verify-user-can-only-view-the-result-by-selected-property-class;;1"
    },
    {
      "comments": [
        {
          "line": 16,
          "value": "#      | 5 stars |"
        },
        {
          "line": 17,
          "value": "#      | 4 stars |"
        }
      ],
      "cells": [
        "3 stars"
      ],
      "line": 18,
      "id": "testing-hotels.com-features;verify-user-can-only-view-the-result-by-selected-property-class;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 11894906828,
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
  "name": "I am on default locations search result screen",
  "keyword": "Given "
});
formatter.match({
  "location": "HotelsSD.iAmOnDefaultLocationsPage()"
});
formatter.result({
  "duration": 2072533345,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 16,
      "value": "#      | 5 stars |"
    },
    {
      "line": 17,
      "value": "#      | 4 stars |"
    }
  ],
  "line": 18,
  "name": "Verify user can only view the result by selected property class",
  "description": "",
  "id": "testing-hotels.com-features;verify-user-can-only-view-the-result-by-selected-property-class;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@Hotels"
    },
    {
      "line": 1,
      "name": "@regression"
    },
    {
      "line": 1,
      "name": "@web"
    },
    {
      "line": 7,
      "name": "@Hotels-1"
    }
  ]
});
formatter.step({
  "line": 11,
  "name": "I select property class 3 stars",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I verify system displays only 3 stars hotels on search result",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "3 stars",
      "offset": 24
    }
  ],
  "location": "HotelsSD.selectHotelStar(String)"
});
formatter.result({
  "duration": 4603625256,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3 stars",
      "offset": 30
    }
  ],
  "location": "HotelsSD.checkingOnlySelectedStarHotelIsDisplayed(String)"
});
formatter.result({
  "duration": 659899406632,
  "status": "passed"
});
formatter.after({
  "duration": 385883989,
  "status": "passed"
});
});