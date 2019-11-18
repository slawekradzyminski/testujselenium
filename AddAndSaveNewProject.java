package org.vistula.selenium.test.Homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAndSaveNewProject {
    private WebDriver driver;

    @FindBy(css = ".button_link:nth-of-type(1)")
    WebElement buttonLink;
    @FindBy(name = "name")
    WebElement projectName;
    @FindBy(id = "prefix")
    WebElement projectPrefix;
    @FindBy(css = "input#save")
    WebElement saveInput;
    @FindBy(className = "activeMenu")
    WebElement activeMenu;

    public AddAndSaveNewProject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void button() {
        buttonLink.click();
    }

    public void giveProjectName(String nameOfProject) {
        projectName.sendKeys(nameOfProject);
    }

    public void addPrefix(String prefix) {
        projectPrefix.sendKeys(prefix);
    }

    public void saveProject() {
        saveInput.click();
    }

    public void goToProjects() {
        activeMenu.click();
    }
}
