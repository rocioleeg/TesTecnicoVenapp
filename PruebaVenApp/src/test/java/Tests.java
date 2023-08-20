import Proyecto.Steps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {
    private AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;
    private Steps steps;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appPackage", "com.techandpeople.techchat.app");
        desiredCapabilities.setCapability("appActivity", "com.techandpeople.techchat.app.MainActivity");
        desiredCapabilities.setCapability("noReset", true);
        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(url, desiredCapabilities);
        wait = new WebDriverWait(driver, 30);
        steps = new Steps(driver, wait);
    }


    @Test
    public void a_validarInformacionPersonal() {
        try {
            steps.clickLine();
            steps.clickNewReport();
            steps.clickOk();
            steps.clickDesplegableTipoDeReporte();
            steps.seleccionarServicio();
            steps.clickDesplegaBleCategoria();
            steps.seleccionarCategoria();
            steps.clickDesplegableSubcategoria();
            steps.seleccionarSubCategoria();
            steps.clickBotonNext();
            steps.clickCardStaffReport();
            steps.clickBotonNext();
            steps.validarCamposInformacionPersonal();
            steps.validarId("V42251674");
            steps.validarName("rocio giovanna lee");
            steps.validarAge("22");
            steps.validarEmail("rociogiovannalee@gmail.com");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void b_completarCamposRequeridos() {
        try {
            steps.clickLine();
            steps.clickBotonNextInconclusiveReport();
            steps.inputState("Apure");
            steps.inputMunicipality("Achaguas");
            steps.inputParish("Apurito");
            steps.inputAdress("CallePrueba 1234");
            steps.clickBotonNext();
            steps.validarTitleySubTitleReportDetail();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void c_testDetalleDelReporte() {
        try {
            steps.clickLine();
            steps.clickBotonNextInconclusiveReport();
            steps.clickCalendario();
            steps.validarFechaActual();
            steps.inputTitle("TEST_QA_AUTOMATION");
            steps.inputDescription("Prueba");
            steps.clickBotonNext();
            steps.validarTitleySubTitleReportDetail();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void d_validarUbicacionFueradeCobertura() {
        try {
            steps.clickLine();
            steps.clickBotonNextInconclusiveReport();
            steps.validarUbicacionFueraDecobertura();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}