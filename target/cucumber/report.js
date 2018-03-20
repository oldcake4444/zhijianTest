$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Gui/ZhijianLogin.feature");
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
  "name": "I verify \u003cuserRealName\u003e can be found in \u003ccurUserXPath\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "Capture the current page and save it as \u003cfileName\u003e",
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
        "\"zhijianjt\"",
        "\"zhijian2017\"",
        "\"prodUsrNameXPath\"",
        "\"prodUsrPswXPath\"",
        "\"prodLoginBtn\"",
        "\"智检管理员\"",
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
  "duration": 248775,
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
  "name": "I input \"zhijianjt\" into \"prodUsrNameXPath\"",
  "matchedColumns": [
    3,
    5
  ],
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "I input \"zhijian2017\" into \"prodUsrPswXPath\"",
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
  "name": "I verify \"智检管理员\" can be found in \"prodCurUsrXPath\"",
  "matchedColumns": [
    8,
    9
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "Capture the current page and save it as \"zhijian_login_001\"",
  "matchedColumns": [
    10
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
  "duration": 5460320855,
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
  "duration": 1000774653,
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
  "duration": 25642394,
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
  "duration": 4223033,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "zhijianjt",
      "offset": 9
    },
    {
      "val": "prodUsrNameXPath",
      "offset": 26
    }
  ],
  "location": "PageOperations.i_input_into(String,String)"
});
formatter.result({
  "duration": 282314700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "zhijian2017",
      "offset": 9
    },
    {
      "val": "prodUsrPswXPath",
      "offset": 28
    }
  ],
  "location": "PageOperations.i_input_into(String,String)"
});
formatter.result({
  "duration": 200820058,
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
  "duration": 122974539,
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
  "duration": 2000865379,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "智检管理员",
      "offset": 10
    },
    {
      "val": "prodCurUsrXPath",
      "offset": 34
    }
  ],
  "location": "PageOperations.i_verify_can_be_found_in(String,String)"
});
formatter.result({
  "duration": 114134783,
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
  "duration": 451146525,
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
  "duration": 105341006,
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
  "duration": 1000791895,
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
  "duration": 132599211,
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
  "duration": 2001110871,
  "status": "passed"
});
formatter.match({
  "location": "PageOperations.quit_the_driver()"
});
formatter.result({
  "duration": 138722138,
  "status": "passed"
});
formatter.after({
  "duration": 144093,
  "status": "passed"
});
formatter.before({
  "duration": 79231,
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
  "name": "I verify \"龙湖集团管理员\" can be found in \"prodCurUsrXPath\"",
  "matchedColumns": [
    8,
    9
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "Capture the current page and save it as \"zhijian_login_002\"",
  "matchedColumns": [
    10
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
  "duration": 4559422758,
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
  "duration": 1000856347,
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
  "duration": 28341572,
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
  "duration": 197871,
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
  "duration": 199635704,
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
  "duration": 221864612,
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
  "duration": 131563056,
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
  "duration": 2000635076,
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
  "duration": 121197802,
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
  "duration": 404804824,
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
  "duration": 138411783,
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
  "duration": 1000669971,
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
  "duration": 180108845,
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
  "duration": 2000334575,
  "status": "passed"
});
formatter.match({
  "location": "PageOperations.quit_the_driver()"
});
formatter.result({
  "duration": 126775557,
  "status": "passed"
});
formatter.after({
  "duration": 48031,
  "status": "passed"
});
formatter.before({
  "duration": 67326,
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
  "name": "I verify \"中梁\" can be found in \"zlCurUsrXPath\"",
  "matchedColumns": [
    8,
    9
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "Capture the current page and save it as \"zhijian_login_003\"",
  "matchedColumns": [
    10
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
  "duration": 4521417924,
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
  "duration": 1002119932,
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
  "duration": 16258287,
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
  "duration": 116999,
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
  "duration": 236944292,
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
  "duration": 239265790,
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
  "duration": 112872841,
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
  "duration": 2000479488,
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
  "duration": 95344400,
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
  "duration": 422933035,
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
  "duration": 98612151,
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
  "duration": 1000330059,
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
  "duration": 134107878,
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
  "duration": 2000283260,
  "status": "passed"
});
formatter.match({
  "location": "PageOperations.quit_the_driver()"
});
formatter.result({
  "duration": 2322181248,
  "status": "passed"
});
formatter.after({
  "duration": 91136,
  "status": "passed"
});
formatter.before({
  "duration": 88673,
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
  "name": "I verify \"地产总部管理员\" can be found in \"prodCurUsrXPath\"",
  "matchedColumns": [
    8,
    9
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "Capture the current page and save it as \"zhijian_login_004\"",
  "matchedColumns": [
    10
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
  "duration": 4467397833,
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
  "duration": 1000582119,
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
  "duration": 14632212,
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
  "duration": 250007,
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
  "duration": 191011472,
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
  "duration": 190398562,
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
  "duration": 121296738,
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
  "duration": 2000511099,
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
  "duration": 105789706,
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
  "duration": 487312222,
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
  "duration": 94428528,
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
  "duration": 1000764801,
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
  "duration": 126811271,
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
  "duration": 2000884673,
  "status": "passed"
});
formatter.match({
  "location": "PageOperations.quit_the_driver()"
});
formatter.result({
  "duration": 2159444844,
  "status": "passed"
});
formatter.after({
  "duration": 69788,
  "status": "passed"
});
});