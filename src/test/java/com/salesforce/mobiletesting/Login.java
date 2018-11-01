package com.salesforce.mobiletesting;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Login {
    private AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("browserName", "chrome");
        desiredCapabilities.setCapability("deviceName", "330092f1297172c7");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("chromedriverExecutable", "C:\\Users\\a152330\\AppData\\Local\\Programs\\appium-desktop\\resources\\app\\node_modules\\appium\\node_modules\\appium-chromedriver\\chromedriver\\win\\chromedriver.exe");
        desiredCapabilities.setCapability("platformVersion", "7.0");
        desiredCapabilities.setCapability("noReset", "True");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

        String webContext = getWebContext(driver);
        driver.context("CHROMIUM");
    }

    @Test
    private String getWebContext(AppiumDriver driver) {
        ArrayList<String> contexts = new ArrayList(driver.getContextHandles());
        for (String context : contexts) {
            System.out.println(context.toString());
            if (!context.equals("NATIVE_APP")) {
                return context;
            }
        }
        return null;
    }

    @Test
    public void Login() throws Exception {


        //wait
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // URL remoteUrl = new URL("https://t1-pmic-ac.cs94.force.com/agency/s/login");
        driver.get("https://t1-pmic-ac.cs94.force.com/agency/s/login");
        Thread.sleep(5000);
        By username = MobileBy.id("61:2;a");
        By pwd = MobileBy.id("73:2;a");
        //  By btnLogin =  MobileBy.("81:2;a");
        WebElement btnLogin = driver.findElementByTagName("button");

        //   WebElement btnLogin = driver.findElement(By.tagName(""))
//        btnLogin.click();
        //MobileElement username = (MobileElement) driver.findElementById("61:2;a");
        //WebElement username = driver.findElement(By.id("61:2;a"));
        wait.until(ExpectedConditions.presenceOfElementLocated(username)).sendKeys("a155860@pmic.com.t1");
        wait.until(ExpectedConditions.presenceOfElementLocated(pwd)).sendKeys("Passwrd3");
        btnLogin.click();
    }

    @Test
    public void SelectLeadQueue() throws Exception
    {
        Thread.sleep(10000);
        //driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.ByLinkText.linkText("Leads")));
        element.click();

        Thread.sleep(15000);
        //List<WebElement> list =  driver.findElements(By.name("selectedViewName"));
       //WebElement drpDown =  list.get(0);

        By drpDown = MobileBy.id("779:0");
        //wait.until(ExpectedConditions.presenceOfElementLocated(drpDown)).click();
        //drpDown.findElement(By).click();

        Select oSelect = new Select(driver.findElement(By.name("selectedViewName")));
        //List options = oSelect.getOptions();
        oSelect.selectByVisibleText("All Leads Declined");

       // driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    @Test
    public void SetFilterOptions() throws Exception
    {
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 10);

//
//        System.out.println(els.size());
//        //System.out.println( els.get(i).getCssValue());
//        for (int i=0;i<els.size();i++)
//            if (els.get(i).getText().equals("Click To Show Filter Options") && els.get(i).getTagName().equals("lightning-icon")) {
//                //System.out.println( els.get(i).getText());
//                System.out.printf("tagName: %s%n", els.get(i).getTagName());
//                els.get(i).click();
//                break;
//            }
//        click on down arrow
        driver.findElement(By.cssSelector("lightning-icon[title='Click To Show Filter Options']")).click();
        Thread.sleep(100);

        //driver.findElement(By.id("40:249;a")).click();
        List<WebElement> els = driver.findElements(By.tagName("select"));

        for (int i=0;i<els.size();i++)
        {
            Select FltrColumn = new Select(els.get(i));
            String FilterColumn = "Lead Name";
            String FilterCondition = "Equal To";
            Integer size = FltrColumn.getOptions().size();
            System.out.println(FltrColumn.getOptions().size());
            //boolean b = size.intValue() == 11;
            if (  size.intValue() == 11)
            {


                FltrColumn.selectByVisibleText(FilterColumn);
            }

            if (  size.intValue() == 5)
                FltrColumn.selectByVisibleText(FilterCondition);
           // System.out.println(els.get(i).getText());
        }

        driver.findElement(By.cssSelector("id=input*")).sendKeys("Deb Heilig");

        driver.findElement(By.cssSelector("button[class='slds-button slds-button_neutral']")).click();

    }


    @AfterTest
    public void tearDown() {
       // driver.quit();
    }
}
