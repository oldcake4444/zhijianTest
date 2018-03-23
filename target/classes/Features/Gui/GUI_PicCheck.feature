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
@wip
Feature: Verify whether the pictures can be shown in GUI

  @wip
  Scenario Outline: To Verify whether the pictures and floor plans can be shown in GUI
    Given I login <env> by <usr> and <psw>
    And I wait for "2" seconds
    #And I navigate to <menu> of <module>
    #And I search <issueId> in the issue list
    #And I open the details of issue <issueId>
    #When I click the floor plan for the issue
    #And I wait for "2" seconds
    #Then Capture the current page and save it as <fileName1>
    #Then I verify the picture can be shown
    #And I close the pop up windown
    #When I click the picture for the issue
    #And I wait for "2" seconds
    #Then Capture the current page and save it as <fileName2>
    #Then I vefity the picture can be shown
    #And I close the pop up window
    #And I logout the system
    And Quit the driver

    Examples: 
      | testCase        | env    | usr            | psw        | menu   | module | issueId  | fileName1          | fileName2          |
      | "guiPicVer_001" | "prod" | "kentestgrp10" | "12345678" | "问题列表" | "工程检查" | "723783" | "guiPicVer_001_01" | "guiPicVer_001_02" |
      | "guiPicVer_002" | "longhu" | "zhijianjituan" | "zhijian123" | "问题列表" | "工程检查" | "723783" | "guiPicVer_002_01" | "guiPicVer_002_02" |
