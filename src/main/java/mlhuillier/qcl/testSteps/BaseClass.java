package mlhuillier.qcl.testSteps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import mlhuillier.qcl.utilities.driverInstance.CommandBase;
import mlhuillier.qcl.utilities.driverInstance.DriverManager;
import mlhuillier.qcl.utilities.propertyfilereader.PropertyFileReader;
import mlhuillier.qcl.utilities.ExtentReporter;
import mlhuillier.qcl.utilities.LoggingUtils;
import org.testng.annotations.BeforeTest;

import static mlhuillier.qcl.utilities.ExtentReporter.platform;
import static mlhuillier.qcl.utilities.Utilities.*;

public class BaseClass {

    static String oSPlatformName = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getSuite().getName();
    public static LoggingUtils logger = new LoggingUtils();
    public static PropertyFileReader prop;
    WebDriver driver = getWebDriver();
    public static PropertyFileReader accountCredential;
    public static String os = System.getProperty("os.name").toLowerCase();
    public static String osName=System.getProperty("os.name").toLowerCase();

    //To Load Properties file as per running platform
    public void propertyFileReader() {
        if(osName.contains("mac") || osName.contains("linux")){
            prop = new PropertyFileReader(".//dto//testdata.properties");
        }else {
            prop = new PropertyFileReader(".\\dto\\testdata.properties");
        }
    }

    public void accountCredentialReader(){
        accountCredential = new PropertyFileReader ( ".//dto//accountCredential.properties" );
    }

    //0-Param Constructor
    public BaseClass() {

    }

    //3-Param Constructor
    public BaseClass(String Application, String deviceName, String portno) throws InterruptedException {
        new CommandBase(Application, deviceName, portno);
        accountCredentialReader();
        propertyFileReader();
    }


    //Tear Down Application
    public void tearDown() {
        if (platform.equalsIgnoreCase("Web")) {
            closeWebBrowser();
        } else {
            logger.info("Session ID: " + ((RemoteWebDriver) DriverManager.getAppiumDriver()).getSessionId());
            ExtentReporter.extentLogger("", "Session ID: " + ((RemoteWebDriver) DriverManager.getAppiumDriver()).getSessionId());
            logger.info("Session is quit");
            ExtentReporter.extentLogger("", "Session is quit");
            setScreenshotSource();
            DriverManager.getAppiumDriver().quit();
        }
    }
    @BeforeTest
    public void beforeTest(){
        getDriver().manage().deleteAllCookies();
    }
}

