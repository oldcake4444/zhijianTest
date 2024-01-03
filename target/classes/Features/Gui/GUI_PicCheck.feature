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
Feature: Verify whether the pictures can be shown in GUI

  @gui
  Scenario Outline: To Verify whether the pictures and floor plans can be shown in GUI
    Given I login <env> by <usr> and <psw>
    And I navigate to <tgtPage>
    And I wait for "2" seconds
    #And I search <issueId> in the issue list
    #And I open the details of issue <issueId>
    #And I wait for "1" seconds
    #When I click the floor plan for the issue
    #And I wait for "1" seconds
    #Then Capture the current page and save it as <fileName1>
    #Then I verify the floorplan can be shown
    #And I close the pop up window
    #And I wait for "1" seconds
    #When I click the picture for the issue
    #And I wait for "1" seconds
    #Then Capture the current page and save it as <fileName2>
    #Then I vefity the picture can be shown
    #And I close the pop up picture
    Then I search <issueId> verify whether floor plan and desc pic can be shown in issue content and capture the screen shots as <fileName1> and <fileName2>
    And I wait for "1" seconds
    And I logout the system for <env>
    And Quit the driver

    Examples: 
      | testCase        | env      | usr            | psw          | tgtPage      | issueId                                                                 | fileName1                      | fileName2                      |
      | "guiPicVer_001" | "prod"   | "kentestgrp10" | "12345678"   | "生产工程检查问题列表" | "723783;737122;723918;734938;726353;723919;735878;737121;723921;737113" | "prodGuiPicVer_001_01_issueId" | "prodGuiPicVer_001_02_issueId" |
      | "guiPicVer_002" | "longhu" | "longhu"       | "longhu2018" | "龙湖工程检查问题列表" | "800706;35;247;256;989;987;771864;771847;767479;767484"                 | "lhGuiPicVer_002_01_issueId"   | "lhGuiPicVer_002_02_issueId"   |
      | "guiPicVer_003" | "gzb"    | "gzb"          | "gzb@2018"   | "葛洲坝问题列表"    | "1055;809;27;32;74;71;123;163;426;439"                                  | "gzbGuiPicVer_003_01_issueId"  | "gzbGuiPicVer_003_02_issueId"  |
