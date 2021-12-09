package org.aysebulut.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetailPage extends BasePage{
    public DetailPage(WebDriver driver) {
        super(driver);
    }

    public static By addBasket = By.xpath("//a[@id='pd_add_to_cart']");
    public static By addSize = By.xpath("(//div[@class='option-size'] //a[@key='7'][1]");
    public static By myBasketBtn = By.xpath("//a[@data-tracking-label='Sepetim']");
    public static By productPrice = By.xpath("//row[@id='topStickyMainInfo']/div[@class='col-md-4 price-area']/span[@class='price'][1]");
    public static By productPrice2 = By.xpath("//span[@id='cartLastTotal']");

    public void selectProperties(){

        click(addSize,10);
        click(addBasket,10);
    }

    public void goMyBasket(){
        click(myBasketBtn,10);

    }

}
