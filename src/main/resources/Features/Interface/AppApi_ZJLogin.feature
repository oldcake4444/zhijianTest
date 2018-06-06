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
@AppApi
Feature: App login API test for different envs

  @AppApi
  Scenario Outline: Test for app login api
    Given I call the "login" api of <env> with <psw> and <usr>in <apiParameters> for <testCase>
    Then Verify the calling is successful with "登录成功" for <testCase>
    And Verify the return message is expected as <expValueList> in <returnMsgFieldList> for <testCase>

    Examples: 
      | testCase          | env         | usr           | psw        | apiParameters                 | expValueList                      | returnMsgFieldList                 |
      | "appapilogin_001" | "prodEnv"   | "kentest40"   | "12345678" | "device_id;password;username" | "115430;肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆;kentest40;0" | "id;real_name;user_name;delete_at" |
      | "appapilogin_002" | "longhuEnv" | "kentestchk1" | "12345678" | "device_id;password;username" | "2;坚龙湖检查人;kentestchk1;0"          | "id;real_name;user_name;delete_at" |
      | "appapilogin_003" | "zlEnv"     | "kentest10"   | "12345678" | "device_id;password;username" | "11448;kentest10;kentest10;0"     | "id;real_name;user_name;delete_at" |
      | "appapilogin_004" | "gzbEnv"    | "kentest10"   | "12345678" | "device_id;password;username" | "189;坚葛洲坝检查人;kentest10;0"         | "id;real_name;user_name;delete_at" |
