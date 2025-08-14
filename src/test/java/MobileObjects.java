import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MobileObjects {
    private AppiumDriver driver;

    public MobileObjects(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    // Input field
    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/userInput")
    public MobileElement el1;

    // Button "Change Text"
    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonChange")
    public MobileElement el2;

    // Text on top page
    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/textToBeChanged")
    public MobileElement el3;

    // Button for change activity
    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonActivity")
    public MobileElement el4;

    // Text on new activity
    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/text")
    public MobileElement el5;
}
