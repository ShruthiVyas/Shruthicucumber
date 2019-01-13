#Author: your.email@your.domain.com

Feature: To print the success message after the payment
  


  Scenario: To submit the card details and pay
    Given The user is in demo.guru99 payment gateway page initially
   
    And The user navigates to generate card number tab and prints the details available
    And The user navigates to check credit status tab enters the card number in the tab and clicks submit and prints the details .
    When The user navigates to cart and clicks on buy now
    And The user navigates to the payment process page and fill in the details and clicks on pay
    Then The usser prints the success message
    
     

  
