import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.util.*;
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
    public void sampleTest() throws Exception{


        driver.get("https://t3-pmic-ac.cs67.force.com/agency/login");
        WebElement username = driver.findElement(By.id("username"));
        boolean eleSelected = username.isDisplayed();
        if (eleSelected = true)
            username.sendKeys("a155860@pmic.com.t3");

        //password
        WebElement pwd = driver.findElement(By.id("password"));
        pwd.sendKeys("Passwrd1");

        Thread.sleep(100);

        //Login
        WebElement btnLogin = driver.findElement(By.id("Login"));
        btnLogin.click();

        List contextNames = driver.getContextHandles();
        for (string contextName : contextNames) {
            System.out.println(contextNames);
        }
        Thread.sleep(15000);
        MobileElement el2 = (MobileElement) driver.findElementById("173:0");
        el2.sendKeys("test123");

        MobileElement el1 = (MobileElement) driver.findElementByName("Leads");
       el1.click();
    }

    @AfterTest
    public void tearDown() {
        //driver.quit();
    }
}
