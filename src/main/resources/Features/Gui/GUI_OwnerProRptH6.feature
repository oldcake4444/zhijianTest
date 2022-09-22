@gui @ownerProRpt
Feature: Check export button can be found on the page

  @gui @ownerProRpt
  Scenario Outline: Test for house professional report page
    Given I call app login api of <env> with <usr> and <psw> for <groupCode> for <testCase>
    When I open the house pofessional report page of <groupId> and <teamId> and <projectId> and <taskId> for <testCase>
    And I wait for "2" seconds
    Then I verify <pageInfo> can be found on the page and the summary contains <summaryInfo>
    And I verify <qualityScore> can be found on the page and the score is displayed
    When I click button <finishButton>
    Then I verify button <button1> can be found on the page
    Then I verify button <button2> can be found on the page
    Then Capture the current page and save it as <fileName>
    And Quit the driver

    Examples: 
      | testCase             | env    | usr     | psw        | groupCode | groupId  | teamId   | projectId | taskId | houseId | pageInfo | summaryInfo | qualityScore | finishButton | button1  | button2 | fileName             |
      | "guiOwnerProRpt_001" | "prod" | "moon1" | "12345678" | ""        | "146208" | "146210" | "128673"  | "46"   | ""      | "汇总分析"   | "分别为" | "房屋质量得分"     | "完成查验"       | "按检查项下载" | "按区域下载" | "guiOwnerProRpt_001" |
