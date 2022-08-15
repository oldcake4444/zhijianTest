@AppApi
Feature: App login API test for different envs

  @AppApi
  Scenario Outline: Test for app login api
    Given I call the "login" api of <env> with <psw> and <usr>in <apiParameters> for <testCase>
    Then Verify the calling is successful with "登录成功" for <testCase>
    When I call the GetUsrOrg api of <env> for <testCase>
    Then Verify the related product list is expected as <expProductInfoPath> for <testCase>
    And Verify the related group info is expected as <expGrpInfo> for <testCase>
    And Verify the related company info is expected as <expComInfoPath> for <testCase>
    And Verify the related project info is expected as <expProjInfoPath> for <testCase>
    And Verify the follow app info is expected as <expFollowApps> for <testCase>

    Examples: 
      | testCase            | env    | usr         | psw        | apiParameters                 | expProductInfoPath                                                 | expGrpInfo | expComInfoPath | expProjInfoPath | expFollowApps |
      | "UsrRelatedInfo001" | "prod" | "kentest46" | "12345678" | "device_id;password;username" | "src/main/resources/TestData/relatedAppInfo/appInfo_kentest46.csv" | ""         | ""             | ""              | ""            |
