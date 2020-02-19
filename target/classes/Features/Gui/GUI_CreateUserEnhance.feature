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
    When I create accounts from file <grpUsrInfoPath> in <env> for <testCase>
    When I call the login api for the <grpUsrInfoPath> with <apiParameters> for <testCase>
    Then Verify the response of the login api is the same as <grpUsrInfoPath> for <testCase>
    And I click usr management link for <comName> for <testCase>
    And I wait for "2" seconds
    When I create accounts from file <comUsrInfoPath> in <env> for <testCase>
    And Quit the driver
    When I call the login api for the <comUsrInfoPath> with <apiParameters> for <testCase>
    Then Verify the response of the login api is the same as <comUsrInfoPath> for <testCase>

    Examples: 
      | testCase          | env          | usr         | enterpriseId | psw        | tgtPage    | groupId | grpName  | comName | projName | grpUsrInfoPath                                                  | comUsrInfoPath                                                  | keyWord   | role  | apiParameters                            |
      | "usrCreation_001" | "regression" | "liuling60" | "ll"         | "12345678" | "人员管理集团页面" | "41"    | "60test" | "公司1"   | "公司1项目1" | "src/main/resources/TestData/AcntInfo/grpAcntCreationInfo1.csv" | "src/main/resources/TestData/AcntInfo/comAcntCreationInfo1.csv" | "liuling" | "检查人" | "device_id;password;username;group_code" |
