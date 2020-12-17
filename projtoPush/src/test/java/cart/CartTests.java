package cart;

import base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class CartTests extends BaseTests {

    private LoginPage loginPage ;
    private AccountPage accountPage;
    private HomePage homePage;
    private CategoryPage categoryPage;
    private CartPage cartPage;


    @BeforeMethod
    public void callPages() {
        loginPage = new LoginPage(driver) ;
        accountPage=new AccountPage(driver);
        homePage = new HomePage(driver);
        categoryPage = new CategoryPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void addToCartAndVerifyAdded(){
        //login
        driver.navigate().to("http://automationpractice.com/index.php?controller=authentication");
        loginPage.validLogin();
        //GoHome
        driver.navigate().to("http://automationpractice.com/index.php");
        //choseCategory
        homePage.clickOnDresses();
        //Select product To Add To Cart
        categoryPage.getDressByName("Printed Chiffon Dress").click();
        //click Add to cart
        driver.findElement(By.xpath("//p[@id='add_to_cart']/button")).click();
        //get product success modal
        WebElement modal = null ;
        try {
            modal = driver.findElement(By.id("layer_cart"));
        }
        catch (Exception e)
        {
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(modal));
        }
        //go to cart and verify it's added
        driver.navigate().to("http://automationpractice.com/index.php?controller=order");
       Assert.assertTrue(cartPage.verifyProductIsInCart("Printed Chiffon Dress"));


    }




}
