package pl.testuj.selenium.pages;

import org.openqa.selenium.By;
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

//    private static final By EMAIL_FIELD = By.id("email");
//    private static final By PASSWORD_FIELD = By.id("password");
//    private static final By LOGIN_BUTTON = By.id("login");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage login(String email, String password) {
//        driver.findElement(EMAIL_FIELD).sendKeys(email);
//        driver.findElement(PASSWORD_FIELD).sendKeys(password);
//        driver.findElement(LOGIN_BUTTON).click();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
        return new HomePage(driver);
    }

}
