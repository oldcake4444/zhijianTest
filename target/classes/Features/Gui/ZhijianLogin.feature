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
@gui
Feature: Login test for different envs

  @gui
  Scenario Outline: Test for login
    Given I open URL <url>
    And I wait for "1" seconds
    When I Get the title of the website for test case <testCase>
    Then Verify the title value is correct as expected <expTitle> for test case <testCase>
    And I input <userName> into <userNameXPath>
    And I input <password> into <passwordXPath>
    When I click button <loginButtonXPath>
    And I wait for "2" seconds
    Then I verify <userRealName> can be found in <curUserXPath>
    Then Capture the current page and save it as <fileName>
    And I click menu <menuXPath>
    And I wait for "1" seconds
    Then I click menu <logoutXPath>
    And I wait for "1" seconds
    And Quit the driver

    Examples: 
      | testCase | url      | expTitle          | userName     | password          | userNameXPath      | passwordXPath     | loginButtonXPath | userRealName | curUserXPath      | fileName            | menuXPath            | logoutXPath  |
      | "001"    | "prod"   | "智检 - 工程现场管理协作平台" | "zhijianjt"  | "zhijian2017"     | "prodUsrNameXPath" | "prodUsrPswXPath" | "prodLoginBtn"   | "智检管理员"      | "prodCurUsrXPath" | "zhijian_login_001" | "prodCurUsrDropDown" | "prodLogout" |
      | "002"    | "longhu" | "龙湖集团 - 龙建"       | "longhu"     | "longhu2018"      | "lhUsrNameXPath"   | "lhUsrPswXPath"   | "lhLoginBtn"     | "龙湖集团管理员"    | "prodCurUsrXPath" | "zhijian_login_002" | "prodCurUsrDropDown" | "prodLogout" |
      | "003"    | "zl"     | "中梁控股集团"          | "zhongliang" | "zhongliang@2018" | "zlUsrNameXPath"   | "zlUsrPswXPath"   | "zlLoginBtn"     | "中梁"         | "prodCurUsrXPath" | "zhijian_login_003" | "prodCurUsrDropDown" | "prodLogout" |
      | "004"    | "gzb"    | "中国能建"            | "gzb"        | "gzb@2018"        | "gzbUsrNameXPath"  | "gzbUsrPswXPath"  | "gzbLoginBtn"    | "葛洲坝总部管理员"   | "prodCurUsrXPath" | "zhijian_login_004" | "prodCurUsrDropDown" | "prodLogout" |
