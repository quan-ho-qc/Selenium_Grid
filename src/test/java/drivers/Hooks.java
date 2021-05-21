package drivers;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import constants.Const;

public class Hooks {
    private static WebDriver driver;
    public static WebDriver initRemoteWebDriver(String browser_type) throws MalformedURLException {
        if(browser_type.equals("chrome")) {
               DesiredCapabilities capabilities = new DesiredCapabilities();
               capabilities = DesiredCapabilities.chrome();
               driver = new RemoteWebDriver(new URL(Const.HUB_URL), capabilities);
            }else if(browser_type.equals("firefox")){
               DesiredCapabilities capabilities = new DesiredCapabilities();
               capabilities = DesiredCapabilities.firefox();
               driver = new RemoteWebDriver(new URL(Const.HUB_URL), capabilities);
            }
        driver.get(Const.WEB_URL);
        driver.manage().window().maximize();
        return driver;
    }
}
