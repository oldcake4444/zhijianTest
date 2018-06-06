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
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 188839,
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
  "duration": 5503122631,
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
  "duration": 1001250858,
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
  "duration": 2000720465,
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
  "duration": 100529099599,
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
  "duration": 1000818170,
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
  "duration": 3311518777,
  "status": "passed"
});
formatter.match({
  "location": "PageOperations.quit_the_driver()"
});
formatter.result({
  "duration": 47049440,
  "status": "passed"
});
formatter.after({
  "duration": 144503,
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
        "\"| 中国首个工程管理协作平台\"",
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
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 60757,
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
  "name": "Verify the title value is correct as expected \"| 中国首个工程管理协作平台\" for test case \"guiLogin_001\"",
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
  "duration": 3456649974,
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
  "duration": 1002028386,
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
  "duration": 23535188,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "| 中国首个工程管理协作平台",
      "offset": 47
    },
    {
      "val": "guiLogin_001",
      "offset": 78
    }
  ],
  "location": "PageOperations.verify_the_title_value_is_correct_as_expected_for_test_case(String,String)"
});
formatter.result({
  "duration": 388353,
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
  "duration": 226547019,
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
  "duration": 176540594,
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
  "duration": 137020527,
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
  "duration": 2001658507,
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
  "duration": 395942079,
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
  "duration": 76367231,
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
  "duration": 90469870,
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
  "duration": 1000525467,
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
  "duration": 175055739,
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
  "duration": 2000565699,
  "status": "passed"
});
formatter.match({
  "location": "PageOperations.quit_the_driver()"
});
formatter.result({
  "duration": 96221685,
  "status": "passed"
});
formatter.after({
  "duration": 52547,
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
        "\"115430;肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆;kentest40;0\"",
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
  "duration": 66505,
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
  "name": "Verify the return message is expected as \"115430;肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆;kentest40;0\" in \"id;real_name;user_name;delete_at\" for \"appapilogin_001\"",
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
  "duration": 2051884970,
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
  "duration": 76693185,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "115430;肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆;kentest40;0",
      "offset": 42
    },
    {
      "val": "id;real_name;user_name;delete_at",
      "offset": 115
    },
    {
      "val": "appapilogin_001",
      "offset": 154
    }
  ],
  "location": "AppApiTest.verify_the_return_message_is_expected_as_in_for(String,String,String)"
});
formatter.result({
  "duration": 990588,
  "status": "passed"
});
formatter.before({
  "duration": 75126,
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
  "duration": 378863980,
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
  "duration": 911768,
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
  "duration": 866200,
  "status": "passed"
});
formatter.before({
  "duration": 87030,
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
  "duration": 533740133,
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
  "duration": 2693841,
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
  "duration": 4002993,
  "status": "passed"
});
formatter.before({
  "duration": 97704,
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
  "duration": 442634365,
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
  "duration": 894936,
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
  "duration": 1109229,
  "status": "passed"
});
});