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
@Practice
Feature: This is my first feature file that is for testing only

  @Practice
  Scenario Outline: Test for a login function
    Given I open URL <url>
    When I Get the title of the website for test case <testCase>
    #And I wait for "2" seconds
    Then Verify the title value is correct as expected <expTitle> for test case <testCase>
    And Verify whether the <btnName> button can be found in the page
    When I input <searchCondition> into <textFieldXPath>
    And I wait for "2" seconds
    And I click button <buttonXPath>
    And I wait for "2" seconds
    Then Capture the current page and save it as <fileName>
    And Quit the driver

    Examples: 
      | testCase | url     | expTitle    | btnName           | fileName                  | searchCondition | textFieldXPath                     | buttonXPath                              |
      | "001"    | "baidu" | "百度一下，你就知道" | "FrontPageSearch" | "baidu_001_sreenshot.jpg" | "测试"            | "//input[@id='kw' and @name='wd']" | "//input[@type='submit' and @id = 'su']" |
