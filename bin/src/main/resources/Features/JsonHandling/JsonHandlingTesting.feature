@JsonHandling
Feature: Sample test for Json handling

  @JsonHandling
  Scenario Outline: Test for Json count
    Given I call the group project list api for <testCase>
    Then Verify the count from the return json for <testCase>

    Examples: 
      | testCase          |
      | "JsonHandling001" |
