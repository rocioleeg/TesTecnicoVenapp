package Proyecto;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static io.appium.java_client.touch.WaitOptions.waitOptions;

public class Base {
   // private AppiumDriver driver;
   static AndroidDriver<WebElement> driver;
    public Base(WebDriver driver) {
        this.driver = (AndroidDriver<WebElement>) driver;
    }


    public WebElement findElement(By locator) {
        MobileElement element = (MobileElement) driver.findElement(locator);
        return element;
    }

    public String getText(MobileElement element) {
        return element.getText();
    }


    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator) {
        driver.findElement(locator).sendKeys(inputText);
    }

    public void sendKeys(String inputText, By locator) {
        MobileElement element = (MobileElement) driver.findElement(locator);
        element.sendKeys(inputText);
    }
    public static void sendKeysAndCloseKeyboard( String inputText, By locator) {
        MobileElement element = (MobileElement) driver.findElement(locator);
        element.sendKeys(inputText);

        // Cerrar el teclado presionando la tecla BACK (retroceso)
        try {
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public void click(By locator) {
        driver.findElement(locator).click();

    }

    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();

        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void waitForElementClickable(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        MobileElement element = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(by));
    }


    public void visit(String url) {
        driver.get(url);
    }

    public static void scrollSegunText( String text) {
        String uiAutomator = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + text + "\").instance(0))";
        driver.findElement(MobileBy.AndroidUIAutomator(uiAutomator));
    }






}

