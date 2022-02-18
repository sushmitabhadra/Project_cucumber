Feature: Testing Booking room functionality of booking site.


  Scenario: Room Booking
    Given User is on the website
   
    When Place entered
    And Selected the  date
    And Selected the customer details
    And Clicked on search button
    Then User should be redirected to propertiesfound page
    
    When Filters are selected
    And Clicked on the see availability
    Then Reserve window should open
    
    When Clicked on reserve button
    And Selected number of rooms
    And Clicked on I will reserve button
    Then User should get redirected to fill details page
    
    When Firstname entered
    And Lastname entered
    And Email entered
    And Confirm email entered
    And Comments entered
    And Selected arrival time
    And Clicked on next
    Then Last enter details page opens
    
    When Selected country
    And Entered phoneno
    And Entered card
    Then process completed
    
    
    
    


  
  #Scenario Outline: Title of your scenario outline
   # Given I want to write a step with <name>
   # When I check for the <value> in step
    #Then I verify the <status> in step

    #Examples: 
     # | name  | value | status  |
     # | name1 |     5 | success |
     # | name2 |     7 | Fail    |
