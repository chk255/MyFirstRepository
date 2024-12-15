Feature: Search and Select Phone and add to Cart from FlipKart Application.

Scenario: Search phone in Search box of Landing Page.
Given User is at Landing Page
When User Search with "Phone" in Search Box and select Brand Apple
Then All Apple phone result should be displayed

Scenario: Select given Phone and Add to cart
Given User is at Product Page
When User Select phone
Then Same Phone should be added to cart and validate price