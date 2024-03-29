package mlhuillier.qcl.utilities.driverInstance;

import mlhuillier.qcl.utilities.propertyfilereader.PropertyFileReader;
import mlhuillier.qcl.utilities.ExtentReporter;
import mlhuillier.qcl.utilities.LoggingUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;

public class CommandBase extends DriverInstance {
	
	/** Time out */
	private int timeout;

	/** Retry Count */
	private int retryCount;

	ExtentReporter extent = new ExtentReporter();

	/** The Constant logger. */
	static LoggingUtils logger = new LoggingUtils();

	/** The Android driver. */
	public AndroidDriver<AndroidElement> androidDriver;
	
	/** The Android driver. */
	public IOSDriver<WebElement> iOSDriver;
	

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}

	public CommandBase(String Application, String deviceName, String portno)  {
		super(Application,deviceName,portno);
		init();
	}
	

	public void init() {

		PropertyFileReader handler = new PropertyFileReader("properties/Execution.properties");
		setTimeout(Integer.parseInt(handler.getproperty("TIMEOUT")));
		setRetryCount(Integer.parseInt(handler.getproperty("RETRY_COUNT")));
	}

}
