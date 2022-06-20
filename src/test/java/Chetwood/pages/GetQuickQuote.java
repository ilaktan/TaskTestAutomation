package Chetwood.pages;
import Chetwood.utilities.GenericFunctions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class GetQuickQuote extends GenericFunctions {

    CommonMethods commonMethods = new CommonMethods();

    static String expectedMonthlyPaymentValue1;
    static String expectedMonthlyPaymentValue2;
    static String expectedTotalAmountRepayable1;
    static String expectedTotalAmountRepayable2;

    public void userOpenTheBrowserAmountSliderOnTheAmountLoanTermOnTheMonthlyRepaymentOnTheTotalAmountRepayableOnThe(String borrowAmount,String month,String monthlyRepayment,String totalAmountRepayable) {

        Assert.assertEquals("borrowAmount different",borrowAmount,driver.findElement(By.xpath("(//span)[1]")).getText());
        Assert.assertEquals("month different",month,driver.findElement(By.xpath("(//div[@class='range-box'])[2]/h3")).getText());
        Assert.assertEquals("monthlyRepayment different",monthlyRepayment,driver.findElement(By.xpath("(//span)[4]")).getText());
        Assert.assertEquals("totalAmountRepayable different",totalAmountRepayable,driver.findElement(By.xpath("(//span)[7]")).getText());

    }
    public void userMoveTheBorrowAmountSliderFromBetweenToWithThisAmountToInMonth(String arg0, String arg1, String borrowAmount1, String borrowAmount2,String months) {

        Actions moveSlider = new Actions(driver);
        Action action = moveSlider.dragAndDropBy(driver.findElement(By.xpath("//input[@id='loanAmount']")), -209, 0).build();

        Actions moveSlider2 = new Actions(driver);
        Action action2 = moveSlider2.dragAndDropBy(driver.findElement(By.xpath("//input[@id='loanAmount']")), 109, 0).build();

        action.perform();
        waitForElement("(//span)[1]");
        Assert.assertEquals("total amount different",borrowAmount1,driver.findElement(By.xpath("(//span)[1]")).getText());

        expectedTotalAmountRepayable1=driver.findElement(By.xpath("(//span)[7]")).getText();
        expectedMonthlyPaymentValue1=driver.findElement(By.xpath("(//span)[4]")).getText();

        action2.perform();
        waitForElement("(//span)[1]");
        Assert.assertEquals("total amount different",borrowAmount2,driver.findElement(By.xpath("(//span)[1]")).getText());

        expectedTotalAmountRepayable2=driver.findElement(By.xpath("(//span)[7]")).getText();
        expectedMonthlyPaymentValue2=driver.findElement(By.xpath("(//span)[4]")).getText();

        Assert.assertEquals("month different",months,driver.findElement(By.xpath("(//div[@class='range-box'])[2]/h3")).getText());



    }
    public void userShouldAbleToSeeTotalAmountRepayableChangeTo(String actualTotalAmountRepayable1,String actualTotalAmountRepayable2) {

        Assert.assertEquals(expectedTotalAmountRepayable1,actualTotalAmountRepayable1);
        Assert.assertEquals(expectedTotalAmountRepayable2,actualTotalAmountRepayable2);

       // waitFor(1);

    }
    public void userShouldAbleToSeeMonthlyRepaymentChangeTo(String actualMonthlyPaymentValue1,String actualMonthlyPaymentValue2) {

        Assert.assertEquals(expectedMonthlyPaymentValue1,actualMonthlyPaymentValue1);
        Assert.assertEquals(expectedMonthlyPaymentValue2,actualMonthlyPaymentValue2);
        //waitFor(1);


    }

    public void userMoveTheLoanTermSliderFromBetweenToWithThisMonthToInThisBorrowAmount(String arg0, String arg1, String loanTermValue1, String loanTermValue2,String months) {

        Actions moveSlider = new Actions(driver);
        Action action = moveSlider.dragAndDropBy(driver.findElement(By.xpath("//input[@id='termAmount']")), -209, 0).build();

        Actions moveSlider2 = new Actions(driver);
        Action action2 = moveSlider2.dragAndDropBy(driver.findElement(By.xpath("//input[@id='termAmount']")), 130, 0).build();

        action.perform();
        waitForElement("(//div[@class='range-box'])[2]/h3");
        Assert.assertEquals("loan term different",loanTermValue1,driver.findElement(By.xpath("(//div[@class='range-box'])[2]/h3")).getText());

        expectedTotalAmountRepayable1=driver.findElement(By.xpath("(//span)[7]")).getText();
        expectedMonthlyPaymentValue1=driver.findElement(By.xpath("(//span)[4]")).getText();

        action2.perform();
        waitForElement("(//div[@class='range-box'])[2]/h3");
        Assert.assertEquals("loan term different",loanTermValue2,driver.findElement(By.xpath("(//div[@class='range-box'])[2]/h3")).getText());

        expectedTotalAmountRepayable2=driver.findElement(By.xpath("(//span)[7]")).getText();
        expectedMonthlyPaymentValue2=driver.findElement(By.xpath("(//span)[4]")).getText();



    }
    public void userClickTheGetMyQuoteButton (){
        isElementClickable("//*[text()='Get my quote']");
        click("//*[text()='Get my quote']");
        //waitFor(2);



    }
    public void userShouldAbleToSeeTheThisUrl (String url2){

        waitForElement("//*[text()='Your personalised rate in 3 steps']");

        String url1=driver.getCurrentUrl();

        System.out.println("url1 = " + url1);
        System.out.println("url2 = " + url2);
        commonMethods.assertGetLinkTextWith(url1,url2);
        waitFor(1);



    }

}
