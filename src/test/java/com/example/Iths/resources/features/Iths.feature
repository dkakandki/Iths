Feature: Iths

  Background: testing
    Given I am on the IT-Högskolan website

  Scenario: Check Website Title
    Then I check the website title , the title should match

  Scenario: Navigate to Spring Information Meetings
    When I click on spring information meetings
    Then I should be navigated to spring information meetings page

  Scenario: Click Previous Arrow
    When I click the previous arrow
    Then previous student review should be displayed

  Scenario: Toggle Mobile Menu
    When I toggle the mobile menu
    Then the primary navigation menu should be displayed

  Scenario: Click Education Button
    When I click on the education button
    Then I should be navigated to education page

  Scenario: Check Education Dropdown
    When I click the education button
    And  I click the form of education button
    Then the education dropdown should be displayed

  Scenario: Click Application Button
    When I click the application button
    Then I should be navigated to application page

  Scenario: Click how to apply Page Button
    When I click the how to apply button
    Then I should be navigated to how to apply page

  Scenario: Play Video on how to apply page
    When I click on the how to apply button
    And I play the video on that page
    Then the video should be played

  Scenario: Click News Button and select gothenberg from filters
    When I click the news button
    Then the filter options will be displayed, I filter it to gothenberg
    And i should get gothenberg news
