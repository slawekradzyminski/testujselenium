package pl.testuj.selenium.pages.arena;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdministrationPage {

    @FindBy(className = "button_link")
    private List<WebElement> topCornerButtons;

    @FindBy(css = "[title=Kokpit]")
    private WebElement cockpitIcon;

    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(id = "j_searchButton")
    private WebElement searchButton;

    @FindBy(css = "tbody tr")
    private List<WebElement> projectRow;

    @FindBy(css = "tbody tr td")
    private List<WebElement> tableCell;

    private final WebDriver driver;

    public AdministrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AddNewProjectPage clickAddNewProject() {
        topCornerButtons.get(0).click();
        return new AddNewProjectPage(driver);
    }

    public HomePage openCockpit() {
        cockpitIcon.click();
        return new HomePage(driver);
    }

    public AdministrationPage searchByProjectName(String projectName) {
        searchField.sendKeys(projectName);
        searchButton.click();
        return new AdministrationPage(driver);
    }

    public AdministrationPage verifyNumberOfProjectsFound(int projectCount) {
        Assertions.assertThat(projectRow).hasSize(projectCount);
        return this;
    }

    public void verifyFirstProjectTitle(String projectName) {
        WebElement firstElementTitle = tableCell.get(0);
        Assertions.assertThat(firstElementTitle.getText()).isEqualTo(projectName);
    }
}
