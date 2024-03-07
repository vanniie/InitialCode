package mlhuillier.qcl.testSteps.testExecution;

import mlhuillier.qcl.pageObject.LoginPage;
import mlhuillier.qcl.testSteps.BaseClass;
import mlhuillier.qcl.utilities.TOTPGenerator;
import org.openqa.selenium.WebDriver;

import static mlhuillier.qcl.testSteps.BaseClass.accountCredential;
import static mlhuillier.qcl.utilities.Utilities.*;

public class TestExecutionUtils extends BaseClass {
    public static WebDriver driver = getWebDriver();
    public static String originalWindowHandle = driver.getWindowHandle();

    public static void signInQCLWeb()throws Exception {
        signInWithGoogle();
        signInQCL();
    }


    public static void  signInWithGoogle() throws Exception {
        waitTime(2000);
        click( LoginPage.kpxlogin , "Click the Log in KPX");
        verifyElementPresent(LoginPage.googleSign, "google sign in");
        click(LoginPage.googleSign, "google sign in btn");
        waitTime(2000);
        String handle = originalWindowHandle;
        driver.switchTo().window(driver.getWindowHandles().toArray(new String[0])[1]);
        waitTime(3000);
        verifyElementPresent(LoginPage.email_google, "email input");
        type(LoginPage.email_google, accountCredential.getproperty("email"), "email inputted");
        click(LoginPage.nextBtn_google, "next btn");
        verifyElementPresent(LoginPage.password_google, "password input");
        waitTime(2000);
        type(LoginPage.password_google, accountCredential.getproperty("password"), "password inputted");
        click(LoginPage.nextBtn_google, "next btn");
        waitTime(5000);
        scrollToBottomOfPageWEB();
        verifyElementPresentAndClick(LoginPage.try_another_way_google, "another way option");
        waitTime(4000);
        scrollToBottomOfPageWEB();
        verifyElementPresentAndClick(LoginPage.enter_back_up_codes_google, "Authenticator");
        waitTime(2000);
        verifyElementPresent(LoginPage.input_back_up_codes_google, "backup code input text");
        waitTime(2000);
        driver.findElement(LoginPage.input_back_up_codes_google).sendKeys( TOTPGenerator.getTwoFactorCode());
        click(LoginPage.nextBtn_google, "next btn");
    }

    public static void signInQCL() throws Exception {
        waitTime(2000);
        driver.switchTo().window(originalWindowHandle);
        verifyElementPresent(LoginPage.LoginText, "Login Page Header");
        waitTime(8000);
        click(LoginPage.kpxusername, "usernamme");
        type(LoginPage.kpxusername, accountCredential.getproperty("kpxusername"), "username inputted");
        click(LoginPage.kpxpassword, "kpxpassword");
        type(LoginPage.kpxpassword, accountCredential.getproperty("kpxpassword"), "password inputted");
        click(LoginPage.kpxlogind, "click login");
    }
}

