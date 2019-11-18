package org.vistula.selenium.test.Homework;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Structure {
    private WebDriver driver;

    @FindBy(id = "search")
    WebElement search;
    @FindBy(className = "t_number")
    WebElement prefix;
    @FindBy(id = "j_searchButton")
    WebElement searchButton;

    public Structure(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void findProject(String projectName) {
        search.sendKeys(projectName);
        searchButton.click();
    }

    public void verifyProject(String projectName) {
        WebElement project = driver.findElement(By.linkText(projectName));
        Assertions.assertThat(project.getText().contains(projectName));

    }

}
