@base_flow
Feature: This is to test JP hop fare.


Scenario Outline:
    Given I go to JP Home page
    When I fill "<from>", "<to>" and click search button 
    Then I go to the result page with correct "<fares>"
    
Examples:
    | from |to |fares|
    | Newmarket Train Station |  Gribblehurst Park   |HOP   $1.80|
    |  Britomart Train Station |   Swanson Train Station   |HOP   $4.90|
