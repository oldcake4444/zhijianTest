$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Gui/GUI_ProRptH5.feature");
formatter.feature({
  "line": 2,
  "name": "Check export button can be found on the page",
  "description": "",
  "id": "check-export-button-can-be-found-on-the-page",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@gui"
    },
    {
      "line": 1,
      "name": "@houseProRpt"
    }
  ]
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Test for house professional report page",
  "description": "",
  "id": "check-export-button-can-be-found-on-the-page;test-for-house-professional-report-page",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@gui"
    },
    {
      "line": 4,
      "name": "@houseProRpt"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I call app login api of \u003cenv\u003e with \u003cusr\u003e and \u003cpsw\u003e for \u003cgroupCode\u003e for \u003ctestCase\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I open the house pofessional report page of \u003cgroupId\u003e and \u003cteamId\u003e and \u003cprojectId\u003e and \u003ctaskId\u003e and \u003chouseId\u003e for \u003ctestCase\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I wait for \"2\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I verify \u003cpageInfo\u003e can be found on the page and the summary contains \u003csummaryInfo\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "I click button \u003cfinishButton\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I verify button \u003cbutton1\u003e can be found on the page",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "I verify button \u003cbutton2\u003e can be found on the page",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "Quit the driver",
  "keyword": "And "
});
formatter.examples({
  "line": 15,
  "name": "",
  "description": "",
  "id": "check-export-button-can-be-found-on-the-page;test-for-house-professional-report-page;",
  "rows": [
    {
      "cells": [
        "testCase",
        "env",
        "usr",
        "psw",
        "groupCode",
        "groupId",
        "teamId",
        "projectId",
        "taskId",
        "houseId",
        "pageInfo",
        "summaryInfo",
        "finishButton",
        "button1",
        "button2"
      ],
      "line": 16,
      "id": "check-export-button-can-be-found-on-the-page;test-for-house-professional-report-page;;1"
    },
    {
      "cells": [
        "\"guiHouseProRpt_001\"",
        "\"prod\"",
        "\"kenjjyftest1\"",
        "\"12345678\"",
        "\"jjyf\"",
        "\"171319\"",
        "\"171322\"",
        "\"142639\"",
        "\"9064300\"",
        "\"67679751\"",
        "\"汇总分析\"",
        "\"本次查验共发现隐患66条\"",
        "\"完成查验\"",
        "\"按检查项下载\"",
        "\"按区域下载\""
      ],
      "line": 17,
      "id": "check-export-button-can-be-found-on-the-page;test-for-house-professional-report-page;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 113400,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Test for house professional report page",
  "description": "",
  "id": "check-export-button-can-be-found-on-the-page;test-for-house-professional-report-page;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@houseProRpt"
    },
    {
      "line": 1,
      "name": "@gui"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I call app login api of \"prod\" with \"kenjjyftest1\" and \"12345678\" for \"jjyf\" for \"guiHouseProRpt_001\"",
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
  "name": "I open the house pofessional report page of \"171319\" and \"171322\" and \"142639\" and \"9064300\" and \"67679751\" for \"guiHouseProRpt_001\"",
  "matchedColumns": [
    0,
    5,
    6,
    7,
    8,
    9
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I wait for \"2\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I verify \"汇总分析\" can be found on the page and the summary contains \"本次查验共发现隐患66条\"",
  "matchedColumns": [
    10,
    11
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "I click button \"完成查验\"",
  "matchedColumns": [
    12
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I verify button \"按检查项下载\" can be found on the page",
  "matchedColumns": [
    13
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "I verify button \"按区域下载\" can be found on the page",
  "matchedColumns": [
    14
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "Quit the driver",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "prod",
      "offset": 25
    },
    {
      "val": "kenjjyftest1",
      "offset": 37
    },
    {
      "val": "12345678",
      "offset": 56
    },
    {
      "val": "jjyf",
      "offset": 71
    },
    {
      "val": "guiHouseProRpt_001",
      "offset": 82
    }
  ],
  "location": "AppApiTest.i_call_app_login_api_of_with_and_for_for(String,String,String,String,String)"
});
formatter.result({
  "duration": 127923100,
  "error_message": "java.lang.NullPointerException\r\n\tat java.io.Reader.\u003cinit\u003e(Unknown Source)\r\n\tat java.io.InputStreamReader.\u003cinit\u003e(Unknown Source)\r\n\tat com.test.Util.GetConfigProperties.getValue(GetConfigProperties.java:26)\r\n\tat com.test.InterfaceTest.Interface.AppApiTest.i_call_app_login_api_of_with_and_for_for(AppApiTest.java:433)\r\n\tat ✽.Given I call app login api of \"prod\" with \"kenjjyftest1\" and \"12345678\" for \"jjyf\" for \"guiHouseProRpt_001\"(Gui/GUI_ProRptH5.feature:6)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "171319",
      "offset": 45
    },
    {
      "val": "171322",
      "offset": 58
    },
    {
      "val": "142639",
      "offset": 71
    },
    {
      "val": "9064300",
      "offset": 84
    },
    {
      "val": "67679751",
      "offset": 98
    },
    {
      "val": "guiHouseProRpt_001",
      "offset": 113
    }
  ],
  "location": "PageOperations.i_open_the_house_pofessional_report_page_of_and_and_and_and_for(String,String,String,String,String,String)"
});
formatter.result({
  "status": "skipped"
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
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "汇总分析",
      "offset": 10
    },
    {
      "val": "本次查验共发现隐患66条",
      "offset": 67
    }
  ],
  "location": "PageOperations.i_verify_can_be_found_on_the_page_and_the_summary_contains(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "完成查验",
      "offset": 16
    }
  ],
  "location": "PageOperations.i_click_button(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "按检查项下载",
      "offset": 17
    }
  ],
  "location": "PageOperations.i_verify_button_can_be_found_on_the_page(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "按区域下载",
      "offset": 17
    }
  ],
  "location": "PageOperations.i_verify_button_can_be_found_on_the_page(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PageOperations.quit_the_driver()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 3337943000,
  "status": "passed"
});
});