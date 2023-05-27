Feature: Search for aproduct and order it

Scenario: user search for product in the home page and top deals page

Given User landing into Greenkart home page 
When user search for a product in the home page with short name of the product
Then user search for a product on the top deals page 
And check whether the home page search product matched with the top deals searched product