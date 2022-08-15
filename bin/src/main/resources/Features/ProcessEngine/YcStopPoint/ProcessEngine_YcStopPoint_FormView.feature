@ProcecssEngine @StopPointCheck
Feature: Verify the process form for yc stop checkpoint

  @AppApi
  Scenario Outline: Test for app login api
    Given I call the "login" api of <env> with <psw> and <usr>in <loginApiParameters> for <testCase>
    Then Verify the calling is successful with "登录成功" for <testCase>
    When I call the stop_checkpoint_yc_processform api of <env> for <testCase> with <apiParameters> of <lvl> level for <orgId>
    Then Verify the current user privileges are as expected as <usrPrivileges> for <testCase>

    Examples: 
      | testCase       | env  | usr          | psw        | loginApiParameters            | apiParameters                                     | lvl       | orgId      | usrPrivileges                |
      | "stoppoint001" | "t3" | "yctest1"    | "12345678" | "device_id;password;username" | "stop_checkpoint_yc,processform,list_mobile"      | "project" | ",,101316" | "Detail,StartProcess,Export" |
      | "stoppoint002" | "t3" | "yczb2test1" | "12345678" | "device_id;password;username" | "stop_checkpoint_yc,processform,list_mobile"      | "project" | ",,101316" | "Detail,StartProcess,Export" |
      | "stoppoint003" | "t3" | "yctest2"    | "12345678" | "device_id;password;username" | "stop_checkpoint_yc,processform,list_mobile"      | "project" | ",,101316" | "Detail,StartProcess,Export" |
      | "stoppoint004" | "t3" | "yctest3"    | "12345678" | "device_id;password;username" | "stop_checkpoint_yc,processform,list_mobile"      | "project" | ",,101316" | "Detail,StartProcess,Export" |
      | "stoppoint005" | "t3" | "yctest30"   | "12345678" | "device_id;password;username" | "stop_checkpoint_yc,processform,list_mobile"      | "project" | ",,101316" | "Detail,StartProcess,Export" |
      | "stoppoint006" | "t3" | "yctest4"    | "12345678" | "device_id;password;username" | "stop_checkpoint_yc,processform,list_mobile"      | "project" | ",,101316" | "Detail,Export"              |
      | "stoppoint007" | "t3" | "yctest5"    | "12345678" | "device_id;password;username" | "stop_checkpoint_yc,processform,list_mobile"      | "project" | ",,101316" | "Detail,Export"              |
      | "stoppoint008" | "t3" | "yctest6"    | "12345678" | "device_id;password;username" | "stop_checkpoint_yc,processform,list_mobile"      | "project" | ",,101316" | "Detail,Export"              |
      | "stoppoint009" | "t3" | "ycjl2test1" | "12345678" | "device_id;password;username" | "stop_checkpoint_yc,processform,list_mobile"      | "project" | ",,101316" | "Detail,Export"              |
      | "stoppoint010" | "t3" | "yctest7"    | "12345678" | "device_id;password;username" | "stop_checkpoint_yc,processform,list_mobile"      | "project" | ",,101316" | "Detail,Export"              |
      | "stoppoint011" | "t3" | "yctest8"    | "12345678" | "device_id;password;username" | "stop_checkpoint_yc,processform,list_mobile"      | "project" | ",,101316" | "Detail,Export"              |
      | "stoppoint012" | "t3" | "yctest9"    | "12345678" | "device_id;password;username" | "stop_checkpoint_yc,processform,list_mobile"      | "project" | ",,101316" | "Detail,Export"              |
      | "stoppoint013" | "t3" | "yctest10"   | "12345678" | "device_id;password;username" | "stop_checkpoint_yc,processform,list_mobile"      | "project" | ",,101316" | "Detail,Export"              |
      | "stoppoint014" | "t3" | "yctest11"   | "12345678" | "device_id;password;username" | "stop_checkpoint_yc,processform,list_mobile"      | "project" | ",,101316" | "Detail,Export"              |
      | "stoppoint015" | "t3" | "yctest12"   | "12345678" | "device_id;password;username" | "stop_checkpoint_yc,processform,list_mobile"      | "project" | ",,101316" | "Detail,Export"              |
      | "stoppoint016" | "t3" | "yctest20"   | "12345678" | "device_id;password;username" | "stop_checkpoint_yc,processform,team_list_mobile" | "team"    | ",104967," | "Detail,Export"              |
      | "stoppoint017" | "t3" | "yctest21"   | "12345678" | "device_id;password;username" | "stop_checkpoint_yc,processform,team_list_mobile" | "team"    | ",104967," | "Detail,Export"              |
      | "stoppoint018" | "t3" | "yctest30"   | "12345678" | "device_id;password;username" | "stop_checkpoint_yc,processform,team_list_mobile" | "team"    | ",104967," | "Detail,Export"              |
      | "stoppoint019" | "t3" | "yctest22"   | "12345678" | "device_id;password;username" | "stop_checkpoint_yc,processform,team_list_mobile" | "team"    | ",104967," | "Detail,Export"              |
      | "stoppoint020" | "t3" | "yctest23"   | "12345678" | "device_id;password;username" | "stop_checkpoint_yc,processform,team_list_mobile" | "team"    | ",104967," | "Detail,Export"              |
      | "stoppoint021" | "t3" | "yctest24"   | "12345678" | "device_id;password;username" | "stop_checkpoint_yc,processform,team_list_mobile" | "group"   | "104966,," | "Detail,Export"              |
      | "stoppoint022" | "t3" | "yctest25"   | "12345678" | "device_id;password;username" | "stop_checkpoint_yc,processform,team_list_mobile" | "group"   | "104966,," | "Detail,Export"              |
      | "stoppoint023" | "t3" | "yctest26"   | "12345678" | "device_id;password;username" | "stop_checkpoint_yc,processform,team_list_mobile" | "group"   | "104966,," | "Detail,Export"              |
      | "stoppoint024" | "t3" | "yctest27"   | "12345678" | "device_id;password;username" | "stop_checkpoint_yc,processform,team_list_mobile" | "group"   | "104966,," | "Detail,Export"              |
      | "stoppoint025" | "t3" | "yctest30"   | "12345678" | "device_id;password;username" | "stop_checkpoint_yc,processform,team_list_mobile" | "group"   | "104966,," | "Detail,Export"              |
 