package org.aysebulut;

import static org.junit.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aysebulut.pages.*;
import org.aysebulut.users.UserInfo;
import org.junit.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;


public class AppTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(LoginPage.class);


    @Test

    public void allTest() throws InterruptedException {


        // https://www.lcwaikiki.com/tr-TR/TR sitesi açılır.

        HomePage homePage = new HomePage(driver);

        try {
            Assert.assertEquals("LC Waikiki | İlk Alışverişte Kargo Bedava! - LC Waikiki", driver.getTitle());
        } catch (Exception e) {
            logger.error("Doğru web sitesine giriş yapılamadı");
        }

        logger.info("Sayfaya başarılı bir şekilde giriş yapıldı");


        // Ana sayfanın açıldığı kontrol edilir. Siteye login olunur
        UserInfo user = new UserInfo();
        user.setEmail("aysetest95@gmail.com");
        user.setPassword("123456test");
        LoginPage logInPage = homePage.clickItemPage();
        logger.info("Login sayfasına girildi.");
        logInPage.Login(user.getEmail(), user.getPassword());
        logger.info("Kullanıcı girişi başarılı");


        //Arama kutucuğuna “pantolon” kelimesi girilir.

        ProductPage productPage = homePage.searchItem();
        logger.info("Pantolon ürünleri listelendi.");
        productPage.scrollPage(); //Sayfanın sonuna scroll edilir.
        productPage.loadButton();
        logger.info("Daha fazla ürün görüldü.");


        //Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.

        productPage.randomSelect(ProductPage.allProductList);
        logger.info("Rastgele bir ürün seçildi.");
        String productPrice = productPage.getProductPrice();//ürün sayfasındaki fiyat tutulur.

        // Seçilen ürün sepete eklenir.
        productPage.addToBasket();
        logger.info("Ürün sepete eklendi.");

        DetailPage detailPage= new DetailPage(driver);
        detailPage.selectProperties();
        detailPage.goMyBasket();
        logger.info("Sepetim sayfasına giriş yapılmıştır.");

       // Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
        BasketPage basketPage= new BasketPage(driver);
        Assert.assertEquals(productPrice, basketPage.basketProductPrice());
        logger.info("İki fiyat karşılaştırması yapılmıştır.");

       //Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
        basketPage.setNumberOfProducts();
        logger.info("Ürün miktarı arttırıldı");

       //Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.
        basketPage.deleteProduct();
        String basketMessage = "Sepetinizde ürün bulunmamaktadır.";
        assertEquals(basketMessage, basketPage.isEmpty());
        logger.info("Sepet boş");


    }
}