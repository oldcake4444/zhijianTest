$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Gui/BaiduSearchTest.feature");
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
  "name": "This is my first feature file that is for testing only",
  "description": "",
  "id": "this-is-my-first-feature-file-that-is-for-testing-only",
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
  "name": "Test for a login function",
  "description": "",
  "id": "this-is-my-first-feature-file-that-is-for-testing-only;test-for-a-login-function",
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
  "name": "I Get the title of the website for test case \u003ctestCase\u003e",
  "keyword": "When "
});
formatter.step({
  "comments": [
    {
      "line": 26,
      "value": "#And I wait for \"2\" seconds"
    }
  ],
  "line": 27,
  "name": "Verify the title value is correct as expected \u003cexpTitle\u003e for test case \u003ctestCase\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "Verify whether the \u003cbtnName\u003e button can be found in the page",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "I input \u003csearchCondition\u003e into \u003ctextFieldXPath\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "I wait for \"2\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "I click button \u003cbuttonXPath\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "I wait for \"2\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "Capture the current page and save it as \u003cfileName\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "Quit the driver",
  "keyword": "And "
});
formatter.examples({
  "line": 36,
  "name": "",
  "description": "",
  "id": "this-is-my-first-feature-file-that-is-for-testing-only;test-for-a-login-function;",
  "rows": [
    {
      "cells": [
        "testCase",
        "url",
        "expTitle",
        "btnName",
        "fileName",
        "searchCondition",
        "textFieldXPath",
        "buttonXPath"
      ],
      "line": 37,
      "id": "this-is-my-first-feature-file-that-is-for-testing-only;test-for-a-login-function;;1"
    },
    {
      "cells": [
        "\"001\"",
        "\"baidu.url\"",
        "\"百度一下，你就知道\"",
        "\"FrontPageSearch\"",
        "\"baidu_001_sreenshot.jpg\"",
        "\"test\"",
        "\"//input[@id\u003d\u0027kw\u0027 and @name\u003d\u0027wd\u0027]\"",
        "\"//input[@type\u003d\u0027submit\u0027 and @id \u003d \u0027su\u0027]\""
      ],
      "line": 38,
      "id": "this-is-my-first-feature-file-that-is-for-testing-only;test-for-a-login-function;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 482393,
  "status": "passed"
});
formatter.scenario({
  "line": 38,
  "name": "Test for a login function",
  "description": "",
  "id": "this-is-my-first-feature-file-that-is-for-testing-only;test-for-a-login-function;;2",
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
  "name": "I open URL \"baidu.url\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "I Get the title of the website for test case \"001\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "comments": [
    {
      "line": 26,
      "value": "#And I wait for \"2\" seconds"
    }
  ],
  "line": 27,
  "name": "Verify the title value is correct as expected \"百度一下，你就知道\" for test case \"001\"",
  "matchedColumns": [
    0,
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "Verify whether the \"FrontPageSearch\" button can be found in the page",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "I input \"test\" into \"//input[@id\u003d\u0027kw\u0027 and @name\u003d\u0027wd\u0027]\"",
  "matchedColumns": [
    5,
    6
  ],
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "I wait for \"2\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "I click button \"//input[@type\u003d\u0027submit\u0027 and @id \u003d \u0027su\u0027]\"",
  "matchedColumns": [
    7
  ],
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "I wait for \"2\" seconds",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "Capture the current page and save it as \"baidu_001_sreenshot.jpg\"",
  "matchedColumns": [
    4
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "Quit the driver",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "baidu.url",
      "offset": 12
    }
  ],
  "location": "Baidu.i_open_URL(String)"
});
formatter.result({
  "duration": 20963017433,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "001",
      "offset": 46
    }
  ],
  "location": "Baidu.i_Get_the_title_of_the_website_for_test_case(String)"
});
formatter.result({
  "duration": 20205744,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "百度一下，你就知道",
      "offset": 47
    },
    {
      "val": "001",
      "offset": 73
    }
  ],
  "location": "Baidu.verify_the_title_value_is_correct_as_expected_for_test_case(String,String)"
});
formatter.result({
  "duration": 4277384,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "FrontPageSearch",
      "offset": 20
    }
  ],
  "location": "Baidu.verify_whether_the_button_can_be_found_in_the_page(String)"
});
formatter.result({
  "duration": 519197125,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "test",
      "offset": 9
    },
    {
      "val": "//input[@id\u003d\u0027kw\u0027 and @name\u003d\u0027wd\u0027]",
      "offset": 21
    }
  ],
  "location": "Baidu.i_input_into(String,String)"
});
formatter.result({
  "duration": 4184976126,
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
  "duration": 2001596428,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "//input[@type\u003d\u0027submit\u0027 and @id \u003d \u0027su\u0027]",
      "offset": 16
    }
  ],
  "location": "Baidu.i_click_button(String)"
});
formatter.result({
  "duration": 3293623481,
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
  "duration": 2000405843,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "baidu_001_sreenshot.jpg",
      "offset": 41
    }
  ],
  "location": "Baidu.capture_the_current_page_and_save_it_as(String)"
});
formatter.result({
  "duration": 585794226,
  "status": "passed"
});
formatter.match({
  "location": "Baidu.quit_the_driver()"
});
formatter.result({
  "duration": 118181877,
  "status": "passed"
});
formatter.after({
  "duration": 206984,
  "status": "passed"
});
formatter.uri("Interface/HttpInterfaceTesting.feature");
formatter.feature({
  "line": 2,
  "name": "Sample test for http interface test",
  "description": "",
  "id": "sample-test-for-http-interface-test",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@interface"
    }
  ]
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Test for the http interface",
  "description": "",
  "id": "sample-test-for-http-interface-test;test-for-the-http-interface",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@interface"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I call the interface \u003cwhetherRptInterfacce\u003e for city \u003ccityCode\u003e for \u003ctestCase\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Verify city \u003ccity\u003e \u003ccityCode\u003e can be found in the return message for \u003ctestCase\u003e",
  "keyword": "Then "
});
formatter.examples({
  "line": 9,
  "name": "",
  "description": "",
  "id": "sample-test-for-http-interface-test;test-for-the-http-interface;",
  "rows": [
    {
      "cells": [
        "testCase",
        "whetherRptInterfacce",
        "cityCode",
        "city"
      ],
      "line": 10,
      "id": "sample-test-for-http-interface-test;test-for-the-http-interface;;1"
    },
    {
      "cells": [
        "\"Interface001\"",
        "\"DailyWeather\"",
        "\"101010100\"",
        "\"北京\""
      ],
      "line": 11,
      "id": "sample-test-for-http-interface-test;test-for-the-http-interface;;2"
    },
    {
      "cells": [
        "\"Interface002\"",
        "\"DailyWeather\"",
        "\"101280101\"",
        "\"广州\""
      ],
      "line": 12,
      "id": "sample-test-for-http-interface-test;test-for-the-http-interface;;3"
    },
    {
      "cells": [
        "\"Interface003\"",
        "\"DailyWeather\"",
        "\"101281701\"",
        "\"中山\""
      ],
      "line": 13,
      "id": "sample-test-for-http-interface-test;test-for-the-http-interface;;4"
    },
    {
      "cells": [
        "\"Interface004\"",
        "\"DailyWeather\"",
        "\"101250700\"",
        "\"益阳\""
      ],
      "line": 14,
      "id": "sample-test-for-http-interface-test;test-for-the-http-interface;;5"
    },
    {
      "cells": [
        "\"Interface005\"",
        "\"DailyWeather\"",
        "\"101040100\"",
        "\"重庆\""
      ],
      "line": 15,
      "id": "sample-test-for-http-interface-test;test-for-the-http-interface;;6"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 263862,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Test for the http interface",
  "description": "",
  "id": "sample-test-for-http-interface-test;test-for-the-http-interface;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@interface"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I call the interface \"DailyWeather\" for city \"101010100\" for \"Interface001\"",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Verify city \"北京\" \"101010100\" can be found in the return message for \"Interface001\"",
  "matchedColumns": [
    0,
    2,
    3
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "DailyWeather",
      "offset": 22
    },
    {
      "val": "101010100",
      "offset": 46
    },
    {
      "val": "Interface001",
      "offset": 62
    }
  ],
  "location": "InterfaceTest.i_call_the_interface_for_city_for(String,String,String)"
});
formatter.result({
  "duration": 152918410,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "北京",
      "offset": 13
    },
    {
      "val": "101010100",
      "offset": 18
    },
    {
      "val": "Interface001",
      "offset": 69
    }
  ],
  "location": "InterfaceTest.verify_city_can_be_found_in_the_return_message_for(String,String,String)"
});
formatter.result({
  "duration": 100187526,
  "status": "passed"
});
formatter.before({
  "duration": 75267,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Test for the http interface",
  "description": "",
  "id": "sample-test-for-http-interface-test;test-for-the-http-interface;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@interface"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I call the interface \"DailyWeather\" for city \"101280101\" for \"Interface002\"",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Verify city \"广州\" \"101280101\" can be found in the return message for \"Interface002\"",
  "matchedColumns": [
    0,
    2,
    3
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "DailyWeather",
      "offset": 22
    },
    {
      "val": "101280101",
      "offset": 46
    },
    {
      "val": "Interface002",
      "offset": 62
    }
  ],
  "location": "InterfaceTest.i_call_the_interface_for_city_for(String,String,String)"
});
formatter.result({
  "duration": 39703295,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "广州",
      "offset": 13
    },
    {
      "val": "101280101",
      "offset": 18
    },
    {
      "val": "Interface002",
      "offset": 69
    }
  ],
  "location": "InterfaceTest.verify_city_can_be_found_in_the_return_message_for(String,String,String)"
});
formatter.result({
  "duration": 803132,
  "status": "passed"
});
formatter.before({
  "duration": 95794,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Test for the http interface",
  "description": "",
  "id": "sample-test-for-http-interface-test;test-for-the-http-interface;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@interface"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I call the interface \"DailyWeather\" for city \"101281701\" for \"Interface003\"",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Verify city \"中山\" \"101281701\" can be found in the return message for \"Interface003\"",
  "matchedColumns": [
    0,
    2,
    3
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "DailyWeather",
      "offset": 22
    },
    {
      "val": "101281701",
      "offset": 46
    },
    {
      "val": "Interface003",
      "offset": 62
    }
  ],
  "location": "InterfaceTest.i_call_the_interface_for_city_for(String,String,String)"
});
formatter.result({
  "duration": 48295269,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "中山",
      "offset": 13
    },
    {
      "val": "101281701",
      "offset": 18
    },
    {
      "val": "Interface003",
      "offset": 69
    }
  ],
  "location": "InterfaceTest.verify_city_can_be_found_in_the_return_message_for(String,String,String)"
});
formatter.result({
  "duration": 344261,
  "status": "passed"
});
formatter.before({
  "duration": 104775,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Test for the http interface",
  "description": "",
  "id": "sample-test-for-http-interface-test;test-for-the-http-interface;;5",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@interface"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I call the interface \"DailyWeather\" for city \"101250700\" for \"Interface004\"",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Verify city \"益阳\" \"101250700\" can be found in the return message for \"Interface004\"",
  "matchedColumns": [
    0,
    2,
    3
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "DailyWeather",
      "offset": 22
    },
    {
      "val": "101250700",
      "offset": 46
    },
    {
      "val": "Interface004",
      "offset": 62
    }
  ],
  "location": "InterfaceTest.i_call_the_interface_for_city_for(String,String,String)"
});
formatter.result({
  "duration": 169289819,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "益阳",
      "offset": 13
    },
    {
      "val": "101250700",
      "offset": 18
    },
    {
      "val": "Interface004",
      "offset": 69
    }
  ],
  "location": "InterfaceTest.verify_city_can_be_found_in_the_return_message_for(String,String,String)"
});
formatter.result({
  "duration": 334425,
  "status": "passed"
});
formatter.before({
  "duration": 122736,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Test for the http interface",
  "description": "",
  "id": "sample-test-for-http-interface-test;test-for-the-http-interface;;6",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@interface"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I call the interface \"DailyWeather\" for city \"101040100\" for \"Interface005\"",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Verify city \"重庆\" \"101040100\" can be found in the return message for \"Interface005\"",
  "matchedColumns": [
    0,
    2,
    3
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "DailyWeather",
      "offset": 22
    },
    {
      "val": "101040100",
      "offset": 46
    },
    {
      "val": "Interface005",
      "offset": 62
    }
  ],
  "location": "InterfaceTest.i_call_the_interface_for_city_for(String,String,String)"
});
formatter.result({
  "duration": 35851853,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "重庆",
      "offset": 13
    },
    {
      "val": "101040100",
      "offset": 18
    },
    {
      "val": "Interface005",
      "offset": 69
    }
  ],
  "location": "InterfaceTest.verify_city_can_be_found_in_the_return_message_for(String,String,String)"
});
formatter.result({
  "duration": 273698,
  "status": "passed"
});
formatter.uri("Interface/WebServiceInterfaceTesting.feature");
formatter.feature({
  "line": 2,
  "name": "Sample test for webservice interface test",
  "description": "",
  "id": "sample-test-for-webservice-interface-test",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@interface"
    }
  ]
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Test for the webservice interface",
  "description": "",
  "id": "sample-test-for-webservice-interface-test;test-for-the-webservice-interface",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@interface"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I call the webservice interface \u003cWebServiceInterfacce\u003e for \u003ctestCase\u003e",
  "keyword": "Given "
});
formatter.examples({
  "line": 8,
  "name": "",
  "description": "",
  "id": "sample-test-for-webservice-interface-test;test-for-the-webservice-interface;",
  "rows": [
    {
      "cells": [
        "testCase",
        "WebServiceInterfacce"
      ],
      "line": 9,
      "id": "sample-test-for-webservice-interface-test;test-for-the-webservice-interface;;1"
    },
    {
      "cells": [
        "\"WebService_001\"",
        "\"WeatherWebService\""
      ],
      "line": 10,
      "id": "sample-test-for-webservice-interface-test;test-for-the-webservice-interface;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 98360,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Test for the webservice interface",
  "description": "",
  "id": "sample-test-for-webservice-interface-test;test-for-the-webservice-interface;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@interface"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I call the webservice interface \"WeatherWebService\" for \"WebService_001\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "WeatherWebService",
      "offset": 33
    },
    {
      "val": "WebService_001",
      "offset": 57
    }
  ],
  "location": "InterfaceTest.i_call_the_webservice_interface_for(String,String)"
});
formatter.result({
  "duration": 133000,
  "status": "passed"
});
});