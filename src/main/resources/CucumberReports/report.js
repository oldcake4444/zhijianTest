$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Gui/GUI_CreateProject.feature");
formatter.feature({
  "line": 2,
  "name": "Create new account",
  "description": "",
  "id": "create-new-account",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@GUI"
    }
  ]
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Create new accounts",
  "description": "",
  "id": "create-new-account;create-new-accounts",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@GUI"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I am testing in \u003cenv\u003e for \u003ctestCase\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I login with \u003centerpriseId\u003e by \u003cusr\u003e and \u003cpsw\u003e for \u003ctestCase\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I wait for \"3\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I go to \u003ctgtPage\u003e page for \u003cgroupId\u003e for \u003ctestCase\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I wait for \"3\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I click the link in organization management page for \u003ccomName\u003e for \u003ctestCase\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I wait for \"8\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I click the link for \u003cbtnName1\u003e for \u003ctestCase\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I click the link for \u003cbtnName2\u003e and input project info from file \u003cprojInfoPath\u003e for \u003ctestCase\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "Quit the driver",
  "keyword": "And "
});
formatter.examples({
  "line": 17,
  "name": "",
  "description": "",
  "id": "create-new-account;create-new-accounts;",
  "rows": [
    {
      "cells": [
        "testCase",
        "env",
        "usr",
        "enterpriseId",
        "psw",
        "tgtPage",
        "groupId",
        "comName",
        "btnName1",
        "btnName2",
        "projInfoPath"
      ],
      "line": 18,
      "id": "create-new-account;create-new-accounts;;1"
    },
    {
      "cells": [
        "\"projCreation_001\"",
        "\"test9\"",
        "\"kentestgrp10\"",
        "\"\"",
        "\"12345678\"",
        "\"组织架构管理\"",
        "\"6\"",
        "\"飞骁公司\"",
        "\"进入编辑模式\"",
        "\"组织架构项目添加\"",
        "\"src/main/resources/TestData/ProjectInfo/projectInfo2.csv\""
      ],
      "line": 19,
      "id": "create-new-account;create-new-accounts;;2"
    },
    {
      "cells": [
        "\"projCreation_001\"",
        "\"test9\"",
        "\"kentestgrp10\"",
        "\"\"",
        "\"12345678\"",
        "\"组织架构管理\"",
        "\"6\"",
        "\"K1公司\"",
        "\"进入编辑模式\"",
        "\"组织架构项目添加\"",
        "\"src/main/resources/TestData/ProjectInfo/projectInfo3.csv\""
      ],
      "line": 20,
      "id": "create-new-account;create-new-accounts;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 138100,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Create new accounts",
  "description": "",
  "id": "create-new-account;create-new-accounts;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@GUI"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I am testing in \"test9\" for \"projCreation_001\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I login with \"\" by \"kentestgrp10\" and \"12345678\" for \"projCreation_001\"",
  "matchedColumns": [
    0,
    2,
    3,
    4
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I wait for \"3\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I go to \"组织架构管理\" page for \"6\" for \"projCreation_001\"",
  "matchedColumns": [
    0,
    5,
    6
  ],
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I wait for \"3\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I click the link in organization management page for \"飞骁公司\" for \"projCreation_001\"",
  "matchedColumns": [
    0,
    7
  ],
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I wait for \"8\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I click the link for \"进入编辑模式\" for \"projCreation_001\"",
  "matchedColumns": [
    0,
    8
  ],
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I click the link for \"组织架构项目添加\" and input project info from file \"src/main/resources/TestData/ProjectInfo/projectInfo2.csv\" for \"projCreation_001\"",
  "matchedColumns": [
    0,
    9,
    10
  ],
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "Quit the driver",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "test9",
      "offset": 17
    },
    {
      "val": "projCreation_001",
      "offset": 29
    }
  ],
  "location": "PageOperations.i_am_testing_in_for(String,String)"
});
formatter.result({
  "duration": 4164795500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 14
    },
    {
      "val": "kentestgrp10",
      "offset": 20
    },
    {
      "val": "12345678",
      "offset": 39
    },
    {
      "val": "projCreation_001",
      "offset": 54
    }
  ],
  "location": "PageOperations.i_login_with_by_and_for(String,String,String,String)"
});
formatter.result({
  "duration": 2056058499,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 12
    }
  ],
  "location": "ShareSteps.i_wait_for_seconds(String)"
});
formatter.result({
  "duration": 3000727600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "组织架构管理",
      "offset": 9
    },
    {
      "val": "6",
      "offset": 27
    },
    {
      "val": "projCreation_001",
      "offset": 35
    }
  ],
  "location": "PageOperations.i_go_to_page_for_for(String,String,String)"
});
formatter.result({
  "duration": 251458701,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 12
    }
  ],
  "location": "ShareSteps.i_wait_for_seconds(String)"
});
formatter.result({
  "duration": 3000624100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "飞骁公司",
      "offset": 54
    },
    {
      "val": "projCreation_001",
      "offset": 65
    }
  ],
  "location": "PageOperations.i_click_the_link_in_organization_management_page_for_for(String,String)"
});
