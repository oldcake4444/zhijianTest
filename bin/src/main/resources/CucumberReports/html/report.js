$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Interface/WeatherReportInterface.feature");
formatter.feature({
  "line": 2,
  "name": "Sample test for interface test",
  "description": "",
  "id": "sample-test-for-interface-test",
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
  "name": "Test for the interface from whether report",
  "description": "",
  "id": "sample-test-for-interface-test;test-for-the-interface-from-whether-report",
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
  "id": "sample-test-for-interface-test;test-for-the-interface-from-whether-report;",
  "rows": [
    {
      "cells": [
        "testCase",
        "whetherRptInterfacce",
        "cityCode",
        "city"
      ],
      "line": 10,
      "id": "sample-test-for-interface-test;test-for-the-interface-from-whether-report;;1"
    },
    {
      "cells": [
        "\"Interface001\"",
        "\"DailyWeather\"",
        "\"101010100\"",
        "\"北京\""
      ],
      "line": 11,
      "id": "sample-test-for-interface-test;test-for-the-interface-from-whether-report;;2"
    },
    {
      "cells": [
        "\"Interface002\"",
        "\"DailyWeather\"",
        "\"101280101\"",
        "\"广州\""
      ],
      "line": 12,
      "id": "sample-test-for-interface-test;test-for-the-interface-from-whether-report;;3"
    },
    {
      "cells": [
        "\"Interface003\"",
        "\"DailyWeather\"",
        "\"101281701\"",
        "\"中山\""
      ],
      "line": 13,
      "id": "sample-test-for-interface-test;test-for-the-interface-from-whether-report;;4"
    },
    {
      "cells": [
        "\"Interface004\"",
        "\"DailyWeather\"",
        "\"101250700\"",
        "\"益阳\""
      ],
      "line": 14,
      "id": "sample-test-for-interface-test;test-for-the-interface-from-whether-report;;5"
    },
    {
      "cells": [
        "\"Interface005\"",
        "\"DailyWeather\"",
        "\"101040100\"",
        "\"重庆\""
      ],
      "line": 15,
      "id": "sample-test-for-interface-test;test-for-the-interface-from-whether-report;;6"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 199714,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Test for the interface from whether report",
  "description": "",
  "id": "sample-test-for-interface-test;test-for-the-interface-from-whether-report;;2",
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
  "duration": 702966367,
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
  "duration": 71202404,
  "status": "passed"
});
formatter.before({
  "duration": 74411,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Test for the interface from whether report",
  "description": "",
  "id": "sample-test-for-interface-test;test-for-the-interface-from-whether-report;;3",
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
  "duration": 68280256,
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
  "duration": 565356,
  "status": "passed"
});
formatter.before({
  "duration": 147113,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Test for the interface from whether report",
  "description": "",
  "id": "sample-test-for-interface-test;test-for-the-interface-from-whether-report;;4",
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
  "duration": 82571969,
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
  "duration": 697073,
  "status": "passed"
});
formatter.before({
  "duration": 182180,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Test for the interface from whether report",
  "description": "",
  "id": "sample-test-for-interface-test;test-for-the-interface-from-whether-report;;5",
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
  "duration": 143587267,
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
  "duration": 1016957,
  "status": "passed"
});
formatter.before({
  "duration": 289948,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Test for the interface from whether report",
  "description": "",
  "id": "sample-test-for-interface-test;test-for-the-interface-from-whether-report;;6",
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
  "duration": 48166483,
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
  "duration": 530717,
  "status": "passed"
});
});