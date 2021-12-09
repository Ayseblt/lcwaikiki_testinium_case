package org.aysebulut.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private By lazzyLoadBtn = By.cssSelector("p[class='lazy-load-text']");
    public static By allProductList = By.xpath("//div[@class='col-xs-6 col-sm-6 col-md-3 four-column c-item product-item-wrapper']");
   // public static By productPriceList = By.xpath("//div[@class='col-xs-12 price-area']/div/div/span[2]");
    private By basketBtn = By.cssSelector("a[id='pd_add_to_cart']");
    private By productPriceBy =By.id("sp-price-lowPrice");
    private By highProductPriceBy = By.id("sp-price-highPrice");
    private By lowProductPriceBy  = By.id("sp-price-lowPrice");

    public void scrollPage() {

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        // js.executeScript("window.scrollTo(0,6550)");
        js.executeScript("window.scrollTo(0, -250)");
        driver.findElement(lazzyLoadBtn).click();

    }
    public void loadButton(){
        click(lazzyLoadBtn,10);
    }


    public void randomSelect(By byElement) {
        List<WebElement> elementList = driver.findElements(byElement);
        Random r = new Random();
        int a = r.nextInt(elementList.size());
        elementList.get(a).click();
    }

    public  String  getProductPrice() {
        String productPrice = driver.findElement(productPriceBy).getText();
        if (productPrice.isEmpty()) {
            return driver.findElement(highProductPriceBy).getText();
        }
        return driver.findElement(lowProductPriceBy).getText();

     }

    public void addToBasket(){
        driver.findElement(basketBtn).click();

    }



}
