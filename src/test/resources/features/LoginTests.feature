Feature:
  Scenario: Login Success
    Given I open login Page
    When I enter email "yurii.lyndiuk@testpro.io"
    And I enter password "jjbuQe8D"
    And I submit
    Then I am logged in