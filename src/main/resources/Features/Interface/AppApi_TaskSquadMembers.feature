@AppApi
Feature: Test for the interface to get squad members

  @AppApi
  Scenario Outline: To test the squad members are correct
    Given I call the "login" api of <env> with <psw> and <usr>in <apiParameters> for <testCase>
    When I call the GetSquadMembers api of <env> of <taskId> for <testCase>
    Then I verify the squad members of <taskId> are correct as <squadInfoPath> for <testCase> of <env>

    Examples: 
      | testCase           | env    | usr            | psw        | taskId    | squadInfoPath                                        | apiParameters                 |
      | "squadMembers_001" | "prod" | "kentestauto5" | "12345678" | "3367590" | "src/main/resources/SquadInfo/squadInfo_3367590.csv" | "device_id;password;username" |
      | "squadMembers_002" | "prod" | "kentestauto4" | "12345678" | "3370298" | "src/main/resources/SquadInfo/squadInfo_3370298.csv" | "device_id;password;username" |
      | "squadMembers_003" | "prod" | "kentestauto4" | "12345678" | "3367590" | "src/main/resources/SquadInfo/squadInfo_3367590.csv" | "device_id;password;username" |
