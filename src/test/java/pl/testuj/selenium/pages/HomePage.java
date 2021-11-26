package pl.testuj.selenium.pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(className = "user-info")
    private WebElement userInfo;

    @FindBy(css = "[title=Administracja]")
    private WebElement adminPanelIcon;

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AdministrationPage openAdministrationPanel() {
        adminPanelIcon.click();
        return new AdministrationPage(driver);
    }

    public void verifyUserInfoDisplayed() {
        Assertions.assertThat(userInfo.isDisplayed()).isTrue();
    }
}
