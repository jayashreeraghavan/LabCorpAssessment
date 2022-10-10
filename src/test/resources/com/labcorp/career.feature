Feature: Career Test

  Scenario : launch career page
    Given Open labcorp site
    When click on career link
    Then verify Im in  career search page

  Scenario : Select Job
    Given I open "https://careers.labcorp.com/global/en/home" and type "QA Test Automation Developer"
    When Select Autosuggestion having "QA Test Automation Developer"
    Then Browse to the position  and confirm job tile is "QA Test Automation Developer"

  Scenario : Test Job Display page
    Given I'm in Job Page with Job id "https://careers.labcorp.com/global/en/job/21-90223_RM"
    Then verify job data

  Scenario: Test Apply Now
    Given I'm in Job Apply page  "https://careers.labcorp.com/global/en/job/21-90223_RM/QA-Test-Automation-Developer"
    When  I click Apply Now button
    Then  I entering Username "jayashreer2312@gmail.com" And password  "Monday1$"
    Then  verify application data

