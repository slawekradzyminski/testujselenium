package org.vistula.selenium.test.Homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FindingProjectTest extends SetupLogin {

    @Test
    public void shouldFindProject() {

        BasePage basePage = new BasePage(driver);
        basePage.loginPage("administrator@testarena.pl", "sumXQQ72$L");

        WebElement administration =
                driver.findElement(By.cssSelector(".header_admin a"));
        administration.click();

        AddAndSaveNewProject nextProject = new AddAndSaveNewProject(driver);
        nextProject.button();
        nextProject.giveProjectName("Cogito_Project");
        nextProject.addPrefix("08Y80");
        nextProject.saveProject();
        nextProject.goToProjects();

        Structure find = new Structure(driver);
        find.findProject("Cogito_Project");
        find.verifyProject("Cogito_Project");

    }
}


