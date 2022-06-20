package Chetwood.step_definitions;
import Chetwood.utilities.Pages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetQuickQuoteStepDef {
    Pages pages = new Pages();

    @When("User open the browser Amount Slider on the {string} amount loan term on the {string} Monthly Repayment on the {string} Total amount repayable on the {string}")
    public void userOpenTheBrowserAmountSliderOnTheAmountLoanTermOnTheMonthlyRepaymentOnTheTotalAmountRepayableOnThe(String arg0, String arg1, String arg2, String arg3) {
        pages.getQuickQuote().userOpenTheBrowserAmountSliderOnTheAmountLoanTermOnTheMonthlyRepaymentOnTheTotalAmountRepayableOnThe(arg0,arg1,arg2,arg3);

    }
    @When("User move the borrow amount slider from between {string} to {string} with this amount {string} to {string} in month {string}")
    public void userMoveTheBorrowAmountSliderFromBetweenToWithThisAmountToInMonth(String arg0, String arg1, String arg2, String arg3, String arg4) {
        pages.getQuickQuote().userMoveTheBorrowAmountSliderFromBetweenToWithThisAmountToInMonth(arg0,arg1,arg2,arg3,arg4);
    }
    @And("User should able to see Total Amount Repayable change {string} to {string}")
    public void userShouldAbleToSeeTotalAmountRepayableChangeTo(String arg0, String arg1) {
        pages.getQuickQuote().userShouldAbleToSeeTotalAmountRepayableChangeTo(arg0,arg1);

    }
    @Then("User should able to see Monthly Repayment change {string} to {string}")
    public void userShouldAbleToSeeMonthlyRepaymentChangeTo(String arg0, String arg1) {
        pages.getQuickQuote().userShouldAbleToSeeMonthlyRepaymentChangeTo(arg0,arg1);

    }

    @When("User move the loan term slider from between {string} to {string} with this month {string} to {string} in this borrow amount {string}")
    public void userMoveTheLoanTermSliderFromBetweenToWithThisMonthToInThisBorrowAmount(String arg0, String arg1, String arg2, String arg3, String arg4) {
        pages.getQuickQuote().userMoveTheLoanTermSliderFromBetweenToWithThisMonthToInThisBorrowAmount(arg0,arg1,arg2,arg3,arg4);
    }

    @When("User click the Get my Quote button")
    public void userClickTheGetMyQuoteButton() {
        pages.getQuickQuote().userClickTheGetMyQuoteButton();


    }

    @Then("User should able to see the this url {string}")
    public void userShouldAbleToSeeTheThisUrl(String arg0) {
        pages.getQuickQuote().userShouldAbleToSeeTheThisUrl(arg0);

    }
}
