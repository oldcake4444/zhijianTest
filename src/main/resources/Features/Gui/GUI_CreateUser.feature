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
@GUI
Feature: Create new account

  @GUI
  Scenario Outline: Create new accounts
    Given I login <env> by <usr> and <psw>
    And I go to <tgtPage> in <env> env
    And I wait for "3" seconds
    And I click usr management link for <grpName> in <env> env
    When I input <usrInfo1> to create <usrCount> new accounts in <env> env
    When I call the login api of <env> for the <usrCount> new users with <apiParameters> for <testCase>
    Then Verify the <usrCount> callings in <env> are successful with "登录成功" and equal to <usrInfo1> for <testCase>
    And I click usr management link for <comName> in <env> env
    And I wait for "2" seconds
    When I input <usrInfo2> to create <usrCount> new accounts in <env> env
    When I call the login api of <env> for the <usrCount> new users with <apiParameters> for <testCase>
    Then Verify the <usrCount> callings in <env> are successful with "登录成功" and equal to <usrInfo1> for <testCase>
    When I expand the project list of <comName> in usr management page in <env> env
    And I click usr management link for <projName> in <env> env
    And I wait for "1" seconds
    When I click the link for "新增人员" in <env> env
    And I search <keyWord> and add accounts to project as <role> in <env> env
    And I wait for "2" seconds
    And Quit the driver

    Examples: 
      | testCase          | env    | usr            | psw        | tgtPage        | grpName | comName | projName | usrInfo1                                                                  | usrInfo2                                                                   | keyWord       | role  |apiParameters|usrCount|
      | "usrCreation_001" | "prod" | "kentestgrp11" | "12345678" | "人员管理集团页面" | "坚11集团" | "坚1公司"  | "坚1项目"   | "acntName,psw,realName,13800138000,automation@zhijiancloud.com,集团员工" | "acntName,12345678,realName,13800138000,automation@zhijiancloud.com,公司管理员" | "kentestauto" | "检查人" |"device_id;password;username"|"2"|
      #| "usrCreation_001" | "test" | "kentestgrp11" | "12345678" | "人员管理集团页面" | "KEN坚集团拾壹" | "坚1公司"  | "坚1项目"   | "acntName,psw,realName,13800138000,automation@zhijiancloud.com,集团员工" | "acntName,12345678,realName,13800138000,automation@zhijiancloud.com,公司管理员" | "kentest" | "检查人" |"device_id;password;username"|"2"|
      