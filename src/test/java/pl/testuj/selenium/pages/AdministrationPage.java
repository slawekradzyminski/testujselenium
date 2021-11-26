package pl.testuj.selenium.pages;

import org.openqa.selenium.By;
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
}
