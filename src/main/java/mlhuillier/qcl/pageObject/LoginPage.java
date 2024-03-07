package mlhuillier.qcl.pageObject;

import org.openqa.selenium.By;

public class LoginPage {


        public static By kpxlogin = By.xpath("//*[@class='login-btn']");
        public  static By kpxusername = By.xpath("//*[@name='username']");
        public  static By kpxpassword= By.xpath("//*[@name='password']");

        public  static By kpxlogind = By.xpath("//*[@type='submit']");
        public static By googleSign = By.xpath("//*[@class='nsm7Bb-HzV7m-LgbsSe-bN97Pc-sM5MNb ']");
        public static By email_google = By.xpath("//*[@id='identifierId']");
        public static By nextBtn_google = By.xpath("//*[contains(text(), 'Next')]");
        public static By password_google = By.xpath("//*[@type='password']");
        public static By try_another_way_google = By.xpath("//span[contains(text(), 'Try another way')]");
        public static By enter_back_up_codes_google = By.xpath("//*[contains(text(), 'Google Authenticator')]");
        public static By input_back_up_codes_google = By.xpath("//*[@type= 'tel']");

        public static By LoginText = By.xpath("//*[contains(text(), 'Login')]");

    }

