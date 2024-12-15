Feature: Validate Added Product in Cart is same at customization page.

Scenario: Customization page prodcut is ame as Cart page Product.

Given User is at Cart Page
When Add Product to the Customization page
Then Customization page prodcut is ame as Cart page Product