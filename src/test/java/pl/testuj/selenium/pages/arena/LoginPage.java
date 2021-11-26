package pl.testuj.selenium.pages.arena;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(className = "login_form_error")
    private WebElement loginFormError;

//    private static final By EMAIL_FIELD = By.id("email");
//    private static final By PASSWORD_FIELD = By.id("password");
//    private static final By LOGIN_BUTTON = By.id("login");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage successfulLogin(String email, String password) {
//        driver.findElement(EMAIL_FIELD).sendKeys(email);
//        driver.findElement(PASSWORD_FIELD).sendKeys(password);
//        driver.findElement(LOGIN_BUTTON).click();
        attemptLogin(email, password);
        return new HomePage(driver);
    }

    public LoginPage failedLogin(String email, String password) {
        attemptLogin(email, password);
        return new LoginPage(driver);
    }

    public void verifyErrorMessageAppeared() {
        Assertions.assertThat(loginFormError.isDisplayed()).isTrue();
    }

    private void attemptLogin(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
