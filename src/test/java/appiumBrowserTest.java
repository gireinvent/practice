import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class appiumBrowserTest
{

    WebDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {

        // Created object of DesiredCapabilities class.
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set android deviceName desired capability. Set your device name.
        capabilities.setCapability("deviceName", "emulator-5554");

        // Set BROWSER_NAME desired capability. It's Android in our case here.
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");

        // Set android VERSION desired capability. Set your mobile device's OS version.
        //capabilities.setCapability(CapabilityType.VERSION, "8.1.0");

        // Set android platformName desired capability. It's Android in our case here.
        capabilities.setCapability("platformName", "Android");
        //capabilities.setCapability();
        capabilities.setCapability("chromedriverExecutable", "C:\\Users\\a152330\\AppData\\Local\\Programs\\appium-desktop\\resources\\app\\node_modules\\appium\\node_modules\\appium-chromedriver\\chromedriver\\win\\chromedriver.exe");
        //no set true

        //System.setProperty("RemoteWebDriver.chrome.driver","C:\\Users\\a152330\\Downloads\\chromedriver_win32\\chromedriver.exe");
        // Set android appPackage desired capability. It is
        // com.google.android.calculator for calculator application.
        // Set your application's appPackage if you are using any other app.
        //capabilities.setCapability("appPackage", "com.google.android.calculator");

        // Set android appActivity desired capability. It is
        // com.android.calculator2.Calculator for calculator application.
        // Set your application's appPackage if you are using any other app.
        //capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        // Created object of RemoteWebDriver will all set capabilities.
        // Set appium server address and port number in URL string.
        // It will launch calculator app in android device.
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @Test
    public void Login() throws Exception{



        driver.get("https://t3-pmic-ac.cs67.force.com/agency/login");
        Thread.sleep(100);

        //username
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


        //List<WebElement> calcButtons = driver.findElements(By.xpath("//android.widget.Button"));
        //calcButtons.get(0).click();

        List<WebElement> li = driver.findElements(By.className("android.widget.Button"));

        li.get(0).click();

        // WebElement keyword = driver.findElement(By.name("q"));
        //keyword.sendKeys("appium");
        //
        //driver.findElement(By.id("btnK")).click();
        //By.className("android.widget.Button").findElement(driver).click();
        //driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+partialtext+"\")")
        // By.class("android.widget.Button")).click();
        Thread.sleep(5000);

    }
//
//    @AfterTest
//    public void Lead() throws Exception{
//        List<WebElement> calcButtons = driver.findElements(By.xpath("//android.widget.Button"));
//        calcButtons.get(0).click();
//
//    }


    @AfterTest
    public void End() {
        //driver.quit();
    }
}
