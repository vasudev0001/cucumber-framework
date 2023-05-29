Feature: Search product and order it.
Scenario: search for product then it to cart and placing the order.

Given search for a product in greenKart home page
When if product found then increase the quantity and add to cart
And Open cart and check added product is correct
Then place the order and verify the error message
