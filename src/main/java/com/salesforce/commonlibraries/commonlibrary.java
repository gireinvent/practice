package com.salesforce.commonlibraries;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class commonlibrary {
    public static void login(String struserName, String strPwd, ChromeDriver driver)  throws Exception
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Thread.sleep(3000);
        WebElement element =driver.findElement(By.id("61:2;a"));
//        List<WebElement> els = driver.findElements(By.tagName("input"));
//        System.out.println( els.get(0).getCssValue("placeholder"));
//        System.out.println( els.get(0).getText());


        element.sendKeys(struserName);

        WebElement element2=driver.findElement(By.id("73:2;a"));
        element2.sendKeys(strPwd);

        WebElement button=driver.findElementByTagName("button");//driver.findElement(By.id("Login"));
        button.click();
    }

    @Test
    public void SelectLeadQueue(ChromeDriver driver) throws Exception
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
}
