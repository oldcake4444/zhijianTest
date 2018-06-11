@GUI
Feature: Create yanfang task

  @GUI @TaskCreation
  Scenario Outline: Create a new yangfang task
    Given I login <env> by <usr> and <psw>
    And I go to <tgtPage> in <env> env

    Examples: 
      | testCase           | env    | usr            | psw        | tgtPage    |
      | "taskCreation_001" | "test" | "kentestgrp11" | "12345678" | "验房任务列表页面" |
