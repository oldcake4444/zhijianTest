$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Gui/GUI_ZJLogin.feature");
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
  "name": "Login test for different envs",
  "description": "",
  "id": "login-test-for-different-envs",
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
  "id": "login-test-for-different-envs;test-for-login",
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
  "id": "login-test-for-different-envs;test-for-login;",
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
      "id": "login-test-for-different-envs;test-for-login;;1"
    },
    {
      "cells": [
        "\"001\"",
        "\"prod\"",
        "\"智检 - 工程现场管理协作平台\"",
        "\"kentestgrp10\"",
        "\"12345678\"",
        "\"prodUsrNameXPath\"",
        "\"prodUsrPswXPath\"",
        "\"prodLoginBtn\"",
        "\"kentestgrp10\"",
        "\"prodCurUsrXPath\"",
        "\"zhijian_login_001\"",
        "\"prodCurUsrDropDown\"",
        "\"prodLogout\""
      ],
      "line": 42,
      "id": "login-test-for-different-envs;test-for-login;;2"
    },
    {
      "cells": [
        "\"002\"",
        "\"longhu\"",
        "\"龙湖集团 - 龙建\"",
        "\"longhu\"",
        "\"longhu2018\"",
        "\"lhUsrNameXPath\"",
        "\"lhUsrPswXPath\"",
        "\"lhLoginBtn\"",
        "\"龙湖集团管理员\"",
        "\"prodCurUsrXPath\"",
        "\"zhijian_login_002\"",
        "\"prodCurUsrDropDown\"",
        "\"prodLogout\""
      ],
      "line": 43,
      "id": "login-test-for-different-envs;test-for-login;;3"
    },
    {
      "cells": [
        "\"003\"",
        "\"zl\"",
        "\"中梁控股集团\"",
        "\"zhongliang\"",
        "\"zhongliang@2018\"",
        "\"zlUsrNameXPath\"",
        "\"zlUsrPswXPath\"",
        "\"zlLoginBtn\"",
        "\"中梁\"",
        "\"zlCurUsrXPath\"",
        "\"zhijian_login_003\"",
        "\"zlCurUsrDropDown\"",
        "\"prodLogout\""
      ],
      "line": 44,
      "id": "login-test-for-different-envs;test-for-login;;4"
    },
    {
      "cells": [
        "\"004\"",
        "\"gzb\"",
        "\"葛洲坝地产\"",
        "\"gzb\"",
        "\"gzb@2018\"",
        "\"gzbUsrNameXPath\"",
        "\"gzbUsrPswXPath\"",
        "\"gzbLoginBtn\"",
        "\"地产总部管理员\"",
        "\"prodCurUsrXPath\"",
        "\"zhijian_login_004\"",
        "\"prodCurUsrDropDown\"",
        "\"prodLogout\""
      ],
      "line": 45,
      "id": "login-test-for-different-envs;test-for-login;;5"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 254520,
  "status": "passed"
});
formatter.scenario({
  "line": 42,
  "name": "Test for login",
  "description": "",
  "id": "login-test-for-different-envs;test-for-login;;2",
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
  "name": "I Get the title of the website for test case \"001\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "Verify the title value is correct as expected \"智检 - 工程现场管理协作平台\" for test case \"001\"",
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
  "name": "Capture the current page and save it as \"zhijian_login_001\"",
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
  "duration": 4974902676,
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
  "duration": 1002776322,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "001",
      "offset": 46
    }
  ],
  "location": "PageOperations.i_Get_the_title_of_the_website_for_test_case(String)"
});
formatter.result({
  "duration": 39353322,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "智检 - 工程现场管理协作平台",
      "offset": 47
    },
    {
      "val": "001",
      "offset": 79
    }
  ],
  "location": "PageOperations.verify_the_title_value_is_correct_as_expected_for_test_case(String,String)"
});
formatter.result({
  "duration": 4552626,
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
  "duration": 242073649,
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
  "duration": 197651683,
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
  "duration": 126812584,
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
  "duration": 2000812822,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "zhijian_login_001",
      "offset": 41
    }
  ],
  "location": "PageOperations.capture_the_current_page_and_save_it_as(String)"
});
formatter.result({
  "duration": 372639173,
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
  "duration": 81803578,
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
  "duration": 102949272,
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
  "duration": 1000682688,
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
  "duration": 106616414,
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
  "duration": 2000825548,
  "status": "passed"
});
formatter.match({
  "location": "PageOperations.quit_the_driver()"
});
formatter.result({
  "duration": 95770985,
  "status": "passed"
});
formatter.after({
  "duration": 150249,
  "status": "passed"
});
formatter.before({
  "duration": 79640,
  "status": "passed"
});
formatter.scenario({
  "line": 43,
  "name": "Test for login",
  "description": "",
  "id": "login-test-for-different-envs;test-for-login;;3",
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
  "name": "I Get the title of the website for test case \"002\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "Verify the title value is correct as expected \"龙湖集团 - 龙建\" for test case \"002\"",
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
  "name": "Capture the current page and save it as \"zhijian_login_002\"",
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
  "duration": 4060729726,
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
  "duration": 1000795581,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "002",
      "offset": 46
    }
  ],
  "location": "PageOperations.i_Get_the_title_of_the_website_for_test_case(String)"
});
formatter.result({
  "duration": 21021718,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "龙湖集团 - 龙建",
      "offset": 47
    },
    {
      "val": "002",
      "offset": 73
    }
  ],
  "location": "PageOperations.verify_the_title_value_is_correct_as_expected_for_test_case(String,String)"
});
formatter.result({
  "duration": 217984,
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
  "duration": 178426384,
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
  "duration": 211629762,
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
  "duration": 120148673,
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
  "duration": 2000682689,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "zhijian_login_002",
      "offset": 41
    }
  ],
  "location": "PageOperations.capture_the_current_page_and_save_it_as(String)"
});
formatter.result({
  "duration": 365580755,
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
  "duration": 123887655,
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
  "duration": 111756078,
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
  "duration": 1000801328,
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
  "duration": 121905272,
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
  "duration": 2000979492,
  "status": "passed"
});
formatter.match({
  "location": "PageOperations.quit_the_driver()"
});
formatter.result({
  "duration": 47326369,
  "status": "passed"
});
formatter.after({
  "duration": 55830,
  "status": "passed"
});
formatter.before({
  "duration": 77998,
  "status": "passed"
});
formatter.scenario({
  "line": 44,
  "name": "Test for login",
  "description": "",
  "id": "login-test-for-different-envs;test-for-login;;4",
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
  "name": "I Get the title of the website for test case \"003\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "Verify the title value is correct as expected \"中梁控股集团\" for test case \"003\"",
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
  "name": "Capture the current page and save it as \"zhijian_login_003\"",
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
  "duration": 4537805470,
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
  "duration": 1001637549,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "003",
      "offset": 46
    }
  ],
  "location": "PageOperations.i_Get_the_title_of_the_website_for_test_case(String)"
});
formatter.result({
  "duration": 24333352,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "中梁控股集团",
      "offset": 47
    },
    {
      "val": "003",
      "offset": 70
    }
  ],
  "location": "PageOperations.verify_the_title_value_is_correct_as_expected_for_test_case(String,String)"
});
formatter.result({
  "duration": 798044,
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
  "duration": 259518949,
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
  "duration": 229816454,
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
  "duration": 121890494,
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
  "duration": 2000823085,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "zhijian_login_003",
      "offset": 41
    }
  ],
  "location": "PageOperations.capture_the_current_page_and_save_it_as(String)"
});
formatter.result({
  "duration": 380819530,
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
  "duration": 77824445,
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
  "duration": 98330964,
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
  "duration": 1000307887,
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
  "duration": 148078969,
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
  "duration": 2000693362,
  "status": "passed"
});
formatter.match({
  "location": "PageOperations.quit_the_driver()"
});
formatter.result({
  "duration": 92811162,
  "status": "passed"
});
formatter.after({
  "duration": 42283,
  "status": "passed"
});
formatter.before({
  "duration": 48031,
  "status": "passed"
});
formatter.scenario({
  "line": 45,
  "name": "Test for login",
  "description": "",
  "id": "login-test-for-different-envs;test-for-login;;5",
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
  "name": "I Get the title of the website for test case \"004\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "Verify the title value is correct as expected \"葛洲坝地产\" for test case \"004\"",
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
  "name": "Capture the current page and save it as \"zhijian_login_004\"",
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
  "duration": 3890831816,
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
  "duration": 1000565692,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "004",
      "offset": 46
    }
  ],
  "location": "PageOperations.i_Get_the_title_of_the_website_for_test_case(String)"
});
formatter.result({
  "duration": 18838592,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "葛洲坝地产",
      "offset": 47
    },
    {
      "val": "004",
      "offset": 69
    }
  ],
  "location": "PageOperations.verify_the_title_value_is_correct_as_expected_for_test_case(String,String)"
});
formatter.result({
  "duration": 190890,
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
  "duration": 160450697,
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
  "duration": 186541470,
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
  "duration": 123994389,
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
  "duration": 2001625645,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "zhijian_login_004",
      "offset": 41
    }
  ],
  "location": "PageOperations.capture_the_current_page_and_save_it_as(String)"
});
formatter.result({
  "duration": 394451544,
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
  "duration": 79941476,
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
  "duration": 104302745,
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
  "duration": 1000276688,
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
  "duration": 133807780,
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
  "duration": 2000502882,
  "status": "passed"
});
formatter.match({
  "location": "PageOperations.quit_the_driver()"
});
formatter.result({
  "duration": 79291219,
  "status": "passed"
});
formatter.after({
  "duration": 79641,
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
  "duration": 51314,
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
  "duration": 1924692020,
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
  "duration": 104778533,
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
  "duration": 889178,
  "status": "passed"
});
formatter.before({
  "duration": 67325,
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
  "duration": 551870169,
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
  "duration": 3394559,
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
  "duration": 2608010,
  "status": "passed"
});
formatter.before({
  "duration": 151481,
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
  "duration": 481663264,
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
  "duration": 1375640,
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
  "duration": 581702,
  "status": "passed"
});
formatter.before({
  "duration": 57472,
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
  "duration": 371821424,
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
  "duration": 633837,
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
  "duration": 619059,
  "status": "passed"
});
});