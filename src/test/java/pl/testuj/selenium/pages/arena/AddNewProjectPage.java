package pl.testuj.selenium.pages.arena;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewProjectPage {

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "prefix")
    private WebElement prefixField;

    @FindBy(id = "description")
    private WebElement descriptionField;

    @FindBy(id = "save")
    private WebElement saveButton;

    private final WebDriver driver;

    public AddNewProjectPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AdministrationPage addProject(String projectName) {
        nameField.sendKeys(projectName);
        prefixField.sendKeys(RandomStringUtils.randomAlphabetic(6));
        descriptionField.sendKeys(RandomStringUtils.randomAlphabetic(20));
        saveButton.click();
        return new AdministrationPage(driver);
    }
}
