@ProcecssEngine @DrawingReview
Feature: Verify the process form for drawing review

  @DrawingReview @ProcessEnginePrivilegeVerification
  Scenario Outline: Test for privileges of drawing dataform api
    Given I call app login api and web login api of <env> with <usr> and <psw> for <groupCode> for <testCase>
    When I call the project_drawings_dataform api of <env> for <testCase> with <apiParameters> of <lvl> level for <orgId>
    Then Verify the current user privileges are as expected as <usrPrivileges> for <testCase> for project_drawings_dataform

    Examples: 
      | testCase     | env    | usr       | psw        | groupCode | apiParameters                              | lvl       | orgId                  | usrPrivileges                               |
      | "drawing001" | "prod" | "outman1" | "12345678" | ""        | "project_drawings_yc,dataform,list_mobile" | "project" | "100546,100547,100987" | "detail,void,create,update,redirect_update" |
      | "drawing002" | "prod" | "outman2" | "12345678" | ""        | "project_drawings_yc,dataform,list_mobile" | "project" | "100546,100547,100987" | "detail,void,create,update,redirect_update" |
      | "drawing003" | "prod" | "outman4" | "12345678" | ""        | "project_drawings_yc,dataform,list_mobile" | "project" | "100546,100547,100987" | "detail,void,update,redirect_update"        |
      | "drawing004" | "prod" | "outman6" | "12345678" | ""        | "project_drawings_yc,dataform,list_mobile" | "project" | "100546,100547,100987" | "detail,void,update,redirect_update"        |
      | "drawing005" | "prod" | "outman9" | "12345678" | ""        | "project_drawings_yc,dataform,list_mobile" | "project" | "100546,100547,100987" | "detail,void,update,redirect_update"        |

  @DrawingReview @ProcessEngineFlowCheck
  Scenario Outline: Test for workflow of drawing review
    Given I recover the drawing review approve data of <approveDataPaths> for <testCase>
    Given I call app login api and web login api of <env> with <usr1> and <psw> for <groupCode> for <testCase>
    When I commit a drawing review form in <env> by inputting <formDataPath> and assign to <reviewer1> for <projectId> of <teamId> for <testCase>
    And I commit a drawing review form in <env> by inputting <formDataPath> and assign to <reviewer2> for <projectId> of <teamId> for <testCase>
    And I call app login api and web login api of <env> with <reviewer1> and <psw> for <groupCode> for <testCase>
    When I check the project drawing list processform assigned to <reviewer1> of <env> for <testCase> of <lvl> level for <orgId>
    And I check the project drawing list dataFrom assigned to <reviewer1> of <env> for <testCase> of <lvl> level for <orgId>
    Then verify current user has permission for <flowProcess> assigned to <reviewer1> but not <reviewer2> of the project drawing review request created for <testCase>
    And I approve the project drawing review request by inputting <approveDataPath1> and assign to <reviewer3> of <env> for <testCase> of <lvl> level for <orgId>
    And I check the drawing review processform assigned to <reviewer1> of <env> for <testCase> of <lvl> level for <orgId> and get the info of <reviewStage1> and update <approveDataPaths>
    And I call app login api and web login api of <env> with <reviewer3> and <psw> for <groupCode> for <testCase>
    Then I approve the project drawing review request by inputting <approveDataPath2> and assign to <reviewer4> of <env> for <testCase> of <lvl> level for <orgId>
    And I check the drawing review processform assigned to <reviewer1> of <env> for <testCase> of <lvl> level for <orgId> and get the info of <reviewStage2> and update <approveDataPaths>
    And I call app login api and web login api of <env> with <reviewer4> and <psw> for <groupCode> for <testCase>
    Then I approve the project drawing review request by inputting <approveDataPath3> and assign to <reviewer5> of <env> for <testCase> of <lvl> level for <orgId>
    And I check the drawing review processform assigned to <reviewer1> of <env> for <testCase> of <lvl> level for <orgId> and get the info of <reviewStage3> and update <approveDataPaths>
    And I call app login api and web login api of <env> with <reviewer5> and <psw> for <groupCode> for <testCase>
    Then I approve the project drawing review request by inputting <approveDataPath4> and assign to <reviewer6> of <env> for <testCase> of <lvl2> level for <orgId>
    And I check the drawing review processform assigned to <reviewer1> of <env> for <testCase> of <lvl> level for <orgId> and get the info of <reviewStage4> and update <approveDataPaths>
    And I call app login api and web login api of <env> with <reviewer6> and <psw> for <groupCode> for <testCase>
    Then I approve the project drawing review request by inputting <approveDataPath5> and assign to <reviewer7> of <env> for <testCase> of <lvl3> level for <orgId>
    And I verify the drawing review process form and data form assigned to <reviewer1> are in the correct status of <env> for <testCase> of <lvl> level for <orgId>
    And I recover the drawing review approve data of <approveDataPaths> for <testCase>

    Examples: 
      | testCase     | env    | usr1      | psw        | groupCode | formDataPath                                                               | projectId | teamId   | reviewer1        | reviewer2        | lvl       | orgId                  | flowProcess | approveDataPath1                                                               | reviewer3        | approveDataPath2                                                               | reviewer4         | approveDataPath3                                                               | reviewer5         | approveDataPath4                                                               | reviewer6         | lvl2   | approveDataPath5                                                               | reviewer7 | lvl3    | reviewStage1            | reviewStage2        | reviewStage3    | reviewStage4          | approveDataPaths                                                                                                                                                                                                                                                                                                      |
      | "drawing006" | "prod" | "outman2" | "12345678" | ""        | "src/main/resources/TestData/ProcessEngine/DrawingReview/input_drawing006" | "100987"  | "100547" | "147251-outman5" | "147250-outman4" | "project" | "100546,100547,100987" | "专项监理审批"    | "src/main/resources/TestData/ProcessEngine/DrawingReview/approve_drawing006_1" | "147252-outman6" | "src/main/resources/TestData/ProcessEngine/DrawingReview/approve_drawing006_2" | "147256-outman10" | "src/main/resources/TestData/ProcessEngine/DrawingReview/approve_drawing006_3" | "147259-outman13" | "src/main/resources/TestData/ProcessEngine/DrawingReview/approve_drawing006_4" | "147265-outman19" | "team" | "src/main/resources/TestData/ProcessEngine/DrawingReview/approve_drawing006_5" | ""        | "group" | "spe_supervision_audit" | "supervision_audit" | "party_a_audit" | "team_projdept_audit" | "src/main/resources/TestData/ProcessEngine/DrawingReview/approve_drawing006_2;src/main/resources/TestData/ProcessEngine/DrawingReview/approve_drawing006_3;src/main/resources/TestData/ProcessEngine/DrawingReview/approve_drawing006_4;src/main/resources/TestData/ProcessEngine/DrawingReview/approve_drawing006_5" |

  @DrawingReview @ProcessEngineFlowCheck
  Scenario Outline: 1st test case for negative workflow of drawing review
    Given I call app login api and web login api of <env> with <usr1> and <psw> for <groupCode> for <testCase>
    When I commit a drawing review form in <env> by inputting <formDataPath> and assign to <reviewer1> for <projectId> of <teamId> for <testCase>
    And I call app login api and web login api of <env> with <reviewer1> and <psw> for <groupCode> for <testCase>
    When I check the project drawing list processform assigned to <reviewer1> of <env> for <testCase> of <lvl> level for <orgId>
    And I check the project drawing list dataFrom assigned to <reviewer1> of <env> for <testCase> of <lvl> level for <orgId>
    And I reject the project drawing review request by inputting <rejectDataPath1> and assign to <reviewer2> of <env> for <testCase> of <lvl> level for <orgId>
    And I verify the drawing review process form assigned to <reviewer1> are in the correct <processStatus> because of <result> in <reviewStage> of <env> for <testCase> of <lvl> level for <orgId>

    Examples: 
      | testCase     | env    | usr1      | psw        | groupCode | formDataPath                                                               | projectId | teamId   | reviewer1        | reviewer2        | lvl       | orgId                  | rejectDataPath1                                                               | processStatus              | result | reviewStage             |
      | "drawing007" | "prod" | "outman2" | "12345678" | ""        | "src/main/resources/TestData/ProcessEngine/DrawingReview/input_drawing007" | "100987"  | "100547" | "147251-outman5" | "147250-outman5" | "project" | "100546,100547,100987" | "src/main/resources/TestData/ProcessEngine/DrawingReview/reject_drawing007_1" | "2-construction_init-图纸提报" | "2"    | "spe_supervision_audit" |

  @DrawingReview @ProcessEngineFlowCheck
  Scenario Outline: 2nd test case for negative workflow of drawing review
    Given I recover the drawing review approve data of <approveDataPaths> for <testCase>
    Given I call app login api and web login api of <env> with <usr1> and <psw> for <groupCode> for <testCase>
    When I commit a drawing review form in <env> by inputting <formDataPath> and assign to <reviewer1> for <projectId> of <teamId> for <testCase>
    And I call app login api and web login api of <env> with <reviewer1> and <psw> for <groupCode> for <testCase>
    When I check the project drawing list processform assigned to <reviewer1> of <env> for <testCase> of <lvl> level for <orgId>
    And I check the project drawing list dataFrom assigned to <reviewer1> of <env> for <testCase> of <lvl> level for <orgId>
    And I approve the project drawing review request by inputting <approveDataPath1> and assign to <reviewer2> of <env> for <testCase> of <lvl> level for <orgId>
    And I check the drawing review processform assigned to <reviewer1> of <env> for <testCase> of <lvl> level for <orgId> and get the info of <reviewStage1> and update <approveDataPaths>
    And I call app login api and web login api of <env> with <reviewer2> and <psw> for <groupCode> for <testCase>
    When I reject the project drawing review request by inputting <rejectDataPath1> and assign to <reviewer3> of <env> for <testCase> of <lvl> level for <orgId>
    Then I verify the drawing review process form assigned to <reviewer1> are in the correct <processStatus> because of <result> in <reviewStage2> of <env> for <testCase> of <lvl> level for <orgId>
    And I recover the drawing review approve data of <approveDataPaths> for <testCase>

    Examples: 
      | testCase     | env    | usr1      | psw        | groupCode | formDataPath                                                               | projectId | teamId   | reviewer1         | reviewer2        | reviewer3         | lvl       | orgId                  | approveDataPath1                                                               | rejectDataPath1                                                               | processStatus              | result | reviewStage1            | approveDataPaths                                                              | reviewStage2        |
      | "drawing008" | "prod" | "outman3" | "12345678" | ""        | "src/main/resources/TestData/ProcessEngine/DrawingReview/input_drawing008" | "100987"  | "100547" | "147276-outman30" | "147254-outman8" | "147257-outman11" | "project" | "100546,100547,100987" | "src/main/resources/TestData/ProcessEngine/DrawingReview/approve_drawing008_1" | "src/main/resources/TestData/ProcessEngine/DrawingReview/reject_drawing008_1" | "2-construction_init-图纸提报" | "2"    | "spe_supervision_audit" | "src/main/resources/TestData/ProcessEngine/DrawingReview/reject_drawing008_1" | "supervision_audit" |

  @DrawingReview @ProcessEngineFlowCheck
  Scenario Outline: 3rd test case for negative workflow of drawing review
    Given I recover the drawing review approve data of <approveDataPaths> for <testCase>
    Given I call app login api and web login api of <env> with <usr1> and <psw> for <groupCode> for <testCase>
    When I commit a drawing review form in <env> by inputting <formDataPath> and assign to <reviewer1> for <projectId> of <teamId> for <testCase>
    And I call app login api and web login api of <env> with <reviewer1> and <psw> for <groupCode> for <testCase>
    When I check the project drawing list processform assigned to <reviewer1> of <env> for <testCase> of <lvl> level for <orgId>
    And I check the project drawing list dataFrom assigned to <reviewer1> of <env> for <testCase> of <lvl> level for <orgId>
    Then I approve the project drawing review request by inputting <approveDataPath1> and assign to <reviewer2> of <env> for <testCase> of <lvl> level for <orgId>
    And I check the drawing review processform assigned to <reviewer1> of <env> for <testCase> of <lvl> level for <orgId> and get the info of <reviewStage1> and update <approveDataPaths>
    And I call app login api and web login api of <env> with <reviewer2> and <psw> for <groupCode> for <testCase>
    Then I approve the project drawing review request by inputting <approveDataPath2> and assign to <reviewer3> of <env> for <testCase> of <lvl> level for <orgId>
    And I check the drawing review processform assigned to <reviewer1> of <env> for <testCase> of <lvl> level for <orgId> and get the info of <reviewStage2> and update <approveDataPaths>
    And I call app login api and web login api of <env> with <reviewer3> and <psw> for <groupCode> for <testCase>
    When I reject the project drawing review request by inputting <rejectDataPath1> and assign to <reviewer4> of <env> for <testCase> of <lvl> level for <orgId>
    Then I verify the drawing review process form assigned to <reviewer1> are in the correct <processStatus> because of <result> in <reviewStage3> of <env> for <testCase> of <lvl> level for <orgId>
    And I recover the drawing review approve data of <approveDataPaths> for <testCase>

    Examples: 
      | testCase     | env    | usr1       | psw        | groupCode | formDataPath                                                               | projectId | teamId   | reviewer1        | reviewer2        | reviewer3        | reviewer4         | lvl       | orgId                  | approveDataPath1                                                               | approveDataPath2                                                               | rejectDataPath1                                                               | processStatus              | result | reviewStage1            | approveDataPaths                                                                                                                                           | reviewStage2        | reviewStage3    |
      | "drawing009" | "prod" | "outman30" | "12345678" | ""        | "src/main/resources/TestData/ProcessEngine/DrawingReview/input_drawing009" | "100987"  | "100547" | "147250-outman4" | "147253-outman7" | "147255-outman9" | "147260-outman14" | "project" | "100546,100547,100987" | "src/main/resources/TestData/ProcessEngine/DrawingReview/approve_drawing009_1" | "src/main/resources/TestData/ProcessEngine/DrawingReview/approve_drawing009_2" | "src/main/resources/TestData/ProcessEngine/DrawingReview/reject_drawing009_1" | "2-construction_init-图纸提报" | "2"    | "spe_supervision_audit" | "src/main/resources/TestData/ProcessEngine/DrawingReview/approve_drawing009_2;src/main/resources/TestData/ProcessEngine/DrawingReview/reject_drawing009_1" | "supervision_audit" | "party_a_audit" |

  @DrawingReview @ProcessEngineFlowCheck
  Scenario Outline: 4th test case for negative workflow of drawing review
    Given I recover the drawing review approve data of <approveDataPaths> for <testCase>
    Given I call app login api and web login api of <env> with <usr1> and <psw> for <groupCode> for <testCase>
    When I commit a drawing review form in <env> by inputting <formDataPath> and assign to <reviewer1> for <projectId> of <teamId> for <testCase>
    And I call app login api and web login api of <env> with <reviewer1> and <psw> for <groupCode> for <testCase>
    When I check the project drawing list processform assigned to <reviewer1> of <env> for <testCase> of <lvl> level for <orgId>
    And I check the project drawing list dataFrom assigned to <reviewer1> of <env> for <testCase> of <lvl> level for <orgId>
    Then I approve the project drawing review request by inputting <approveDataPath1> and assign to <reviewer2> of <env> for <testCase> of <lvl> level for <orgId>
    And I check the drawing review processform assigned to <reviewer1> of <env> for <testCase> of <lvl> level for <orgId> and get the info of <reviewStage1> and update <approveDataPaths>
    And I call app login api and web login api of <env> with <reviewer2> and <psw> for <groupCode> for <testCase>
    Then I approve the project drawing review request by inputting <approveDataPath2> and assign to <reviewer3> of <env> for <testCase> of <lvl> level for <orgId>
    And I check the drawing review processform assigned to <reviewer1> of <env> for <testCase> of <lvl> level for <orgId> and get the info of <reviewStage2> and update <approveDataPaths>
    And I call app login api and web login api of <env> with <reviewer3> and <psw> for <groupCode> for <testCase>
    Then I approve the project drawing review request by inputting <approveDataPath3> and assign to <reviewer4> of <env> for <testCase> of <lvl> level for <orgId>
    And I check the drawing review processform assigned to <reviewer1> of <env> for <testCase> of <lvl> level for <orgId> and get the info of <reviewStage3> and update <approveDataPaths>
    And I call app login api and web login api of <env> with <reviewer4> and <psw> for <groupCode> for <testCase>
    When I reject the project drawing review request by inputting <rejectDataPath1> and assign to <reviewer5> of <env> for <testCase> of <lvl2> level for <orgId>
    Then I verify the drawing review process form assigned to <reviewer1> are in the correct <processStatus> because of <result> in <reviewStage4> of <env> for <testCase> of <lvl> level for <orgId>
    And I recover the drawing review approve data of <approveDataPaths> for <testCase>

    Examples: 
      | testCase     | env    | usr1      | psw        | groupCode | formDataPath                                                               | projectId | teamId   | reviewer1         | reviewer2        | reviewer3         | reviewer4         | reviewer5         | lvl       | lvl2   | orgId                  | approveDataPath1                                                               | approveDataPath2                                                               | approveDataPath3                                                               | rejectDataPath1                                                               | processStatus              | result | reviewStage1            | approveDataPaths                                                                                                                                                                                                                        | reviewStage2        | reviewStage3    | reviewStage4          |
      | "drawing010" | "prod" | "outman3" | "12345678" | ""        | "src/main/resources/TestData/ProcessEngine/DrawingReview/input_drawing010" | "100987"  | "100547" | "147282-outman33" | "147253-outman7" | "147270-outman24" | "147262-outman16" | "147267-outman21" | "project" | "team" | "100546,100547,100987" | "src/main/resources/TestData/ProcessEngine/DrawingReview/approve_drawing010_1" | "src/main/resources/TestData/ProcessEngine/DrawingReview/approve_drawing010_2" | "src/main/resources/TestData/ProcessEngine/DrawingReview/approve_drawing010_3" | "src/main/resources/TestData/ProcessEngine/DrawingReview/reject_drawing010_1" | "2-construction_init-图纸提报" | "2"    | "spe_supervision_audit" | "src/main/resources/TestData/ProcessEngine/DrawingReview/approve_drawing010_2;src/main/resources/TestData/ProcessEngine/DrawingReview/approve_drawing010_3;src/main/resources/TestData/ProcessEngine/DrawingReview/reject_drawing010_1" | "supervision_audit" | "party_a_audit" | "team_projdept_audit" |

  @DrawingReview @ProcessEngineFlowCheck
  Scenario Outline: 5th test case for negative workflow of drawing review
    Given I recover the drawing review approve data of <approveDataPaths> for <testCase>
    Given I call app login api and web login api of <env> with <usr1> and <psw> for <groupCode> for <testCase>
    When I commit a drawing review form in <env> by inputting <formDataPath> and assign to <reviewer1> for <projectId> of <teamId> for <testCase>
    And I call app login api and web login api of <env> with <reviewer1> and <psw> for <groupCode> for <testCase>
    When I check the project drawing list processform assigned to <reviewer1> of <env> for <testCase> of <lvl> level for <orgId>
    And I check the project drawing list dataFrom assigned to <reviewer1> of <env> for <testCase> of <lvl> level for <orgId>
    Then I approve the project drawing review request by inputting <approveDataPath1> and assign to <reviewer2> of <env> for <testCase> of <lvl> level for <orgId>
    And I check the drawing review processform assigned to <reviewer1> of <env> for <testCase> of <lvl> level for <orgId> and get the info of <reviewStage1> and update <approveDataPaths>
    And I call app login api and web login api of <env> with <reviewer2> and <psw> for <groupCode> for <testCase>
    Then I approve the project drawing review request by inputting <approveDataPath2> and assign to <reviewer3> of <env> for <testCase> of <lvl> level for <orgId>
    And I check the drawing review processform assigned to <reviewer1> of <env> for <testCase> of <lvl> level for <orgId> and get the info of <reviewStage2> and update <approveDataPaths>
    And I call app login api and web login api of <env> with <reviewer3> and <psw> for <groupCode> for <testCase>
    Then I approve the project drawing review request by inputting <approveDataPath3> and assign to <reviewer4> of <env> for <testCase> of <lvl> level for <orgId>
    And I check the drawing review processform assigned to <reviewer1> of <env> for <testCase> of <lvl> level for <orgId> and get the info of <reviewStage3> and update <approveDataPaths>
    And I call app login api and web login api of <env> with <reviewer4> and <psw> for <groupCode> for <testCase>
    Then I approve the project drawing review request by inputting <approveDataPath4> and assign to <reviewer5> of <env> for <testCase> of <lvl2> level for <orgId>
    And I check the drawing review processform assigned to <reviewer1> of <env> for <testCase> of <lvl> level for <orgId> and get the info of <reviewStage4> and update <approveDataPaths>
    And I call app login api and web login api of <env> with <reviewer5> and <psw> for <groupCode> for <testCase>
    When I reject the project drawing review request by inputting <rejectDataPath1> and assign to <reviewer6> of <env> for <testCase> of <lvl3> level for <orgId>
    And I recover the drawing review approve data of <approveDataPaths> for <testCase>

    Examples: 
      | testCase     | env    | usr1       | psw        | groupCode | formDataPath                                                               | projectId | teamId   | reviewer1         | reviewer2        | reviewer3         | reviewer4         | reviewer5         | reviewer6 | lvl       | lvl2   | lvl3    | orgId                  | approveDataPath1                                                               | approveDataPath2                                                               | approveDataPath3                                                               | approveDataPath4                                                               | rejectDataPath1                                                               | processStatus              | result | reviewStage1            | approveDataPaths                                                                                                                                                                                                                                                                                                     | reviewStage2        | reviewStage3    | reviewStage4          |
      | "drawing011" | "prod" | "outman30" | "12345678" | ""        | "src/main/resources/TestData/ProcessEngine/DrawingReview/input_drawing011" | "100987"  | "100547" | "147281-outman34" | "147253-outman7" | "147268-outman22" | "147261-outman15" | "147266-outman20" | ""        | "project" | "team" | "group" | "100546,100547,100987" | "src/main/resources/TestData/ProcessEngine/DrawingReview/approve_drawing011_1" | "src/main/resources/TestData/ProcessEngine/DrawingReview/approve_drawing011_2" | "src/main/resources/TestData/ProcessEngine/DrawingReview/approve_drawing011_3" | "src/main/resources/TestData/ProcessEngine/DrawingReview/approve_drawing011_4" | "src/main/resources/TestData/ProcessEngine/DrawingReview/reject_drawing011_1" | "2-construction_init-图纸提报" | "2"    | "spe_supervision_audit" | "src/main/resources/TestData/ProcessEngine/DrawingReview/approve_drawing011_2;src/main/resources/TestData/ProcessEngine/DrawingReview/approve_drawing011_3;src/main/resources/TestData/ProcessEngine/DrawingReview/approve_drawing011_4;src/main/resources/TestData/ProcessEngine/DrawingReview/reject_drawing011_1" | "supervision_audit" | "party_a_audit" | "team_projdept_audit" |
