package Tests;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Const;
import drivers.Hooks;
import pages.HomePage;

public class TestHomePage {
    private WebDriver driver;

    @BeforeMethod
    @Parameters({ "browser_type" })
    public void beforeMethod(String browser_type) throws MalformedURLException {
        driver = Hooks.initRemoteWebDriver(browser_type);
    }

    public void verifyMostReadPostTitle() {
        HomePage homePage = new HomePage(driver);
        assertEquals(homePage.getTxtReadPostTitle(), Const.MOST_READ_POSTS_TITLE, "Verify the most read post");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
