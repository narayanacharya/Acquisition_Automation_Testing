Feature: Login Logout Functionality
  AS an Admin I can login and access the admin features

  Scenario: Reservation Workspace displays while login to the application
    Given I am logged in as user by using "admin_credentials"
    When I am in reservation workspace
    Then The system allows to me see the admin functionality
