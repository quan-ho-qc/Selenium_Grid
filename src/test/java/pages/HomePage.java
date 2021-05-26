package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    @FindBy(css = "div.login-greeting")
    private WebElement lbGreeting;
    @FindBy(xpath = "//div[@class='moduletable']//h3[contains(text(),'Most Read')]")
    private WebElement txtReadPostTitle;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!driver.getCurrentUrl().equals("http://qctraining.demo.pycogroup.com/")) {
            throw new IllegalStateException("This is not Home Page of logged in user");
        }
    }

    public WebElement waitUntilvisibilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getLbGreeting() {
        return waitUntilvisibilityOfElement(lbGreeting).getText();
    }

    public String getTxtReadPostTitle() {
        return waitUntilvisibilityOfElement(txtReadPostTitle).getText();
    }

}
