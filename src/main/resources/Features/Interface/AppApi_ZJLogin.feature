@AppApiTest
Feature: App login API test for different envs

  @AppApi
  Scenario Outline: Test for app login api
    Given I call the "login" api of <env> with <usr> and <psw> in <apiParameters> for <testCase>
    Then Verify the calling is successful with "登录成功" for <testCase>
    And Verify the return message is expected as <expValueList> in <returnMsgFieldList> for <testCase>

    Examples:
      | testCase          | env         | usr           | psw        | apiParameters                 | expValueList                      | returnMsgFieldList                 |
      | "appapilogin_001" | "prod"   | "kentest40"   | '12345678' | "device_id;password;username" | "115431;肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆肆;kentest40;0" | "id;real_name;user_name;delete_at" |
      #| "appapilogin_002" | "longhu" | "kentestchk1" | "12345678" | "device_id;password;username" | "2;坚龙湖检查人;kentestchk1;0"          | "id;real_name;user_name;delete_at" |
      #| "appapilogin_003" | "zl"     | "kentest10"   | "12345678" | "device_id;password;username" | "11448;kentest10;kentest10;0"     | "id;real_name;user_name;delete_at" |
      #| "appapilogin_004" | "gzb"    | "kentest10"   | "12345678" | "device_id;password;username" | "189;坚葛洲坝检查人;kentest10;0"         | "id;real_name;user_name;delete_at" |

