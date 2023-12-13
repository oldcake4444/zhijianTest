@interface
Feature: Sample test for http interface test

  @interface
  Scenario Outline: Test for the http interface
  Given I test call the interface <whetherRptInterfacce> for city <cityCode> for <testCase>
  Then Verify city <city> <cityCode> can be found in the return message for <testCase>
  
  Examples:
  | testCase       | whetherRptInterfacce | cityCode    | city |
  | "Interface001" | "DailyWeather"       | "101010100" | "北京" |
  | "Interface002" | "DailyWeather"       | "101280101" | "广州" |
  | "Interface003" | "DailyWeather"       | "101281701" | "中山" |
  | "Interface004" | "DailyWeather"       | "101250700" | "益阳" |
  | "Interface005" | "DailyWeather"       | "101040100" | "重庆" |
  #@interface
  #Scenario Outline: Test for the http interface
    #Given I call the interface <privateCloudInterface> for <testCase>
#
    #Then Verify city <city> <cityCode> can be found in the return message for <testCase>
    #Examples: 
      #| testCase       | privateCloudInterface |
      #| "Interface001" | "PrivateCloud"        |
