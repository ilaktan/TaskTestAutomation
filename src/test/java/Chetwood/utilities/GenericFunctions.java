package Chetwood.utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import java.util.Arrays;

public class GenericFunctions {

    public static WebDriver driver;
    public static JavascriptExecutor jse;

    public  void get() {
        if (driver == null) {
            // this line will tell which browser should open based on the value from properties file
            String browser = ConfigurationReader.get("browser");
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("start-maximized");
                    options.setExperimentalOption("excludeSwitches",  Arrays.asList("disable-popup-blocking"));
                    options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                    options.setExperimentalOption("useAutomationExtension", false);
                    //   options.addArguments("--incognito");
                    options.addArguments("--ignore-certificate-errors");
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();

                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    driver.manage().window().maximize();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    driver.manage().window().maximize();
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    driver.manage().window().maximize();
                    break;

                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Edge");
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    break;

                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support Safari");
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                    break;
            }

        }


    }

    public void userOnTheLiveLendWebsiteHomepage(){
        try {

            driver.get(ConfigurationReader.get("URL_UAT"));
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(ConfigurationReader.get("implicitlyWait")), TimeUnit.SECONDS);
            wait(1000);


        } catch (Exception e) {
            System.err.println("INFO - failed to open application");
        }
    }
    public void waitFor(int seconds) {
        try {
            System.out.println("INFO - paused execution for " + seconds + " secs");
            Thread.currentThread().sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    public void click(String xpath){

        try {

            driver.findElement(By.xpath(xpath)).click();
        } catch (Exception e) {
            System.err.println("INFO - failed to click xpath:" + xpath);
        }



    }
    public boolean waitForElement(String xpath) {
        try {
            boolean appeared = true;
            WebDriverWait wait = new WebDriverWait(driver, 200);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            wait.ignoring(NoSuchElementException.class);
            return appeared;
        } catch (Exception e) {
            return false;
        }
    }
    public void highElement(WebElement ele) {
        try {
            jse.executeScript("arguments[0].setAttribute('style', 'background: pale blue; border: 2px solid orange;');",
                    ele);
        } catch (Throwable e) {
            //  System.err.println("INFO - Failed to highlight element");
        }
    }
    public boolean isElementClickable(String xpath) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            @SuppressWarnings("unused")
            WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            highElement(driver.findElement(By.xpath(xpath)));
            System.out.println("INFO - element is clickable " + xpath);
            // unhighlightElement(driver.findElement(By.xpath(xpath)));
            return true;
        } catch (Exception e) {
            System.err.println("INFO - element is not clickable " + xpath);
            return false;
        }
    }



}
