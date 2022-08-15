#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@gui @sta
Feature: Verify whether statistics data can be found from frontend

  @gui @sta @grp
  Scenario Outline: Verify the group statistics data
    Given I login <env> by <usr> and <psw>
    And I wait for "8" seconds
    And I navigate to group statistics page of "gcjc" of "lh" env from front page
    And I wait for "3" seconds
    Then I verify non null "工程百平米总问题数" can be found in the page and the value is larger than zero
    And I verify non null "及时整改完结率" can be found in the page and the value is larger than zero
    And I verify non null "整改完结率" can be found in the page and the value is larger than zero
    Then I verify the group overall statistics data for "3" days can be found for gcjc
    Then Capture the current page and save it as <fileName1>
    And I navigate to group statistics page of "gxgl" of "lh" env from group statistics page
    And I wait for "5" seconds
    Then I verify non null "工序一次验收合格率" can be found in the page and the value is larger than zero
    And I verify non null "及时整改完结率" can be found in the page and the value is larger than zero
    And I verify non null "整改完结率" can be found in the page and the value is larger than zero
    Then I verify the group overall statistics data for "3" days can be found for gxgl
    Then Capture the current page and save it as <fileName2>
    And I navigate to group statistics page of "scsl" of "lh" env from group statistics page
    And I wait for "5" seconds
    Then I verify non null "实测合格率" can be found in the page and the value is larger than zero
    And I verify non null "及时整改完结率" can be found in the page and the value is larger than zero
    And I verify non null "整改完结率" can be found in the page and the value is larger than zero
    Then I verify the group overall statistics data for "3" days can be found for scsl
    Then Capture the current page and save it as <fileName3>
    And Quit the driver

    Examples: 
      | testCase         | env      | usr            | psw          | tgtPage       | fileName1                | fileName2                | fileName3                |
      #| "staGrpChek_001" | "prod"   | "kentestgrp10" | "12345678"   | "生产工程检查集团统计"  | "staGrpChek_001_01_gcjc" | "staGrpChek_001_02_gxgl" | "staGrpChek_001_03_scsl" |
      | "staGrpChek_002" | "longhu" | "longhu"       | "longhu2018" | "龙湖工程检查集团统计"  | "staGrpChek_002_01_gcjc" | "staGrpChek_002_02_gxgl" | "staGrpChek_002_03_scsl" |
      #| "staGrpChek_003" | "gzb"    | "gzb"          | "gzb@2018"   | "葛洲坝工程检查集团统计" | "staGrpChek_003_01_gcjc" | "staGrpChek_003_02_gxgl" | "staGrpChek_003_03_scsl" |
