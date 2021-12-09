package org.aysebulut.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Collection;

public class HomePage extends BasePage{

    Actions actions;

    private By loginBtnHomePage = By.xpath("//span[text()='Giriş Yap']");
    private By searchField = By.cssSelector("input[id='search_input']");
    private By findBtn = By.cssSelector("button[class='searchButton']");
    private String searchText = "Pantolon";


    public HomePage(WebDriver driver){
        super(driver);
        actions = new Actions(driver);
    }

    public LoginPage clickItemPage() {
        click(loginBtnHomePage,5);
        LoginPage logInPage = new LoginPage(driver);
        return logInPage;
    }

    public ProductPage searchItem(){
        clear(searchField);
        driver.findElement(searchField).sendKeys(searchText);
        driver.findElement(findBtn).click();
        return new ProductPage(driver);
    }


}
