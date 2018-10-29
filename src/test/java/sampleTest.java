import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;

public class sampleTest {

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
    public void sampleTest() throws Exception{
        String webContext = getWebContext(driver);
        driver.context("CHROMIUM");

        //wait
        WebDriverWait wait = new WebDriverWait(driver, 10);

       // URL remoteUrl = new URL("https://t1-pmic-ac.cs94.force.com/agency/s/login");
        driver.get("https://t1-pmic-ac.cs94.force.com/agency/s/login");
        Thread.sleep(5000);
        By username = MobileBy.id("61:2;a");
        By pwd =  MobileBy.id("73:2;a");
      //  By btnLogin =  MobileBy.("81:2;a");
        WebElement btnLogin =  driver.findElementByTagName("button");

     //   WebElement btnLogin = driver.findElement(By.tagName(""))
//        btnLogin.click();
        //MobileElement username = (MobileElement) driver.findElementById("61:2;a");
         //WebElement username = driver.findElement(By.id("61:2;a"));
        wait.until(ExpectedConditions.presenceOfElementLocated(username)).sendKeys("a155860@pmic.com.t1");
        wait.until(ExpectedConditions.presenceOfElementLocated(pwd)).sendKeys("Passwrd3");
        btnLogin.click();
//        List<WebElement> els = driver.findElements(By.xpath(".//input"));
//        System.out.println(els.size());
//        for (int i=0;i<els.size();i++) {
//            if ( els.get(i).getTagName().equals("input"))
//                System.out.println( els.get(i).getText());
//            //System.out.println( els.get(i).getTagName().equals("input"));
//            //System.out.println( els.get(i).getCssValue());
//        }





//        boolean eleSelected = username.isDisplayed();
//        if (eleSelected = true)
//            username.sendKeys("a155860@pmic.com.t1");

        //password
      //  WebElement pwd = driver.findElement(By.id("73:2;a"));
//       MobileElement pwd = (MobileElement) driver.findElementById("73:2;a");
//       pwd.sendKeys("Passwrd3");

        Thread.sleep(100);

        //Login
//        WebElement btnLogin = driver.findElement(By.id("Login"));
//        btnLogin.click();

//        List contextNames = driver.getContextHandles();
//        for (string contextName : contextNames) {
//            System.out.println(contextNames);
//        }
        Thread.sleep(5000);
        // Get into the webview and assert that we're not yet at the correct page

        driver.findElement(By.linkText("Leads")).click();
        Thread.sleep(15000);

            List<WebElement> list =  driver.findElements(By.name("selectedViewName"));
        //list.get(0).findElements(By.)
            //list.selectByVisibleText("Great Plains Lead Queue");

            list.get(0).click();

        List<WebElement> optionslist =  driver.findElements(By.tagName("option"));
        System.out.println(optionslist.size());

     //   List<WebElement> els = driver.findElements(By.linkText("Leads"));
      //  System.out.println(els.size());
//        for (int i=0;i<els.size();i++) {
//
//            if (els.get(i).getText().contains("Leads")) {
//                System.out.println(els.get(i).getText());
//                els.get(i).click();
//            }
////            if (els.get(i).getText().contains("Leads")) {
////
////              //  List<WebElement> els2 = els.get(i).findElements(By.tagName("li"));
////              //  System.out.println(els2.size());
////               // System.out.println(els.get(i).getText());
////                //els.get(i).click();
////            }
//        }
    //    String pageSource = driver.getPageSource();
      //  System.out.println(pageSource);


        //MobileElement el2 = (MobileElement) driver.findElementById("173:0");
        //el2.sendKeys("test123");

        //  driver.switchTo().frame((MobileElement) driver.findElement(MobileBy.id("com.android.chrome:id/action_bar_root")));
        //android:id/content
        //com.android.chrome:id/coordinator
        //com.android.chrome:id/compositor_view_holder
//        MobileElement el1 = (MobileElement) driver.findElementByName("Leads");
//       el1.click();
//        (new TouchAction(driver)).tap(302, 413).perform();
//        Thread.sleep(25000);
//        (new TouchAction(driver)).tap(315, 842).perform();
//        Thread.sleep(25000);
        //List icons = driver.findElementsByClassName("android.view.ListView");
       // System.out.println(icons.size());
//        MobileElement FindNumberSelect = (MobileElement) driver.findElementById("input-40:903;a");
//        FindNumberSelect.click();
//        MobileElement el2 = (MobileElement) driver.findElementById("input-573");
//        el2.click();
//        MobileElement el3 = (MobileElement) driver.findElementById("55:903;a");
//        el3.click();


    }

    @AfterTest
    public void tearDown() {
        //driver.quit();
    }
}
