package ru.netology.testing.uiautomator;

import static org.junit.Assert.assertEquals;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SecondTest {

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private AndroidDriver driver;

    @Before
    public void setUp() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Some name");
        desiredCapabilities.setCapability("appium:app", "D:\\Study\\TMA\\TMA-2-4\\app\\build\\intermediates\\apk\\debug\\app-debug.apk");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        driver = new AndroidDriver(getUrl(), desiredCapabilities);
    }

    @Test
    public void secondTest() {

        WebElement el1 = driver.findElement(AppiumBy.id("ru.netology.testing.uiautomator:id/userInput"));
        el1.isDisplayed();
        el1.sendKeys("Hello from test");

        WebElement el2 = driver.findElement(AppiumBy.id("ru.netology.testing.uiautomator:id/buttonActivity"));
        el2.isDisplayed();
        el2.click();

        WebElement el3 = driver.findElement(AppiumBy.id("ru.netology.testing.uiautomator:id/text"));
        el3.isDisplayed();
        el3.click();

        assertEquals("Hello UIAutomator!", el3.getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
