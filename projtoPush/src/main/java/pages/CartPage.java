package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage {
    private WebDriver driver ;
    By listOfProductsInTheCart = By.xpath("//p[@class=\"product-name\"]");


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }



    public boolean verifyProductIsInCart(String prodName){
       return verifyThatelemtinlistbytext(listOfProductsInTheCart,prodName);

    }
    public  boolean verifyThatelemtinlistbytext(By  listofElements   ,String elemntText)

    {
        List<WebElement> List = driver.findElements(listofElements);
        java.util.List<String> elemntsNames = new ArrayList<String>();


        for(int i = 0 ; i<List.size() ; i++)
        {
            elemntsNames.add(List.get(i).getText());
        }

        return elemntsNames.contains(elemntText);
    }

}
