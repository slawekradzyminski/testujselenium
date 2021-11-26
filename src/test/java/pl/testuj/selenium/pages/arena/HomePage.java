package pl.testuj.selenium.pages.arena;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    @FindBy(className = "user-info")
    private WebElement userInfo;

    @FindBy(css = "[title=Administracja]")
    private WebElement adminPanelIcon;

    @FindBy(className = "header_logout")
    private WebElement logoutButton;

    @FindBy(css = "ul.menu li")
    private List<WebElement> sidebarLinks;

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

    public LoginPage clickLogoutButton() {
        logoutButton.click();
        return new LoginPage(driver);
    }

    public TestsDatabasePage openTestsDatabase() {
        sidebarLinks.get(8).click();
        return new TestsDatabasePage(driver);
    }
}
