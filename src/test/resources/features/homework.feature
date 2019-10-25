@web @regression @homework
Feature: Homework

  Background:
    Given I am on home page

    @homework-1
    Scenario Outline: Signup form should not accept any invalid email address
      When I enter Oguz into firstname text fields on home screen
      And I enter Aydogan into lastname text fields on home screen
      And I enter <emails> into mobile number text fields on home screen
      And I click on new password button on home screen
      And I click on red warning button button on home screen
      Then I verify invalid email error message

      Examples:
        | emails                        |
        | * #@%^%#$@#$@#.com            |
        |@example.com                   |
        |Joe Smith <email@example.com>  |
        |email.example.com              |
        |email@example@example.com      |
        |.email@example.com             |
        |email.@example.com             |
        |email..email@example.com       |
        |あいうえお@example.com          |
        |email@example.com (Joe Smith)  |
        |email@example                  |
        |email@-example.com             |
        |email@example.web              |
        |email@111.222.333.44444        |
        |email@example..com             |
        |Abc..123@example.com           |
