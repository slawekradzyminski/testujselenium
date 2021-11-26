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

    private final WebDriver driver;

    public AdministrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddNewProject() {
        topCornerButtons.get(0).click();
    }
}
