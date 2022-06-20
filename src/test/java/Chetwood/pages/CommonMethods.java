package Chetwood.pages;

import Chetwood.utilities.GenericFunctions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class CommonMethods  extends GenericFunctions {
    public void assertGetLinkTextWith(String linkText1,String lintext2){
        try{

            Assert.assertEquals(linkText1,lintext2);

        } catch (NoSuchElementException e){
            Assert.fail("Link text can not found on the page");
            e.printStackTrace();
        }

    }
}
