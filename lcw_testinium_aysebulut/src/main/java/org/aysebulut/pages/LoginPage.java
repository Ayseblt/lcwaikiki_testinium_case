package org.aysebulut.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {



    private By loginEmail = By.id("LoginEmail");
    private By loginpassword = By.id("Password");
    private By loginBtn = By.id("loginLink");

    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(super.driver, 30);
    }

    public HomePage Login(String mail, String password) {

        sendKeys(loginEmail, mail);
        sendKeys(loginpassword, password);
        click(loginBtn, 10);

        return new HomePage(driver);
    }
}
