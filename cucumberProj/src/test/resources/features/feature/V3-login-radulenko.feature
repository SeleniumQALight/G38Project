Feature: Login to test site

  @V3test @Smoke
  Scenario: Valid login

    Given user opens Login Page
    When user enters login "Student" in input login on Login Page
    And user enters pass "909090" in input pass on Login Page
    And user clicks on Sign in button on Login Page
    Then user sees avatar on Home Page
