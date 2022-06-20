# author:ilhami.aktan@siliconmarkets.ai
# 20/22 Chetwood-01
# User is testing Get Quick Quote slide  calculation functionality.

@wip

Feature: User is testing Interest and amount calculation functionality.

  Scenario:1-User on the LiveLend website homepage
    Given User open browser
    When User on the LiveLend website homepage
    Then User click the accept button

  Scenario Outline:2-User is testing borrow amount slider functionality
    Given User open the browser Amount Slider on the "£5,000" amount loan term on the "42 months" Monthly Repayment on the "£183.74" Total amount repayable on the "£7,717.27"
    Then User move the borrow amount slider from between "-209" to "109" with this amount "<borrowAmount1>" to "<borrowAmount2>" in month "42 months"
    And User should able to see Total Amount Repayable change "<actualTotalAmountRepayable1>" to "<actualTotalAmountRepayable2>"
    Then User should able to see Monthly Repayment change "<actualMonthlyPaymentValue1>" to "<actualMonthlyPaymentValue2>"

    Examples:
      |borrowAmount1|borrowAmount2|actualTotalAmountRepayable1|actualTotalAmountRepayable2|actualMonthlyPaymentValue1|actualMonthlyPaymentValue2|
      |£1,000|£11,000|£1,543.45|£16,977.99|£36.75|£404.24|

  Scenario Outline:3-User is testing loan term slider functionality
    Given User open the browser Amount Slider on the "£11,000" amount loan term on the "42 months" Monthly Repayment on the "£404.24" Total amount repayable on the "£16,977.99"
    When User move the loan term slider from between "-209" to "130" with this month "<loanTermValue1>" to "<loanTermValue2>" in this borrow amount "£11,000"
    And User should able to see Total Amount Repayable change "<actualTotalAmountRepayable1>" to "<actualTotalAmountRepayable2>"
    Then User should able to see Monthly Repayment change "<actualMonthlyPaymentValue1>" to "<actualMonthlyPaymentValue2>"

    Examples:
      |loanTermValue1|loanTermValue2|actualTotalAmountRepayable1|actualTotalAmountRepayable2|actualMonthlyPaymentValue1|actualMonthlyPaymentValue2|
      |12 months|60 months|£12,638.69|£19,935.62|£1,053.22|£332.26|

  Scenario:4-User is testing Get my Quote button
    When User click the Get my Quote button
    Then User should able to see the this url "https://secure2.livelend.co/customer/details/URL."

  Scenario:5-User is closing browser
     Then User close browser


