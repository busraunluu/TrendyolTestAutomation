import Base.BaseTest;
import Pages.LoginPage;
import Pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage=new MainPage();

    @Test(description = "basarili kullanici girisi")
    public void basariligiris() {
        loginPage.fillEmail(email)
                .fillPassword(password)
                .clickLogin();
        sleep(3000);

        mainPage.accountControl();
    }

    @Test(description = "basarisiz kullanici girisi")
    public void basarisizGiris() {
        loginPage.fillEmail(email)
                .fillPassword("123.test")
                .clickLogin();
        sleep(3000);

        loginPage.errorMessageControl("E-posta adresiniz ve/veya şifreniz hatalı.");

    }
}
