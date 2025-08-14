import static org.junit.Assert.assertEquals;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.remote.DesiredCapabilities;

public class SampleTest {
    private AppiumDriver driver;
    private MobileObjects mobileObjects;

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Before
    public void setUp() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Some name");

        // Запуск приложения для установки
        // desiredCapabilities.setCapability("appium:app", "./app/build/intermediates/apk/debug/app-debug.apk");

        // Запуск установленного приложения
        desiredCapabilities.setCapability("appPackage", "ru.netology.testing.uiautomator");
        desiredCapabilities.setCapability("appActivity", ".MainActivity");

        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        driver = new AndroidDriver(getUrl(), desiredCapabilities);

        mobileObjects = new MobileObjects(driver);
    }

    @Test
    public void testEmptyInputDoesNotChangeText() {
        var notChangedText = "Hello UiAutomator!";

        // Input field
        mobileObjects.el1.isDisplayed();
        mobileObjects.el1.sendKeys("  ");

        // Button "Change Text"
        mobileObjects.el2.isDisplayed();
        mobileObjects.el2.click();

        // Text on top page
        mobileObjects.el3.isDisplayed();
        mobileObjects.el3.click();

        assertEquals(notChangedText, mobileObjects.el3.getText());
    }

    @Test
    public void testNewActivityShowsCorrectText() {
        var changedText = "Hello from test";

        // Input field
        mobileObjects.el1.isDisplayed();
        mobileObjects.el1.sendKeys(changedText);

        // Button for change activity
        mobileObjects.el4.isDisplayed();
        mobileObjects.el4.click();

        // Text on new activity
        mobileObjects.el5.isDisplayed();
        mobileObjects.el5.click();

        assertEquals(changedText, mobileObjects.el5.getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
