@gui @ownerInspection
Feature: Verify the H5 report page of owner inspection with measure data

  @gui @ownerInspection
  Scenario Outline: Test for house professional report page
    Given I call app login api of <env> with <usr> and <psw> for <groupCode> for <testCase>
    When I open the house pofessional report page of <groupId> and <teamId> and <projectId> and <taskId> for <testCase>
    And I wait for "2" seconds
    Then I verify <pageInfo> can be found on the page and the summary contains <summaryInfo> and <measureData> and <issueData>
    And I verify <qualityScore> can be found on the page and the score is displayed
    When I click button <finishButton>
    When I click button <regeneratePDFButton1> and <regeneratePDFButton2> to download the report
    Then I verify <generatingTips1> and <generatingTips2> can be found on the page while the report is being generated
    Then I verify button <button1> can be found on the page
    Then I verify button <button2> can be found on the page
    Then Capture the current page and save it as <fileName>
    And Quit the driver

    Examples: 
      | testCase             | env    | usr     | psw        | groupCode | groupId  | teamId   | projectId | taskId | houseId | pageInfo | summaryInfo | qualityScore | finishButton | regeneratePDFButton1 | regeneratePDFButton2 | generatingTips1 | generatingTips2 | button1  | button2 | fileName             | measureData | issueData |
      | "guiOwnerProRpt_001" | "prod" | "moon2" | "12345678" | ""        | "146208" | "146210" | "128673"  | "6112" | ""      | "汇总分析"   | "分别为"       | "房屋质量得分"     | "生成报告"       | "重新生成PDF1"           | "重新生成PDF2"           | "按分类等待"         | "按区域等待"         | "按检查项下载" | "按区域下载" | "guiOwnerProRpt_001" | "实测数据"      | "隐患明细"    |
