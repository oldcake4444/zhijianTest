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
Feature: GUI Login test for different envs

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
    Then Capture the current page and save it as <fileName>
    #Then I verify <userRealName> can be found in <curUserXPath>
    #And I click menu <menuXPath>
    #And I wait for "1" seconds
    #Then I click menu <logoutXPath>
    And I wait for "2" seconds
    And Quit the driver

    Examples: 
      | testCase       | url      | expTitle          | userName       | password          | userNameXPath      | passwordXPath     | loginButtonXPath | userRealName   | curUserXPath      | fileName       | menuXPath            | logoutXPath  |
      | "guiLogin_001" | "prod"   | "\| 中国首个工程管理协作平台" | "kentestgrp10" | "12345678"        | "prodUsrNameXPath" | "prodUsrPswXPath" | "prodLoginBtn"   | "kentestgrp10" | "prodCurUsrXPath" | "guiLogin_001" | "prodCurUsrDropDown" | "prodLogout" |
      #| "guiLogin_002" | "longhu" | "龙湖集团 - 龙建"       | "longhu"       | "longhu2018"      | "lhUsrNameXPath"   | "lhUsrPswXPath"   | "lhLoginBtn"     | "龙湖集团管理员"      | "prodCurUsrXPath" | "guiLogin_002" | "prodCurUsrDropDown" | "prodLogout" |
      #| "guiLogin_003" | "zl"     | "中梁控股集团"          | "zhongliang"   | "zhongliang***" | "zlUsrNameXPath"   | "zlUsrPswXPath"   | "zlLoginBtn"     | "中梁"           | "zlCurUsrXPath"   | "guiLogin_003" | "zlCurUsrDropDown"   | "prodLogout" |
      #| "guiLogin_004" | "gzb"    | "葛洲坝地产"           | "gzb"          | "gzb@2018"        | "gzbUsrNameXPath"  | "gzbUsrPswXPath"  | "gzbLoginBtn"    | "地产总部管理员"      | "prodCurUsrXPath" | "guiLogin_004" | "prodCurUsrDropDown" | "prodLogout" |
