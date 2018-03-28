$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Gui/GUI_PicCheck.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: your.email@your.domain.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 20,
  "name": "Verify whether the pictures can be shown in GUI",
  "description": "",
  "id": "verify-whether-the-pictures-can-be-shown-in-gui",
  "keyword": "Feature",
  "tags": [
    {
      "line": 19,
      "name": "@gui"
    }
  ]
});
formatter.scenarioOutline({
  "line": 23,
  "name": "To Verify whether the pictures and floor plans can be shown in GUI",
  "description": "",
  "id": "verify-whether-the-pictures-can-be-shown-in-gui;to-verify-whether-the-pictures-and-floor-plans-can-be-shown-in-gui",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 22,
      "name": "@gui"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "I login \u003cenv\u003e by \u003cusr\u003e and \u003cpsw\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "I navigate to \u003ctgtPage\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "I wait for \"2\" seconds",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 27,
      "value": "#And I search \u003cissueId\u003e in the issue list"
    },
    {
      "line": 28,
      "value": "#And I open the details of issue \u003cissueId\u003e"
    },
    {
      "line": 29,
      "value": "#And I wait for \"1\" seconds"
    },
    {
      "line": 30,
      "value": "#When I click the floor plan for the issue"
    },
    {
      "line": 31,
      "value": "#And I wait for \"1\" seconds"
    },
    {
      "line": 32,
      "value": "#Then Capture the current page and save it as \u003cfileName1\u003e"
    },
    {
      "line": 33,
      "value": "#Then I verify the floorplan can be shown"
    },
    {
      "line": 34,
      "value": "#And I close the pop up window"
    },
    {
      "line": 35,
      "value": "#And I wait for \"1\" seconds"
    },
    {
      "line": 36,
      "value": "#When I click the picture for the issue"
    },
    {
      "line": 37,
      "value": "#And I wait for \"1\" seconds"
    },
    {
      "line": 38,
      "value": "#Then Capture the current page and save it as \u003cfileName2\u003e"
    },
    {
      "line": 39,
      "value": "#Then I vefity the picture can be shown"
    },
    {
      "line": 40,
      "value": "#And I close the pop up picture"
    }
  ],
  "line": 41,
  "name": "I search \u003cissueId\u003e verify whether floor plan and desc pic can be shown in issue content and capture the screen shots as \u003cfileName1\u003e and \u003cfileName2\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 42,
  "name": "I wait for \"1\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 43,
  "name": "I logout the system for \u003cenv\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "Quit the driver",
  "keyword": "And "
});
formatter.examples({
  "line": 46,
  "name": "",
  "description": "",
  "id": "verify-whether-the-pictures-can-be-shown-in-gui;to-verify-whether-the-pictures-and-floor-plans-can-be-shown-in-gui;",
  "rows": [
    {
      "cells": [
        "testCase",
        "env",
        "usr",
        "psw",
        "tgtPage",
        "issueId",
        "fileName1",
        "fileName2"
      ],
      "line": 47,
      "id": "verify-whether-the-pictures-can-be-shown-in-gui;to-verify-whether-the-pictures-and-floor-plans-can-be-shown-in-gui;;1"
    },
    {
      "cells": [
        "\"guiPicVer_001\"",
        "\"prod\"",
        "\"kentestgrp10\"",
        "\"12345678\"",
        "\"生产工程检查问题列表\"",
        "\"723783;737122;723918;734938;726353;723919;735878;737121;723921;737113\"",
        "\"prodGuiPicVer_001_01_issueId\"",
        "\"prodGuiPicVer_001_02_issueId\""
      ],
      "line": 48,
      "id": "verify-whether-the-pictures-can-be-shown-in-gui;to-verify-whether-the-pictures-and-floor-plans-can-be-shown-in-gui;;2"
    },
    {
      "cells": [
        "\"guiPicVer_002\"",
        "\"longhu\"",
        "\"longhu\"",
        "\"longhu2018\"",
        "\"龙湖工程检查问题列表\"",
        "\"800706;35;247;256;989;987;771864;771847;767479;767484\"",
        "\"lhGuiPicVer_002_01_issueId\"",
        "\"lhGuiPicVer_002_02_issueId\""
      ],
      "line": 49,
      "id": "verify-whether-the-pictures-can-be-shown-in-gui;to-verify-whether-the-pictures-and-floor-plans-can-be-shown-in-gui;;3"
    },
    {
      "cells": [
        "\"guiPicVer_003\"",
        "\"gzb\"",
        "\"gzb\"",
        "\"gzb@2018\"",
        "\"葛洲坝问题列表\"",
        "\"1055;809;27;32;74;71;123;163;426;439\"",
        "\"gzbGuiPicVer_003_01_issueId\"",
        "\"gzbGuiPicVer_003_02_issueId\""
      ],
      "line": 50,
      "id": "verify-whether-the-pictures-can-be-shown-in-gui;to-verify-whether-the-pictures-and-floor-plans-can-be-shown-in-gui;;4"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 255750,
  "status": "passed"
});
formatter.scenario({
  "line": 48,
  "name": "To Verify whether the pictures and floor plans can be shown in GUI",
  "description": "",
  "id": "verify-whether-the-pictures-can-be-shown-in-gui;to-verify-whether-the-pictures-and-floor-plans-can-be-shown-in-gui;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 19,
      "name": "@gui"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "I login \"prod\" by \"kentestgrp10\" and \"12345678\"",
  "matchedColumns": [
    1,
    2,
    3
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "I navigate to \"生产工程检查问题列表\"",
  "matchedColumns": [
    4
  ],
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "I wait for \"2\" seconds",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 27,
      "value": "#And I search \u003cissueId\u003e in the issue list"
    },
    {
      "line": 28,
      "value": "#And I open the details of issue \u003cissueId\u003e"
    },
    {
      "line": 29,
      "value": "#And I wait for \"1\" seconds"
    },
    {
      "line": 30,
      "value": "#When I click the floor plan for the issue"
    },
    {
      "line": 31,
      "value": "#And I wait for \"1\" seconds"
    },
    {
      "line": 32,
      "value": "#Then Capture the current page and save it as \u003cfileName1\u003e"
    },
    {
      "line": 33,
      "value": "#Then I verify the floorplan can be shown"
    },
    {
      "line": 34,
      "value": "#And I close the pop up window"
    },
    {
      "line": 35,
      "value": "#And I wait for \"1\" seconds"
    },
    {
      "line": 36,
      "value": "#When I click the picture for the issue"
    },
    {
      "line": 37,
      "value": "#And I wait for \"1\" seconds"
    },
    {
      "line": 38,
      "value": "#Then Capture the current page and save it as \u003cfileName2\u003e"
    },
    {
      "line": 39,
      "value": "#Then I vefity the picture can be shown"
    },
    {
      "line": 40,
      "value": "#And I close the pop up picture"
    }
  ],
  "line": 41,
  "name": "I search \"723783;737122;723918;734938;726353;723919;735878;737121;723921;737113\" verify whether floor plan and desc pic can be shown in issue content and capture the screen shots as \"prodGuiPicVer_001_01_issueId\" and \"prodGuiPicVer_001_02_issueId\"",
  "matchedColumns": [
    5,
    6,
    7
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 42,
  "name": "I wait for \"1\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 43,
  "name": "I logout the system for \"prod\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "Quit the driver",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "prod",
      "offset": 9
    },
    {
      "val": "kentestgrp10",
      "offset": 19
    },
    {
      "val": "12345678",
      "offset": 38
    }
  ],
  "location": "PageOperations.i_login_by_and(String,String,String)"
});
formatter.result({
  "duration": 5514230436,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "生产工程检查问题列表",
      "offset": 15
    }
  ],
  "location": "PageOperations.i_navigate_to_of(String)"
});
formatter.result({
  "duration": 1086170799,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 12
    }
  ],
  "location": "ShareSteps.i_wait_for_seconds(String)"
});
formatter.result({
  "duration": 2000956906,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "723783;737122;723918;734938;726353;723919;735878;737121;723921;737113",
      "offset": 10
    },
    {
      "val": "prodGuiPicVer_001_01_issueId",
      "offset": 183
    },
    {
      "val": "prodGuiPicVer_001_02_issueId",
      "offset": 218
    }
  ],
  "location": "PageOperations.i_search_verify_whether_floor_plan_and_desc_pic_can_be_shown_in_issue_content_and_capture_the_screen_shots_as_and(String,String,String)"
});
formatter.result({
  "duration": 102600825296,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 12
    }
  ],
  "location": "ShareSteps.i_wait_for_seconds(String)"
});
formatter.result({
  "duration": 1000642863,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prod",
      "offset": 25
    }
  ],
  "location": "PageOperations.i_logout_the_system_for(String)"
});
formatter.result({
  "duration": 3243426454,
  "status": "passed"
});
formatter.match({
  "location": "PageOperations.quit_the_driver()"
});
formatter.result({
  "duration": 98724700,
  "status": "passed"
});
formatter.after({
  "duration": 126438,
  "status": "passed"
});
formatter.before({
  "duration": 55009,
  "status": "passed"
});
formatter.scenario({
  "line": 49,
  "name": "To Verify whether the pictures and floor plans can be shown in GUI",
  "description": "",
  "id": "verify-whether-the-pictures-can-be-shown-in-gui;to-verify-whether-the-pictures-and-floor-plans-can-be-shown-in-gui;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 19,
      "name": "@gui"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "I login \"longhu\" by \"longhu\" and \"longhu2018\"",
  "matchedColumns": [
    1,
    2,
    3
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "I navigate to \"龙湖工程检查问题列表\"",
  "matchedColumns": [
    4
  ],
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "I wait for \"2\" seconds",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 27,
      "value": "#And I search \u003cissueId\u003e in the issue list"
    },
    {
      "line": 28,
      "value": "#And I open the details of issue \u003cissueId\u003e"
    },
    {
      "line": 29,
      "value": "#And I wait for \"1\" seconds"
    },
    {
      "line": 30,
      "value": "#When I click the floor plan for the issue"
    },
    {
      "line": 31,
      "value": "#And I wait for \"1\" seconds"
    },
    {
      "line": 32,
      "value": "#Then Capture the current page and save it as \u003cfileName1\u003e"
    },
    {
      "line": 33,
      "value": "#Then I verify the floorplan can be shown"
    },
    {
      "line": 34,
      "value": "#And I close the pop up window"
    },
    {
      "line": 35,
      "value": "#And I wait for \"1\" seconds"
    },
    {
      "line": 36,
      "value": "#When I click the picture for the issue"
    },
    {
      "line": 37,
      "value": "#And I wait for \"1\" seconds"
    },
    {
      "line": 38,
      "value": "#Then Capture the current page and save it as \u003cfileName2\u003e"
    },
    {
      "line": 39,
      "value": "#Then I vefity the picture can be shown"
    },
    {
      "line": 40,
      "value": "#And I close the pop up picture"
    }
  ],
  "line": 41,
  "name": "I search \"800706;35;247;256;989;987;771864;771847;767479;767484\" verify whether floor plan and desc pic can be shown in issue content and capture the screen shots as \"lhGuiPicVer_002_01_issueId\" and \"lhGuiPicVer_002_02_issueId\"",
  "matchedColumns": [
    5,
    6,
    7
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 42,
  "name": "I wait for \"1\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 43,
  "name": "I logout the system for \"longhu\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "Quit the driver",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "longhu",
      "offset": 9
    },
    {
      "val": "longhu",
      "offset": 21
    },
    {
      "val": "longhu2018",
      "offset": 34
    }
  ],
  "location": "PageOperations.i_login_by_and(String,String,String)"
});
formatter.result({
  "duration": 4823805735,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "龙湖工程检查问题列表",
      "offset": 15
    }
  ],
  "location": "PageOperations.i_navigate_to_of(String)"
});
formatter.result({
  "duration": 287547168,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 12
    }
  ],
  "location": "ShareSteps.i_wait_for_seconds(String)"
});
formatter.result({
  "duration": 2000611665,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "800706;35;247;256;989;987;771864;771847;767479;767484",
      "offset": 10
    },
    {
      "val": "lhGuiPicVer_002_01_issueId",
      "offset": 167
    },
    {
      "val": "lhGuiPicVer_002_02_issueId",
      "offset": 200
    }
  ],
  "location": "PageOperations.i_search_verify_whether_floor_plan_and_desc_pic_can_be_shown_in_issue_content_and_capture_the_screen_shots_as_and(String,String,String)"
});
formatter.result({
  "duration": 102089356792,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 12
    }
  ],
  "location": "ShareSteps.i_wait_for_seconds(String)"
});
formatter.result({
  "duration": 1000672831,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "longhu",
      "offset": 25
    }
  ],
  "location": "PageOperations.i_logout_the_system_for(String)"
});
formatter.result({
  "duration": 3267181615,
  "status": "passed"
});
formatter.match({
  "location": "PageOperations.quit_the_driver()"
});
formatter.result({
  "duration": 86011110,
  "status": "passed"
});
formatter.after({
  "duration": 34073,
  "status": "passed"
});
formatter.before({
  "duration": 61988,
  "status": "passed"
});
formatter.scenario({
  "line": 50,
  "name": "To Verify whether the pictures and floor plans can be shown in GUI",
  "description": "",
  "id": "verify-whether-the-pictures-can-be-shown-in-gui;to-verify-whether-the-pictures-and-floor-plans-can-be-shown-in-gui;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 19,
      "name": "@gui"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "I login \"gzb\" by \"gzb\" and \"gzb@2018\"",
  "matchedColumns": [
    1,
    2,
    3
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "I navigate to \"葛洲坝问题列表\"",
  "matchedColumns": [
    4
  ],
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "I wait for \"2\" seconds",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 27,
      "value": "#And I search \u003cissueId\u003e in the issue list"
    },
    {
      "line": 28,
      "value": "#And I open the details of issue \u003cissueId\u003e"
    },
    {
      "line": 29,
      "value": "#And I wait for \"1\" seconds"
    },
    {
      "line": 30,
      "value": "#When I click the floor plan for the issue"
    },
    {
      "line": 31,
      "value": "#And I wait for \"1\" seconds"
    },
    {
      "line": 32,
      "value": "#Then Capture the current page and save it as \u003cfileName1\u003e"
    },
    {
      "line": 33,
      "value": "#Then I verify the floorplan can be shown"
    },
    {
      "line": 34,
      "value": "#And I close the pop up window"
    },
    {
      "line": 35,
      "value": "#And I wait for \"1\" seconds"
    },
    {
      "line": 36,
      "value": "#When I click the picture for the issue"
    },
    {
      "line": 37,
      "value": "#And I wait for \"1\" seconds"
    },
    {
      "line": 38,
      "value": "#Then Capture the current page and save it as \u003cfileName2\u003e"
    },
    {
      "line": 39,
      "value": "#Then I vefity the picture can be shown"
    },
    {
      "line": 40,
      "value": "#And I close the pop up picture"
    }
  ],
  "line": 41,
  "name": "I search \"1055;809;27;32;74;71;123;163;426;439\" verify whether floor plan and desc pic can be shown in issue content and capture the screen shots as \"gzbGuiPicVer_003_01_issueId\" and \"gzbGuiPicVer_003_02_issueId\"",
  "matchedColumns": [
    5,
    6,
    7
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 42,
  "name": "I wait for \"1\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 43,
  "name": "I logout the system for \"gzb\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "Quit the driver",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "gzb",
      "offset": 9
    },
    {
      "val": "gzb",
      "offset": 18
    },
    {
      "val": "gzb@2018",
      "offset": 28
    }
  ],
  "location": "PageOperations.i_login_by_and(String,String,String)"
});
formatter.result({
  "duration": 4484936223,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "葛洲坝问题列表",
      "offset": 15
    }
  ],
  "location": "PageOperations.i_navigate_to_of(String)"
});
formatter.result({
  "duration": 279403410,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 12
    }
  ],
  "location": "ShareSteps.i_wait_for_seconds(String)"
});
formatter.result({
  "duration": 2000499184,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1055;809;27;32;74;71;123;163;426;439",
      "offset": 10
    },
    {
      "val": "gzbGuiPicVer_003_01_issueId",
      "offset": 150
    },
    {
      "val": "gzbGuiPicVer_003_02_issueId",
      "offset": 184
    }
  ],
  "location": "PageOperations.i_search_verify_whether_floor_plan_and_desc_pic_can_be_shown_in_issue_content_and_capture_the_screen_shots_as_and(String,String,String)"
});
formatter.result({
  "duration": 101325455588,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 12
    }
  ],
  "location": "ShareSteps.i_wait_for_seconds(String)"
});
formatter.result({
  "duration": 1000453207,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "gzb",
      "offset": 25
    }
  ],
  "location": "PageOperations.i_logout_the_system_for(String)"
});
formatter.result({
  "duration": 3336393709,
  "status": "passed"
});
formatter.match({
  "location": "PageOperations.quit_the_driver()"
});
formatter.result({
  "duration": 112213750,
  "status": "passed"
});
formatter.after({
  "duration": 66914,
  "status": "passed"
});
formatter.uri("Gui/GUI_ZJLogin.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: your.email@your.domain.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 20,
  "name": "GUI Login test for different envs",
  "description": "",
  "id": "gui-login-test-for-different-envs",
  "keyword": "Feature",
  "tags": [
    {
      "line": 19,
      "name": "@gui"
    }
  ]
});
formatter.scenarioOutline({
  "line": 23,
  "name": "Test for login",
  "description": "",
  "id": "gui-login-test-for-different-envs;test-for-login",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 22,
      "name": "@gui"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "I open URL \u003curl\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "I wait for \"1\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "I Get the title of the website for test case \u003ctestCase\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "Verify the title value is correct as expected \u003cexpTitle\u003e for test case \u003ctestCase\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "I input \u003cuserName\u003e into \u003cuserNameXPath\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "I input \u003cpassword\u003e into \u003cpasswordXPath\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "I click button \u003cloginButtonXPath\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "I wait for \"2\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "Capture the current page and save it as \u003cfileName\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "I verify \u003cuserRealName\u003e can be found in \u003ccurUserXPath\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "I click menu \u003cmenuXPath\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "I wait for \"1\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "I click menu \u003clogoutXPath\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "I wait for \"2\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 38,
  "name": "Quit the driver",
  "keyword": "And "
});
formatter.examples({
  "line": 40,
  "name": "",
  "description": "",
  "id": "gui-login-test-for-different-envs;test-for-login;",
  "rows": [
    {
      "cells": [
        "testCase",
        "url",
        "expTitle",
        "userName",
        "password",
        "userNameXPath",
        "passwordXPath",
        "loginButtonXPath",
        "userRealName",
        "curUserXPath",
        "fileName",
        "menuXPath",
        "logoutXPath"
      ],
      "line": 41,
      "id": "gui-login-test-for-different-envs;test-for-login;;1"
    },
    {
      "cells": [
        "\"guiLogin_001\"",
        "\"prod\"",
        "\"智检 - 工程现场管理协作平台\"",
        "\"kentestgrp10\"",
        "\"12345678\"",
        "\"prodUsrNameXPath\"",
        "\"prodUsrPswXPath\"",
        "\"prodLoginBtn\"",
        "\"kentestgrp10\"",
        "\"prodCurUsrXPath\"",
        "\"guiLogin_001\"",
        "\"prodCurUsrDropDown\"",
        "\"prodLogout\""
      ],
      "line": 42,
      "id": "gui-login-test-for-different-envs;test-for-login;;2"
    },
    {
      "cells": [
        "\"guiLogin_002\"",
        "\"longhu\"",
        "\"龙湖集团 - 龙建\"",
        "\"longhu\"",
        "\"longhu2018\"",
        "\"lhUsrNameXPath\"",
        "\"lhUsrPswXPath\"",
        "\"lhLoginBtn\"",
        "\"龙湖集团管理员\"",
        "\"prodCurUsrXPath\"",
        "\"guiLogin_002\"",
        "\"prodCurUsrDropDown\"",
        "\"prodLogout\""
      ],
      "line": 43,
      "id": "gui-login-test-for-different-envs;test-for-login;;3"
    },
    {
      "cells": [
        "\"guiLogin_003\"",
        "\"zl\"",
        "\"中梁控股集团\"",
        "\"zhongliang\"",
        "\"zhongliang@2018\"",
        "\"zlUsrNameXPath\"",
        "\"zlUsrPswXPath\"",
        "\"zlLoginBtn\"",
        "\"中梁\"",
        "\"zlCurUsrXPath\"",
        "\"guiLogin_003\"",
        "\"zlCurUsrDropDown\"",
        "\"prodLogout\""
      ],
      "line": 44,
      "id": "gui-login-test-for-different-envs;test-for-login;;4"
    },
    {
      "cells": [
        "\"guiLogin_004\"",
        "\"gzb\"",
        "\"葛洲坝地产\"",
        "\"gzb\"",
        "\"gzb@2018\"",
        "\"gzbUsrNameXPath\"",
        "\"gzbUsrPswXPath\"",
        "\"gzbLoginBtn\"",
        "\"地产总部管理员\"",
        "\"prodCurUsrXPath\"",
        "\"guiLogin_004\"",
        "\"prodCurUsrDropDown\"",
        "\"prodLogout\""
      ],
      "line": 45,
      "id": "gui-login-test-for-different-envs;test-for-login;;5"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 43514,
  "status": "passed"
});
formatter.scenario({
  "line": 42,
  "name": "Test for login",
  "description": "",
  "id": "gui-login-test-for-different-envs;test-for-login;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 19,
      "name": "@gui"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "I open URL \"prod\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "I wait for \"1\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "I Get the title of the website for test case \"guiLogin_001\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "Verify the title value is correct as expected \"智检 - 工程现场管理协作平台\" for test case \"guiLogin_001\"",
  "matchedColumns": [
    0,
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "I input \"kentestgrp10\" into \"prodUsrNameXPath\"",
  "matchedColumns": [
    3,
    5
  ],
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "I input \"12345678\" into \"prodUsrPswXPath\"",
  "matchedColumns": [
    4,
    6
  ],
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "I click button \"prodLoginBtn\"",
  "matchedColumns": [
    7
  ],
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "I wait for \"2\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "Capture the current page and save it as \"guiLogin_001\"",
  "matchedColumns": [
    10
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "I verify \"kentestgrp10\" can be found in \"prodCurUsrXPath\"",
  "matchedColumns": [
    8,
    9
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "I click menu \"prodCurUsrDropDown\"",
  "matchedColumns": [
    11
  ],
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "I wait for \"1\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "I click menu \"prodLogout\"",
  "matchedColumns": [
    12
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "I wait for \"2\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 38,
  "name": "Quit the driver",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "prod",
      "offset": 12
    }
  ],
  "location": "PageOperations.i_open_URL(String)"
});
formatter.result({
  "duration": 3487102500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 12
    }
  ],
  "location": "ShareSteps.i_wait_for_seconds(String)"
});
formatter.result({
  "duration": 1001009041,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "guiLogin_001",
      "offset": 46
    }
  ],
  "location": "PageOperations.i_Get_the_title_of_the_website_for_test_case(String)"
});
formatter.result({
  "duration": 22330270,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "智检 - 工程现场管理协作平台",
      "offset": 47
    },
    {
      "val": "guiLogin_001",
      "offset": 79
    }
  ],
  "location": "PageOperations.verify_the_title_value_is_correct_as_expected_for_test_case(String,String)"
});
formatter.result({
  "duration": 151890,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "kentestgrp10",
      "offset": 9
    },
    {
      "val": "prodUsrNameXPath",
      "offset": 29
    }
  ],
  "location": "PageOperations.i_input_into(String,String)"
});
formatter.result({
  "duration": 224363048,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "12345678",
      "offset": 9
    },
    {
      "val": "prodUsrPswXPath",
      "offset": 25
    }
  ],
  "location": "PageOperations.i_input_into(String,String)"
});
formatter.result({
  "duration": 172133469,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prodLoginBtn",
      "offset": 16
    }
  ],
  "location": "PageOperations.i_click_button(String)"
});
formatter.result({
  "duration": 117568482,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 12
    }
  ],
  "location": "ShareSteps.i_wait_for_seconds(String)"
});
formatter.result({
  "duration": 2000206488,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "guiLogin_001",
      "offset": 41
    }
  ],
  "location": "PageOperations.capture_the_current_page_and_save_it_as(String)"
});
formatter.result({
  "duration": 358994917,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "kentestgrp10",
      "offset": 10
    },
    {
      "val": "prodCurUsrXPath",
      "offset": 41
    }
  ],
  "location": "PageOperations.i_verify_can_be_found_in(String,String)"
});
formatter.result({
  "duration": 71375498,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prodCurUsrDropDown",
      "offset": 14
    }
  ],
  "location": "PageOperations.i_click_menu(String)"
});
formatter.result({
  "duration": 94482047,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 12
    }
  ],
  "location": "ShareSteps.i_wait_for_seconds(String)"
});
formatter.result({
  "duration": 1000361251,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prodLogout",
      "offset": 14
    }
  ],
  "location": "PageOperations.i_click_menu(String)"
});
formatter.result({
  "duration": 126223739,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 12
    }
  ],
  "location": "ShareSteps.i_wait_for_seconds(String)"
});
formatter.result({
  "duration": 2004377711,
  "status": "passed"
});
formatter.match({
  "location": "PageOperations.quit_the_driver()"
});
formatter.result({
  "duration": 49534150,
  "status": "passed"
});
formatter.after({
  "duration": 73892,
  "status": "passed"
});
formatter.before({
  "duration": 103039,
  "status": "passed"
});
formatter.scenario({
  "line": 43,
  "name": "Test for login",
  "description": "",
  "id": "gui-login-test-for-different-envs;test-for-login;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 19,
      "name": "@gui"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "I open URL \"longhu\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "I wait for \"1\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "I Get the title of the website for test case \"guiLogin_002\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "Verify the title value is correct as expected \"龙湖集团 - 龙建\" for test case \"guiLogin_002\"",
  "matchedColumns": [
    0,
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "I input \"longhu\" into \"lhUsrNameXPath\"",
  "matchedColumns": [
    3,
    5
  ],
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "I input \"longhu2018\" into \"lhUsrPswXPath\"",
  "matchedColumns": [
    4,
    6
  ],
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "I click button \"lhLoginBtn\"",
  "matchedColumns": [
    7
  ],
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "I wait for \"2\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "Capture the current page and save it as \"guiLogin_002\"",
  "matchedColumns": [
    10
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "I verify \"龙湖集团管理员\" can be found in \"prodCurUsrXPath\"",
  "matchedColumns": [
    8,
    9
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "I click menu \"prodCurUsrDropDown\"",
  "matchedColumns": [
    11
  ],
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "I wait for \"1\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "I click menu \"prodLogout\"",
  "matchedColumns": [
    12
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "I wait for \"2\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 38,
  "name": "Quit the driver",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "longhu",
      "offset": 12
    }
  ],
  "location": "PageOperations.i_open_URL(String)"
});
formatter.result({
  "duration": 3959423656,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 12
    }
  ],
  "location": "ShareSteps.i_wait_for_seconds(String)"
});
formatter.result({
  "duration": 1000594012,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "guiLogin_002",
      "offset": 46
    }
  ],
  "location": "PageOperations.i_Get_the_title_of_the_website_for_test_case(String)"
});
formatter.result({
  "duration": 7332995,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "龙湖集团 - 龙建",
      "offset": 47
    },
    {
      "val": "guiLogin_002",
      "offset": 73
    }
  ],
  "location": "PageOperations.verify_the_title_value_is_correct_as_expected_for_test_case(String,String)"
});
formatter.result({
  "duration": 102628,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "longhu",
      "offset": 9
    },
    {
      "val": "lhUsrNameXPath",
      "offset": 23
    }
  ],
  "location": "PageOperations.i_input_into(String,String)"
});
formatter.result({
  "duration": 162789781,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "longhu2018",
      "offset": 9
    },
    {
      "val": "lhUsrPswXPath",
      "offset": 27
    }
  ],
  "location": "PageOperations.i_input_into(String,String)"
});
formatter.result({
  "duration": 288389952,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "lhLoginBtn",
      "offset": 16
    }
  ],
  "location": "PageOperations.i_click_button(String)"
});
formatter.result({
  "duration": 145767856,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 12
    }
  ],
  "location": "ShareSteps.i_wait_for_seconds(String)"
});
formatter.result({
  "duration": 2000178163,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "guiLogin_002",
      "offset": 41
    }
  ],
  "location": "PageOperations.capture_the_current_page_and_save_it_as(String)"
});
formatter.result({
  "duration": 360677610,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "龙湖集团管理员",
      "offset": 10
    },
    {
      "val": "prodCurUsrXPath",
      "offset": 36
    }
  ],
  "location": "PageOperations.i_verify_can_be_found_in(String,String)"
});
formatter.result({
  "duration": 73795062,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prodCurUsrDropDown",
      "offset": 14
    }
  ],
  "location": "PageOperations.i_click_menu(String)"
});
formatter.result({
  "duration": 119621047,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 12
    }
  ],
  "location": "ShareSteps.i_wait_for_seconds(String)"
});
formatter.result({
  "duration": 1000393272,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prodLogout",
      "offset": 14
    }
  ],
  "location": "PageOperations.i_click_menu(String)"
});
formatter.result({
  "duration": 121091094,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 12
    }
  ],
  "location": "ShareSteps.i_wait_for_seconds(String)"
});
formatter.result({
  "duration": 2001295990,
  "status": "passed"
});
formatter.match({
  "location": "PageOperations.quit_the_driver()"
});
formatter.result({
  "duration": 82151877,
  "status": "passed"
});
formatter.after({
  "duration": 59114,
  "status": "passed"
});
formatter.before({
  "duration": 74714,
  "status": "passed"
});
formatter.scenario({
  "line": 44,
  "name": "Test for login",
  "description": "",
  "id": "gui-login-test-for-different-envs;test-for-login;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 19,
      "name": "@gui"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "I open URL \"zl\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "I wait for \"1\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "I Get the title of the website for test case \"guiLogin_003\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "Verify the title value is correct as expected \"中梁控股集团\" for test case \"guiLogin_003\"",
  "matchedColumns": [
    0,
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "I input \"zhongliang\" into \"zlUsrNameXPath\"",
  "matchedColumns": [
    3,
    5
  ],
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "I input \"zhongliang@2018\" into \"zlUsrPswXPath\"",
  "matchedColumns": [
    4,
    6
  ],
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "I click button \"zlLoginBtn\"",
  "matchedColumns": [
    7
  ],
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "I wait for \"2\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "Capture the current page and save it as \"guiLogin_003\"",
  "matchedColumns": [
    10
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "I verify \"中梁\" can be found in \"zlCurUsrXPath\"",
  "matchedColumns": [
    8,
    9
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "I click menu \"zlCurUsrDropDown\"",
  "matchedColumns": [
    11
  ],
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "I wait for \"1\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "I click menu \"prodLogout\"",
  "matchedColumns": [
    12
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "I wait for \"2\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 38,
  "name": "Quit the driver",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "zl",
      "offset": 12
    }
  ],
  "location": "PageOperations.i_open_URL(String)"
});
formatter.result({
  "duration": 3893475551,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 12
    }
  ],
  "location": "ShareSteps.i_wait_for_seconds(String)"
});
formatter.result({
  "duration": 1001808310,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "guiLogin_003",
      "offset": 46
    }
  ],
  "location": "PageOperations.i_Get_the_title_of_the_website_for_test_case(String)"
});
formatter.result({
  "duration": 7218873,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "中梁控股集团",
      "offset": 47
    },
    {
      "val": "guiLogin_003",
      "offset": 70
    }
  ],
  "location": "PageOperations.verify_the_title_value_is_correct_as_expected_for_test_case(String,String)"
});
formatter.result({
  "duration": 87029,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "zhongliang",
      "offset": 9
    },
    {
      "val": "zlUsrNameXPath",
      "offset": 27
    }
  ],
  "location": "PageOperations.i_input_into(String,String)"
});
formatter.result({
  "duration": 219434428,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "zhongliang@2018",
      "offset": 9
    },
    {
      "val": "zlUsrPswXPath",
      "offset": 32
    }
  ],
  "location": "PageOperations.i_input_into(String,String)"
});
formatter.result({
  "duration": 310473092,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "zlLoginBtn",
      "offset": 16
    }
  ],
  "location": "PageOperations.i_click_button(String)"
});
formatter.result({
  "duration": 157173962,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 12
    }
  ],
  "location": "ShareSteps.i_wait_for_seconds(String)"
});
formatter.result({
  "duration": 2000919549,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "guiLogin_003",
      "offset": 41
    }
  ],
  "location": "PageOperations.capture_the_current_page_and_save_it_as(String)"
});
formatter.result({
  "duration": 358015842,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "中梁",
      "offset": 10
    },
    {
      "val": "zlCurUsrXPath",
      "offset": 31
    }
  ],
  "location": "PageOperations.i_verify_can_be_found_in(String,String)"
});
formatter.result({
  "duration": 74347612,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "zlCurUsrDropDown",
      "offset": 14
    }
  ],
  "location": "PageOperations.i_click_menu(String)"
});
formatter.result({
  "duration": 95947168,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 12
    }
  ],
  "location": "ShareSteps.i_wait_for_seconds(String)"
});
formatter.result({
  "duration": 1002043123,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prodLogout",
      "offset": 14
    }
  ],
  "location": "PageOperations.i_click_menu(String)"
});
formatter.result({
  "duration": 132065341,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 12
    }
  ],
  "location": "ShareSteps.i_wait_for_seconds(String)"
});
formatter.result({
  "duration": 2000290232,
  "status": "passed"
});
formatter.match({
  "location": "PageOperations.quit_the_driver()"
});
formatter.result({
  "duration": 112112353,
  "status": "passed"
});
formatter.after({
  "duration": 90313,
  "status": "passed"
});
formatter.before({
  "duration": 68967,
  "status": "passed"
});
formatter.scenario({
  "line": 45,
  "name": "Test for login",
  "description": "",
  "id": "gui-login-test-for-different-envs;test-for-login;;5",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 19,
      "name": "@gui"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "I open URL \"gzb\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "I wait for \"1\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "I Get the title of the website for test case \"guiLogin_004\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "Verify the title value is correct as expected \"葛洲坝地产\" for test case \"guiLogin_004\"",
  "matchedColumns": [
    0,
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "I input \"gzb\" into \"gzbUsrNameXPath\"",
  "matchedColumns": [
    3,
    5
  ],
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "I input \"gzb@2018\" into \"gzbUsrPswXPath\"",
  "matchedColumns": [
    4,
    6
  ],
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "I click button \"gzbLoginBtn\"",
  "matchedColumns": [
    7
  ],
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "I wait for \"2\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "Capture the current page and save it as \"guiLogin_004\"",
  "matchedColumns": [
    10
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "I verify \"地产总部管理员\" can be found in \"prodCurUsrXPath\"",
  "matchedColumns": [
    8,
    9
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "I click menu \"prodCurUsrDropDown\"",
  "matchedColumns": [
    11
  ],
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "I wait for \"1\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "I click menu \"prodLogout\"",
  "matchedColumns": [
    12
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "I wait for \"2\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 38,
  "name": "Quit the driver",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "gzb",
      "offset": 12
    }
  ],
  "location": "PageOperations.i_open_URL(String)"
});
formatter.result({
  "duration": 3713060392,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 12
    }
  ],
  "location": "ShareSteps.i_wait_for_seconds(String)"
});
formatter.result({
  "duration": 1001146563,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "guiLogin_004",
      "offset": 46
    }
  ],
  "location": "PageOperations.i_Get_the_title_of_the_website_for_test_case(String)"
});
formatter.result({
  "duration": 18234580,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "葛洲坝地产",
      "offset": 47
    },
    {
      "val": "guiLogin_004",
      "offset": 69
    }
  ],
  "location": "PageOperations.verify_the_title_value_is_correct_as_expected_for_test_case(String,String)"
});
formatter.result({
  "duration": 188015,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "gzb",
      "offset": 9
    },
    {
      "val": "gzbUsrNameXPath",
      "offset": 20
    }
  ],
  "location": "PageOperations.i_input_into(String,String)"
});
formatter.result({
  "duration": 174358040,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "gzb@2018",
      "offset": 9
    },
    {
      "val": "gzbUsrPswXPath",
      "offset": 25
    }
  ],
  "location": "PageOperations.i_input_into(String,String)"
});
formatter.result({
  "duration": 184257152,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "gzbLoginBtn",
      "offset": 16
    }
  ],
  "location": "PageOperations.i_click_button(String)"
});
formatter.result({
  "duration": 120284436,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 12
    }
  ],
  "location": "ShareSteps.i_wait_for_seconds(String)"
});
formatter.result({
  "duration": 2000586213,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "guiLogin_004",
      "offset": 41
    }
  ],
  "location": "PageOperations.capture_the_current_page_and_save_it_as(String)"
});
formatter.result({
  "duration": 345241497,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "地产总部管理员",
      "offset": 10
    },
    {
      "val": "prodCurUsrXPath",
      "offset": 36
    }
  ],
  "location": "PageOperations.i_verify_can_be_found_in(String,String)"
});
formatter.result({
  "duration": 71822136,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prodCurUsrDropDown",
      "offset": 14
    }
  ],
  "location": "PageOperations.i_click_menu(String)"
});
formatter.result({
  "duration": 93748461,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 12
    }
  ],
  "location": "ShareSteps.i_wait_for_seconds(String)"
});
formatter.result({
  "duration": 1000090723,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "prodLogout",
      "offset": 14
    }
  ],
  "location": "PageOperations.i_click_menu(String)"
});
formatter.result({
  "duration": 103038372,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 12
    }
  ],
  "location": "ShareSteps.i_wait_for_seconds(String)"
});
formatter.result({
  "duration": 2000358378,
  "status": "passed"
});
formatter.match({
  "location": "PageOperations.quit_the_driver()"
});
formatter.result({
  "duration": 89729127,
  "status": "passed"
});
formatter.after({
  "duration": 34072,
  "status": "passed"
});
formatter.uri("Interface/AppApi_ZJLogin.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: your.email@your.domain.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 20,
  "name": "App login API test for different envs",
  "description": "",
  "id": "app-login-api-test-for-different-envs",
  "keyword": "Feature",
  "tags": [
    {
      "line": 19,
      "name": "@AppApi"
    }
  ]
});
formatter.scenarioOutline({
  "line": 23,
  "name": "Test for app login api",
  "description": "",
  "id": "app-login-api-test-for-different-envs;test-for-app-login-api",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 22,
      "name": "@AppApi"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "I call the \"login\" api of \u003cenv\u003e with \u003cpsw\u003e and \u003cusr\u003ein \u003capiParameters\u003e for \u003ctestCase\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "Verify the calling is successful with \"登录成功\" for \u003ctestCase\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 26,
  "name": "Verify the return message is expected as \u003cexpValueList\u003e in \u003creturnMsgFieldList\u003e for \u003ctestCase\u003e",
  "keyword": "And "
});
formatter.examples({
  "line": 28,
  "name": "",
  "description": "",
  "id": "app-login-api-test-for-different-envs;test-for-app-login-api;",
  "rows": [
    {
      "cells": [
        "testCase",
        "env",
        "usr",
        "psw",
        "apiParameters",
        "expValueList",
        "returnMsgFieldList"
      ],
      "line": 29,
      "id": "app-login-api-test-for-different-envs;test-for-app-login-api;;1"
    },
    {
      "cells": [
        "\"appapilogin_001\"",
        "\"prodEnv\"",
        "\"kentest40\"",
        "\"12345678\"",
        "\"device_id;password;username\"",
        "\"115430;肆肆肆肆肆肆肆肆肆肆肆肆;kentest40;0\"",
        "\"id;real_name;user_name;delete_at\""
      ],
      "line": 30,
      "id": "app-login-api-test-for-different-envs;test-for-app-login-api;;2"
    },
    {
      "cells": [
        "\"appapilogin_002\"",
        "\"longhuEnv\"",
        "\"kentestchk1\"",
        "\"12345678\"",
        "\"device_id;password;username\"",
        "\"2;坚龙湖检查人;kentestchk1;0\"",
        "\"id;real_name;user_name;delete_at\""
      ],
      "line": 31,
      "id": "app-login-api-test-for-different-envs;test-for-app-login-api;;3"
    },
    {
      "cells": [
        "\"appapilogin_003\"",
        "\"zlEnv\"",
        "\"kentest10\"",
        "\"12345678\"",
        "\"device_id;password;username\"",
        "\"11448;kentest10;kentest10;0\"",
        "\"id;real_name;user_name;delete_at\""
      ],
      "line": 32,
      "id": "app-login-api-test-for-different-envs;test-for-app-login-api;;4"
    },
    {
      "cells": [
        "\"appapilogin_004\"",
        "\"gzbEnv\"",
        "\"kentest10\"",
        "\"12345678\"",
        "\"device_id;password;username\"",
        "\"189;坚葛洲坝检查人;kentest10;0\"",
        "\"id;real_name;user_name;delete_at\""
      ],
      "line": 33,
      "id": "app-login-api-test-for-different-envs;test-for-app-login-api;;5"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 68145,
  "status": "passed"
});
formatter.scenario({
  "line": 30,
  "name": "Test for app login api",
  "description": "",
  "id": "app-login-api-test-for-different-envs;test-for-app-login-api;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 19,
      "name": "@AppApi"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "I call the \"login\" api of \"prodEnv\" with \"12345678\" and \"kentest40\"in \"device_id;password;username\" for \"appapilogin_001\"",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "Verify the calling is successful with \"登录成功\" for \"appapilogin_001\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 26,
  "name": "Verify the return message is expected as \"115430;肆肆肆肆肆肆肆肆肆肆肆肆;kentest40;0\" in \"id;real_name;user_name;delete_at\" for \"appapilogin_001\"",
  "matchedColumns": [
    0,
    5,
    6
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "login",
      "offset": 12
    },
    {
      "val": "prodEnv",
      "offset": 27
    },
    {
      "val": "12345678",
      "offset": 42
    },
    {
      "val": "kentest40",
      "offset": 57
    },
    {
      "val": "device_id;password;username",
      "offset": 71
    },
    {
      "val": "appapilogin_001",
      "offset": 105
    }
  ],
  "location": "AppApiTest.i_call_the_api_of_with_and_in(String,String,String,String,String,String)"
});
formatter.result({
  "duration": 1965125272,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "登录成功",
      "offset": 39
    },
    {
      "val": "appapilogin_001",
      "offset": 50
    }
  ],
  "location": "AppApiTest.verify_the_calling_is_successful_with_for(String,String)"
});
formatter.result({
  "duration": 69313901,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "115430;肆肆肆肆肆肆肆肆肆肆肆肆;kentest40;0",
      "offset": 42
    },
    {
      "val": "id;real_name;user_name;delete_at",
      "offset": 79
    },
    {
      "val": "appapilogin_001",
      "offset": 118
    }
  ],
  "location": "AppApiTest.verify_the_return_message_is_expected_as_in_for(String,String,String)"
});
formatter.result({
  "duration": 914623,
  "status": "passed"
});
formatter.before({
  "duration": 49672,
  "status": "passed"
});
formatter.scenario({
  "line": 31,
  "name": "Test for app login api",
  "description": "",
  "id": "app-login-api-test-for-different-envs;test-for-app-login-api;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 19,
      "name": "@AppApi"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "I call the \"login\" api of \"longhuEnv\" with \"12345678\" and \"kentestchk1\"in \"device_id;password;username\" for \"appapilogin_002\"",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "Verify the calling is successful with \"登录成功\" for \"appapilogin_002\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 26,
  "name": "Verify the return message is expected as \"2;坚龙湖检查人;kentestchk1;0\" in \"id;real_name;user_name;delete_at\" for \"appapilogin_002\"",
  "matchedColumns": [
    0,
    5,
    6
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "login",
      "offset": 12
    },
    {
      "val": "longhuEnv",
      "offset": 27
    },
    {
      "val": "12345678",
      "offset": 44
    },
    {
      "val": "kentestchk1",
      "offset": 59
    },
    {
      "val": "device_id;password;username",
      "offset": 75
    },
    {
      "val": "appapilogin_002",
      "offset": 109
    }
  ],
  "location": "AppApiTest.i_call_the_api_of_with_and_in(String,String,String,String,String,String)"
});
formatter.result({
  "duration": 370078769,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "登录成功",
      "offset": 39
    },
    {
      "val": "appapilogin_002",
      "offset": 50
    }
  ],
  "location": "AppApiTest.verify_the_calling_is_successful_with_for(String,String)"
});
formatter.result({
  "duration": 960190,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2;坚龙湖检查人;kentestchk1;0",
      "offset": 42
    },
    {
      "val": "id;real_name;user_name;delete_at",
      "offset": 70
    },
    {
      "val": "appapilogin_002",
      "offset": 109
    }
  ],
  "location": "AppApiTest.verify_the_return_message_is_expected_as_in_for(String,String,String)"
});
formatter.result({
  "duration": 807480,
  "status": "passed"
});
formatter.before({
  "duration": 54598,
  "status": "passed"
});
formatter.scenario({
  "line": 32,
  "name": "Test for app login api",
  "description": "",
  "id": "app-login-api-test-for-different-envs;test-for-app-login-api;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 19,
      "name": "@AppApi"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "I call the \"login\" api of \"zlEnv\" with \"12345678\" and \"kentest10\"in \"device_id;password;username\" for \"appapilogin_003\"",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "Verify the calling is successful with \"登录成功\" for \"appapilogin_003\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 26,
  "name": "Verify the return message is expected as \"11448;kentest10;kentest10;0\" in \"id;real_name;user_name;delete_at\" for \"appapilogin_003\"",
  "matchedColumns": [
    0,
    5,
    6
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "login",
      "offset": 12
    },
    {
      "val": "zlEnv",
      "offset": 27
    },
    {
      "val": "12345678",
      "offset": 40
    },
    {
      "val": "kentest10",
      "offset": 55
    },
    {
      "val": "device_id;password;username",
      "offset": 69
    },
    {
      "val": "appapilogin_003",
      "offset": 103
    }
  ],
  "location": "AppApiTest.i_call_the_api_of_with_and_in(String,String,String,String,String,String)"
});
formatter.result({
  "duration": 313414007,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "登录成功",
      "offset": 39
    },
    {
      "val": "appapilogin_003",
      "offset": 50
    }
  ],
  "location": "AppApiTest.verify_the_calling_is_successful_with_for(String,String)"
});
formatter.result({
  "duration": 2997567,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "11448;kentest10;kentest10;0",
      "offset": 42
    },
    {
      "val": "id;real_name;user_name;delete_at",
      "offset": 75
    },
    {
      "val": "appapilogin_003",
      "offset": 114
    }
  ],
  "location": "AppApiTest.verify_the_return_message_is_expected_as_in_for(String,String,String)"
});
formatter.result({
  "duration": 1938853,
  "status": "passed"
});
formatter.before({
  "duration": 133007,
  "status": "passed"
});
formatter.scenario({
  "line": 33,
  "name": "Test for app login api",
  "description": "",
  "id": "app-login-api-test-for-different-envs;test-for-app-login-api;;5",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 19,
      "name": "@AppApi"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "I call the \"login\" api of \"gzbEnv\" with \"12345678\" and \"kentest10\"in \"device_id;password;username\" for \"appapilogin_004\"",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "Verify the calling is successful with \"登录成功\" for \"appapilogin_004\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 26,
  "name": "Verify the return message is expected as \"189;坚葛洲坝检查人;kentest10;0\" in \"id;real_name;user_name;delete_at\" for \"appapilogin_004\"",
  "matchedColumns": [
    0,
    5,
    6
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "login",
      "offset": 12
    },
    {
      "val": "gzbEnv",
      "offset": 27
    },
    {
      "val": "12345678",
      "offset": 41
    },
    {
      "val": "kentest10",
      "offset": 56
    },
    {
      "val": "device_id;password;username",
      "offset": 70
    },
    {
      "val": "appapilogin_004",
      "offset": 104
    }
  ],
  "location": "AppApiTest.i_call_the_api_of_with_and_in(String,String,String,String,String,String)"
});
formatter.result({
  "duration": 310046568,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "登录成功",
      "offset": 39
    },
    {
      "val": "appapilogin_004",
      "offset": 50
    }
  ],
  "location": "AppApiTest.verify_the_calling_is_successful_with_for(String,String)"
});
formatter.result({
  "duration": 2083353,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "189;坚葛洲坝检查人;kentest10;0",
      "offset": 42
    },
    {
      "val": "id;real_name;user_name;delete_at",
      "offset": 71
    },
    {
      "val": "appapilogin_004",
      "offset": 110
    }
  ],
  "location": "AppApiTest.verify_the_return_message_is_expected_as_in_for(String,String,String)"
});
formatter.result({
  "duration": 1720460,
  "status": "passed"
});
});