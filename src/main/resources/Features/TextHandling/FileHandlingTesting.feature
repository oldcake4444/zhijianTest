@fileHandling
Feature: Sample test for file handling

  @fileHandling
  Scenario Outline: Test for word count
    Given I calculate the word count for file <wordCountFile> for <testCase>
    Then Verify the result is the same as <resultFile> for <testCase>

    Examples: 
      | testCase          | wordCountFile                                       | resultFile                                            |
      | "FileHandling001" | "src/main/resources/TextPractice/WordCountText.txt" | "src/main/resources/TextPractice/WordCountResult.txt" |
