@GUI
Feature: Create new account

  @GUI
  Scenario Outline: Create new accounts
    Given I am testing in <env> for <testCase>
    When I login with <enterpriseId> by <usr> and <psw> for <testCase>
    And I wait for "3" seconds
    And I go to <tgtPage> page for <groupId> for <testCase>
    And I wait for "3" seconds
    And I click the link in organization management page for <comName> for <testCase>
    And I wait for "8" seconds
    And I click the link for <btnName1> for <testCase>
    And I click the link for <btnName2> and input project info from file <projInfoPath> for <testCase>
    And Quit the driver

    Examples: 
      | testCase           | env     | usr            | enterpriseId | psw        | tgtPage  | groupId | comName | btnName1 | btnName2   | projInfoPath                                               |
      | "projCreation_001" | "test9" | "kentestgrp10" | ""           | "12345678" | "组织架构管理" | "6"     | "飞骁公司" | "进入编辑模式" | "组织架构项目添加" | "src/main/resources/TestData/ProjectInfo/projectInfo2.csv" |
      | "projCreation_001" | "test9" | "kentestgrp10" | ""           | "12345678" | "组织架构管理" | "6"     | "K1公司" | "进入编辑模式" | "组织架构项目添加" | "src/main/resources/TestData/ProjectInfo/projectInfo3.csv" |
