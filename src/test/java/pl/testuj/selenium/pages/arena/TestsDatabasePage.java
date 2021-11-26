package pl.testuj.selenium.pages.arena;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TestsDatabasePage {

    @FindBy(className = "button_link")
    private WebElement addButton;

    @FindBy(className = "button_link_li")
    private List<WebElement> typesOfTests;

    private final WebDriver driver;

    public TestsDatabasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addAutomatedTests() {
        addButton.click();
        typesOfTests.get(2).click();
    }
}
