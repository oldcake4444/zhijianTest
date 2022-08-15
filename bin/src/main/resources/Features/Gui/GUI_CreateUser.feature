@GUI
Feature: Create new account

  @GUI
  Scenario Outline: Create new accounts
    Given I am testing in <env> for <testCase>
    When I login with <enterpriseId> by <usr> and <psw> for <testCase>
    And I wait for "3" seconds
    And I go to <tgtPage> page for <groupId> for <testCase>
    And I wait for "3" seconds
    And I click usr management link for <grpName> for <testCase>
    When I input <usrInfo1> to create <usrCount> new accounts in <env> for <testCase>
    When I call the login api of <env> for the <usrCount> new users with <apiParameters> for <testCase>
    Then Verify the <usrCount> callings in <env> are successful with "登录成功" and equal to <usrInfo1> for <testCase>
    And I click usr management link for <comName> for <testCase>
    And I wait for "2" seconds
    When I input <usrInfo2> to create <usrCount> new accounts in <env> for <testCase>
    When I call the login api of <env> for the <usrCount> new users with <apiParameters> for <testCase>
    Then Verify the <usrCount> callings in <env> are successful with "登录成功" and equal to <usrInfo1> for <testCase>
    When I expand the project list of <comName> in usr management page for <testCase>
    And I click usr management link for <projName> for <testCase>
    And I wait for "1" seconds
    When I click the link for "人员管理新增人员" for <testCase>
    And I search <keyWord> and add accounts to project as <role> for <testCase>
    And I wait for "2" seconds
    And Quit the driver
    And I call the teams and projects api in <env> to verify the <usrCount> new users are in <grpName> and <comName> and <projName> for <testCase>
    
    Examples: 
      | testCase          | env          | usr         | enterpriseId | psw        | tgtPage    | groupId  | grpName | comName | projName | usrInfo1                                                             | usrInfo2                                                                   | keyWord   | role  | apiParameters                              | usrCount |
      #| "usrCreation_001" | "prod" | "kentestgrp11" |""| "12345678" | "人员管理集团页面" | "坚11集团" |""| "坚1公司"  | "坚1项目"   | "acntName,psw,realName,13800138000,automation@zhijiancloud.com,集团员工" | "acntName,12345678,realName,13800138000,automation@zhijiancloud.com,公司管理员" | "autotest" | "检查人" |"device_id;password;username;enterpriseId"|"2"|
      | "usrCreation_001" | "regression" | "liuling60" | "ll"         | "12345678" | "人员管理集团页面" | "41" | "60test"    | "公司1"  | "公司1项目1"   | "acntName,psw,realName,13800138000,automation@zhijiancloud.com,集团员工" | "acntName,12345678,realName,13800138000,automation@zhijiancloud.com,公司管理员" | "liuling" | "检查人" | "device_id;password;username;group_code" | "1"     |
