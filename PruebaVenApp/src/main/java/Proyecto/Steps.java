package Proyecto;

import io.appium.java_client.*;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class Steps extends Base {
    static AppiumDriver<MobileElement> driver;
    private static WebDriverWait wait;

    public Steps(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver);
        this.driver = driver;
        this.wait = wait;
    }

    public void clickLine() throws InterruptedException {
        Thread.sleep(6000);
        waitForElementClickable(By.xpath("//*[contains(@content-desc, 'Line ')]"));
        click(By.xpath("//*[contains(@content-desc, 'Line ')]"));
    }

    public void clickNewReport() {
        waitForElementClickable(new MobileBy.ByAccessibilityId("New report"));
        click(new MobileBy.ByAccessibilityId("New report"));
    }

    public void clickOk() throws InterruptedException {
        List<MobileElement> elements = driver.findElements(By.xpath("//android.widget.Button[@content-desc='OK']"));

        if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
            click(By.xpath("//android.widget.Button[@content-desc='OK']"));
        }
        Thread.sleep(1000);
    }

    public void clickDesplegableTipoDeReporte() throws InterruptedException {
        Thread.sleep(2000);
        waitForElementClickable(By.xpath("(//*[contains(@class, 'android.widget.Button')])[3]"));
        click(By.xpath("(//*[contains(@class, 'android.widget.Button')])[3]"));
    }

    public void seleccionarTipoReporte() throws InterruptedException {
        Thread.sleep(1000);
        waitForElementClickable(By.xpath("//android.view.View[@content-desc=\"Services\"]"));
        click(By.xpath("//android.view.View[@content-desc=\"Services\"]"));
    }

    public void seleccionarServicio() throws InterruptedException {
        Thread.sleep(1000);
        waitForElementClickable(new MobileBy.ByAccessibilityId("Services"));
        click(new MobileBy.ByAccessibilityId("Services"));
    }

    public void clickDesplegaBleCategoria() {
        waitForElementClickable(By.xpath("(//*[contains(@class, 'android.widget.Button')])[4]"));
        click(By.xpath("(//*[contains(@class, 'android.widget.Button')])[4]"));
    }

    public void seleccionarCategoria() {
        waitForElementClickable(new MobileBy.ByAccessibilityId("Water"));
        click(new MobileBy.ByAccessibilityId("Water"));
    }

    public void validarCamposInformacionPersonal() throws InterruptedException {
        Thread.sleep(5000);
        if (isDisplayed(new MobileBy.ByAccessibilityId("ID")) && isDisplayed(new MobileBy.ByAccessibilityId("Full name")) && isDisplayed(new MobileBy.ByAccessibilityId("Age"))
                && isDisplayed(new MobileBy.ByAccessibilityId("Email"))) {
            System.out.println("Campos validados con exito");
        } else {
            System.out.println("Alguno de los campos no pudo ser validado");
        }
    }

    public void validarId(String id) {
        WebElement elementId = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(new MobileBy.ByAccessibilityId(id)));
        Assert.assertTrue(elementId.isDisplayed());
    }

    public void validarName(String name) {
        WebElement elementName = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(new MobileBy.ByAccessibilityId(name)));
        Assert.assertTrue(elementName.isDisplayed());
    }

    public void validarAge(String age) {
        WebElement elementAge = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(new MobileBy.ByAccessibilityId(age)));
        Assert.assertTrue(elementAge.isDisplayed());
    }

    public void validarEmail(String email) {
        WebElement elementEmail = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(new MobileBy.ByAccessibilityId(email)));
        Assert.assertTrue(elementEmail.isDisplayed());
    }

    public void clickBotonNext() {
        waitForElementClickable(By.xpath(" //android.widget.Button[contains(@content-desc, 'NEXT')]"));
        click(By.xpath(" //android.widget.Button[contains(@content-desc, 'NEXT')]"));
    }

    public void clickBotonNextInconclusiveReport() throws InterruptedException {
        Thread.sleep(5000);
        waitForElementClickable(By.xpath("//android.widget.Button[@content-desc='Next']"));
        click(By.xpath("//android.widget.Button[@content-desc='Next']"));
    }

    public void clickDesplegableSubcategoria() {
        waitForElementClickable(By.xpath("(//*[contains(@class, 'android.widget.Button')])[5]"));
        click(By.xpath("(//*[contains(@class, 'android.widget.Button')])[5]"));
    }

    public void seleccionarSubCategoria() {
        waitForElementClickable(By.xpath("//*[contains(@content-desc, ' inmediata de agua potable')]"));
        click(By.xpath("//*[contains(@content-desc, ' inmediata de agua potable')]"));
    }

    public void clickCardStaffReport() {
        waitForElementClickable(By.xpath("//android.widget.ImageView[contains(@content-desc, 'Staff Report')]"));
        click(By.xpath("//android.widget.ImageView[contains(@content-desc, 'Staff Report')]"));
    }

    public static void scroll(double startX, double startY, double endX, double endY) throws InterruptedException {
        Thread.sleep(5000);
        Dimension size = driver.manage().window().getSize();
        int startXPixel = (int) (size.getWidth() * startX);
        int startYPixel = (int) (size.getHeight() * startY);
        int endXPixel = (int) (size.getWidth() * endX);
        int endYPixel = (int) (size.getHeight() * endY);

        new TouchAction<>(driver)
                .press(PointOption.point(startXPixel, startYPixel))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                .moveTo(PointOption.point(endXPixel, endYPixel))
                .release()
                .perform();
    }

    public void inputState(String state) throws InterruptedException {
        Thread.sleep(5000);
        scroll(0.5, 0.8, 0.5, 0.4);
        scroll(0.5, 0.3, 0.5, 0.34);
        Thread.sleep(1000);
        waitForElementClickable(By.xpath("(//*[contains(@class, 'android.widget.EditText')])[1]"));
        click(By.xpath("(//*[contains(@class, 'android.widget.EditText')])[1]"));
        sendKeysAndCloseKeyboard(state, By.xpath("(//*[contains(@class, 'android.widget.EditText')])[1]"));
    }

    public void inputMunicipality(String municipality) throws InterruptedException {
        Thread.sleep(2000);
        waitForElementClickable(By.xpath("(//*[contains(@class, 'android.widget.EditText')])[2]"));
        click(By.xpath("(//*[contains(@class, 'android.widget.EditText')])[2]"));
        sendKeysAndCloseKeyboard(municipality, By.xpath("(//*[contains(@class, 'android.widget.EditText')])[2]"));
    }

    public void inputParish(String parish) throws InterruptedException {
        Thread.sleep(2000);
        waitForElementClickable(By.xpath("(//*[contains(@class, 'android.widget.EditText')])[3]"));
        click(By.xpath("(//*[contains(@class, 'android.widget.EditText')])[3]"));
        sendKeysAndCloseKeyboard(parish, By.xpath("(//*[contains(@class, 'android.widget.EditText')])[3]"));
    }

    public void inputAdress(String adress) throws InterruptedException {
        Thread.sleep(2000);
        waitForElementClickable(By.xpath("(//*[contains(@class, 'android.widget.EditText')])[4]"));
        click(By.xpath("(//*[contains(@class, 'android.widget.EditText')])[4]"));
        sendKeysAndCloseKeyboard(adress, By.xpath("(//*[contains(@class, 'android.widget.EditText')])[4]"));
    }
    public void validarTitleySubTitleReportDetail() throws InterruptedException {
        WebElement elementTitle = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(new MobileBy.ByAccessibilityId("Report detail")));
        Assert.assertTrue(elementTitle.isDisplayed());
        WebElement elementSubTitle = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(new MobileBy.ByAccessibilityId("Choose the date on which the events occurred and give your report a title and description")));
        Assert.assertTrue(elementSubTitle.isDisplayed());
    }

    public void clickCalendario() throws InterruptedException {
        Thread.sleep(2000);
        waitForElementClickable(By.xpath("//*[@class='android.widget.ImageView']"));
        click(By.xpath("//*[@class='android.widget.ImageView']"));
        waitForElementClickable(By.xpath("//android.widget.Button[@content-desc='OK']"));
        click(By.xpath("//android.widget.Button[@content-desc='OK']"));

    }

    public static void validarFechaActual() throws InterruptedException {
        Thread.sleep(2000);
        MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.ImageView']")));
        String elementText = element.getText();

        SimpleDateFormat dateFormat = new SimpleDateFormat("M/dd/yyyy");
        String currentDate = dateFormat.format(new Date());
        String elementDate = elementText;

        try {
            Date currentDateObj = dateFormat.parse(currentDate);
            Date elementDateObj = dateFormat.parse(elementDate);

            Assert.assertTrue("La fecha es posterior a la fecha actual", !elementDateObj.after(currentDateObj));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inputTitle(String titulo) throws InterruptedException {
        Thread.sleep(1000);
        waitForElementClickable(By.xpath("//*[@class='android.widget.EditText'][1]"));
        click(By.xpath("//*[@class='android.widget.EditText'][1]"));
        sendKeysAndCloseKeyboard(titulo, By.xpath("//*[@class='android.widget.EditText'][1]"));
    }


    public void inputDescription(String descripcion) throws InterruptedException {
        waitForElementClickable(By.xpath("//*[@class='android.widget.EditText'][2]"));
        click(By.xpath("//*[@class='android.widget.EditText'][2]"));
        sendKeysAndCloseKeyboard(descripcion, By.xpath("//*[@class='android.widget.EditText'][2]"));
    }


    public static void zoomOutMap() throws InterruptedException {
        Thread.sleep(4000);
        MobileElement mapElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='android.widget.ImageView'])[2]")));
        Dimension size = mapElement.getSize();
        int centerX = size.getWidth() / 2;
        int centerY = size.getHeight() / 2;

        int startDistance = (int) (size.getHeight() * 0.8);//
        int endDistance = (int) (size.getHeight() * 0.6);

        TouchAction action1 = new TouchAction(driver)
                .press(ElementOption.element(mapElement, centerX, centerY - startDistance))
                .moveTo(ElementOption.element(mapElement, centerX, centerY - endDistance))
                .release();

        TouchAction action2 = new TouchAction(driver)
                .press(ElementOption.element(mapElement, centerX, centerY + startDistance))
                .moveTo(ElementOption.element(mapElement, centerX, centerY + endDistance))
                .release();

        MultiTouchAction multiTouch = new MultiTouchAction(driver);
        multiTouch.add(action1).add(action2).perform();
    }


    public void ubicacionActualMapa() throws InterruptedException {
        waitForElementClickable(By.xpath(" (//*[@class='android.widget.ImageView'])[2]"));
        click(By.xpath(" (//*[@class='android.widget.ImageView'])[2]"));
    }

    public void validarUbicacionFueraDecobertura() throws InterruptedException {
        Thread.sleep(2000);
        clickBotonNext();
        clickOk();
        MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[contains(@content-desc, 'Out of available coordinates')]")));
        element.isDisplayed();
    }


}
