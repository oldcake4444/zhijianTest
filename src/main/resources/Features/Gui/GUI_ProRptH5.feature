@gui @houseProRpt
Feature: Check export button can be found on the page

  @gui @houseProRpt
  Scenario Outline: Test for house professional report page
    Given I call app login api of <env> with <usr> and <psw> for <groupCode> for <testCase>
    When I open the house pofessional report page of <groupId> and <teamId> and <projectId> and <taskId> and <houseId> for <testCase>
    And I wait for "2" seconds
    Then I verify <pageInfo> can be found on the page and the summary contains <summaryInfo>
    When I click button <finishButton>
    Then I verify button <button1> can be found on the page
    Then I verify button <button2> can be found on the page
    And Quit the driver

    Examples: 
      | testCase             | env    | usr            | psw        | groupCode | groupId  | teamId   | projectId | taskId    | houseId    | pageInfo | summaryInfo    | finishButton | button1  | button2 |
      | "guiHouseProRpt_001" | "prod" | "kenjjyftest1" | "12345678" | "jjyf"    | "171319" | "171322" | "142639"  | "9064300" | "67679751" | "汇总分析"   | "本次查验共发现隐患66条" | "完成查验"       | "按检查项下载" | "按区域下载" |
