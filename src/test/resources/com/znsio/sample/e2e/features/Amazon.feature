@amazon
Feature: Adding product to Amazon Cart
 @android @web
  Scenario: User can search and add product to Cart
    Given User is on HomePage
    When User searches for "iPhone 13"
    Then Adds Product to Cart