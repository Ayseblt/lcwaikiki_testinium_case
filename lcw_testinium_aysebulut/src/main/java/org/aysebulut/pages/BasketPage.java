package org.aysebulut.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage{
    private By basketPrice = By.xpath("//span[@id='cartLastTotal']");
    private By numberOfProducts = By.xpath("//a[@class='oq-up plus']"); //2 ürün arttırma
    private By deleteProduct = By.xpath("//a[@class='inverted-modal-button sc-delete ins-init-condition-tracking']"); // ürün silme
    private By emptyBasket = By.xpath("//p[@class='cart-empty-title']"); //  boş sepet kontrolü


    public BasketPage(WebDriver driver) {
        super(driver);
    }
    public String basketProductPrice(){
        return driver.findElement(basketPrice).getText();
    }
    public void setNumberOfProducts(){
        click(numberOfProducts,10);
    }

    public void deleteProduct(){
        click(deleteProduct,10);
    }

    public String isEmpty(){
        return driver.findElement(emptyBasket).getText();
    }
}
