package Chetwood.pages;

import Chetwood.utilities.GenericFunctions;
import org.openqa.selenium.By;

public class Login extends GenericFunctions {
    CommonMethods commonMethods = new CommonMethods();

    public  void userClickTheAcceptButton(){
        waitForElement("//*[text()='Accept']");
        //waitFor(2);
        driver.findElement(By.xpath("//*[text()='Accept']")).click();


    }
    public  void userCloseBrowser(){
        waitFor(2);
        closeDriver();



    }

}

