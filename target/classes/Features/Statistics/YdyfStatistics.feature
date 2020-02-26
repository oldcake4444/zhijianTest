@statistic
Feature: statistics test for ydyf

  @statistic @ydyfSta
  Scenario Outline: Test for ydyf statistics of project front page
    Given I login with <userName> and <password> for <groupCode> of <env> by calling web login interface for <testCase>
    And I call <module> module issue percentage stat api of <projectId> of <teamId> of <grpId> in <env> for <testCase>
    Then I verify the return of module issue percentage stat api is the same as the <querySetPath> in <env> for <testCase>

    Examples: 
      | testCase         | userName       | password   | groupCode | env    | module | projectId | teamId   | grpId    | querySetPath                                                                                                                                                                                                                              |
      | "yfFrontPage001" | "kentestgrp10" | "12345678" | ""        | "prod" | "26"   | "100756"  | "100547" | "100546" | "src/main/resources/TestData/DbQuery/yfFrontPage001/query1;src/main/resources/TestData/DbQuery/yfFrontPage001/query2;src/main/resources/TestData/DbQuery/yfFrontPage001/query3;src/main/resources/TestData/DbQuery/yfFrontPage001/query4" |
