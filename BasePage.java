package org.vistula.selenium.test.Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;

    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "login")
    WebElement login;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginPage(String text, String text1) {
        email.sendKeys(text);
        password.sendKeys(text1);
        login.submit();

        new WebDriverWait(driver, 6)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".header_admin a")));

    }
}
