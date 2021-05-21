package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    @FindBy(id = "modlgn-username")
    private WebElement txtUsername;
    @FindBy(id = "modlgn-passwd")
    private WebElement txtPassword;
    @FindBy(id = "system-message")
    private WebElement errorMessage;
    @FindBy(xpath = "//input[@name='Submit']")
    private WebElement btnLogin;

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage fillAccount(String username, String password) {
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        return this;
    }

    public void clickBtnLogin() {
        btnLogin.click();
    }

    public HomePage loginSuccessfully() {
        return new HomePage(driver);
    }

    public String getBtnLogin() {
        return btnLogin.getAttribute("value");
    }
}
