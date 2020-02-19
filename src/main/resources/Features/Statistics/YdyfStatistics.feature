@statistic
Feature: statistics test for ydyf

  @statistic @ydyfSta
  Scenario Outline: Test for ydyf statistics of project front page
    Given I login with <userName> and <password> for <groupCode> of <env> by calling web login interface for <testCase>
    And I call <module> module issue percentage stat api of <projectId> of <teamId> of <grpId> in <env> for <testCase>

    Examples: 
      | testCase         | userName       | password   | groupCode | env    | module | projectId | teamId   | grpId    |
      | "yfFrontPage001" | "kentestgrp10" | "12345678" | ""        | "prod" | "26"   | "100756"  | "100547" | "100546" |
