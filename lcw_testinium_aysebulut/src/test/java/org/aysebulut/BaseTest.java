package org.aysebulut;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    public WebElement element(By Locator){
        return driver.findElement(Locator);
    }

    @BeforeMethod
    public void setup() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.lcwaikiki.com/tr-TR/TR");
    }
    @AfterMethod

    public void tearDown(){
        //  driver.quit();

    }


}
/*TODO:
   1.https://www.lcwaikiki.com/tr-TR/TR sitesi açılır. +
   2.Ana sayfanın açıldığı kontrol edilir. Siteye login olunur +
   3.Login işlemi kontrol edilir. +
   4.Arama kutucuğuna “pantolan” kelimesi girilir.+
   5.Sayfanın sonuna scroll edilir.-
   6.“Daha fazla ürün gör “ butonuna tıklanır.+
   7.Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.+
   8.Seçilen ürün sepete eklenir.+
   9.Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.+
   10.Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
   11.Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.
*/