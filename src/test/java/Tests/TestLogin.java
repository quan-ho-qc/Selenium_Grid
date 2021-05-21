package Tests;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import drivers.Hooks;
import pages.HomePage;
import pages.LoginPage;

public class TestLogin {
    private WebDriver driver;

    @BeforeMethod
    @Parameters({ "browser_type" })
    public void beforeMethod(String browser_type) throws MalformedURLException {
        driver = Hooks.initRemoteWebDriver(browser_type);
    }
    
    @DataProvider (name = "Valid cridentails")
    public Object[][] getTrueAccount(){
        return new Object[][] {
            { "quanho", "Abcd1234", "Hi quan ho," },
            { "thongnguyen", "Abcd1234", "Hi thong nguyen," }
            };
        }
    
    @Test(dataProvider = "Valid cridentails")
    public void loginSuccessfully(String username, String password, String lbGreeting) {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.fillAccount(username, password);
        HomePage homepage = loginpage.loginSuccessfully();
        assertEquals(homepage.getLbGreeting(), lbGreeting, "Check the greeting lable exist or not");
    }
 
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
