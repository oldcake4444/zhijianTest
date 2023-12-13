$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/resources/Features/Interface/AppApi_UserRelatedOrgInfo.feature");
formatter.feature({
  "line": 2,
  "name": "App login API test for different envs",
  "description": "",
  "id": "app-login-api-test-for-different-envs",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@AppApiTest"
    }
  ]
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Test for app login api",
  "description": "",
  "id": "app-login-api-test-for-different-envs;test-for-app-login-api",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@AppApi"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I call the \"login\" api of \u003cenv\u003e with \u003cpsw\u003e and \u003cusr\u003ein \u003capiParameters\u003e for \u003ctestCase\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Verify the calling is successful with \"登录成功\" for \u003ctestCase\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "I call the GetUsrOrg api of \u003cenv\u003e for \u003ctestCase\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Verify the related product list is expected as \u003cexpProductInfoPath\u003e for \u003ctestCase\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Verify the related group info is expected as \u003cexpGrpInfo\u003e for \u003ctestCase\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Verify the related company info is expected as \u003cexpComInfoPath\u003e for \u003ctestCase\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "Verify the related project info is expected as \u003cexpProjInfoPath\u003e for \u003ctestCase\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Verify the follow app info is expected as \u003cexpFollowApps\u003e for \u003ctestCase\u003e",
  "keyword": "And "
});
formatter.examples({
  "line": 15,
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
        "expProductInfoPath",
        "expGrpInfo",
        "expComInfoPath",
        "expProjInfoPath",
        "expFollowApps"
      ],
      "line": 16,
      "id": "app-login-api-test-for-different-envs;test-for-app-login-api;;1"
    },
    {
      "cells": [
        "\"UsrRelatedInfo001\"",
        "\"prod\"",
        "\"kentest46\"",
        "\"12345678\"",
        "\"device_id;password;username\"",
        "\"src/main/resources/TestData/relatedAppInfo/appInfo_kentest46.csv\"",
        "\"\"",
        "\"\"",
        "\"\"",
        "\"\""
      ],
      "line": 17,
      "id": "app-login-api-test-for-different-envs;test-for-app-login-api;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 17,
  "name": "Test for app login api",
  "description": "",
  "id": "app-login-api-test-for-different-envs;test-for-app-login-api;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@AppApi"
    },
    {
      "line": 1,
      "name": "@AppApiTest"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I call the \"login\" api of \"prod\" with \"12345678\" and \"kentest46\"in \"device_id;password;username\" for \"UsrRelatedInfo001\"",
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
  "line": 7,
  "name": "Verify the calling is successful with \"登录成功\" for \"UsrRelatedInfo001\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "I call the GetUsrOrg api of \"prod\" for \"UsrRelatedInfo001\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Verify the related product list is expected as \"src/main/resources/TestData/relatedAppInfo/appInfo_kentest46.csv\" for \"UsrRelatedInfo001\"",
  "matchedColumns": [
    0,
    5
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Verify the related group info is expected as \"\" for \"UsrRelatedInfo001\"",
  "matchedColumns": [
    0,
    6
  ],
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Verify the related company info is expected as \"\" for \"UsrRelatedInfo001\"",
  "matchedColumns": [
    0,
    7
  ],
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "Verify the related project info is expected as \"\" for \"UsrRelatedInfo001\"",
  "matchedColumns": [
    0,
    8
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Verify the follow app info is expected as \"\" for \"UsrRelatedInfo001\"",
  "matchedColumns": [
    0,
    9
  ],
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.uri("src/main/resources/Features/Interface/AppApi_ZJLogin.feature");
formatter.feature({
  "line": 2,
  "name": "App login API test for different envs",
  "description": "",
  "id": "app-login-api-test-for-different-envs",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@AppApiTest"
    }
  ]
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Test for app login api",
  "description": "",
  "id": "app-login-api-test-for-different-envs;test-for-app-login-api",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@AppApi"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I call the \"login\" api of \u003cenv\u003e with \u003cusr\u003e and \u003cpsw\u003e in \u003capiParameters\u003e for \u003ctestCase\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Verify the calling is successful with \"登录成功\" for \u003ctestCase\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Verify the return message is expected as \u003cexpValueList\u003e in \u003creturnMsgFieldList\u003e for \u003ctestCase\u003e",
  "keyword": "And "
});
formatter.examples({
  "line": 10,
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
      "line": 11,
      "id": "app-login-api-test-for-different-envs;test-for-app-login-api;;1"
    },
    {
      "cells": [
        "\"appapilogin_001\"",
        "\"prod\"",
        "\"kentest40\"",
        "\u002712345678\u0027",
        "\"device_id;password;username\"",
        "\"115430;肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆;kentest40;0\"",
        "\"id;real_name;user_name;delete_at\""
      ],
      "line": 12,
      "id": "app-login-api-test-for-different-envs;test-for-app-login-api;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 12,
  "name": "Test for app login api",
  "description": "",
  "id": "app-login-api-test-for-different-envs;test-for-app-login-api;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@AppApi"
    },
    {
      "line": 1,
      "name": "@AppApiTest"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I call the \"login\" api of \"prod\" with \"kentest40\" and \u002712345678\u0027 in \"device_id;password;username\" for \"appapilogin_001\"",
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
  "line": 7,
  "name": "Verify the calling is successful with \"登录成功\" for \"appapilogin_001\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Verify the return message is expected as \"115430;肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆;kentest40;0\" in \"id;real_name;user_name;delete_at\" for \"appapilogin_001\"",
  "matchedColumns": [
    0,
    5,
    6
  ],
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});