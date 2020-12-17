package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CategoryPage {
    private WebDriver driver ;

    By listOfProducts = By.xpath("//div[@class='right-block']/h5/a[@class='product-name']");
    By listOfAddToCartButtons = By.xpath("//a[@title='Add to cart']");

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getDressByName(String elemntText){
        return  getElementWithTextInList(listOfProducts,elemntText);

    }
    public WebElement getElementWithTextInList(By listofElements ,String elemntText) {

        List<WebElement> List =driver.findElements(listofElements);
        java.util.List<String> elemntsNames = new ArrayList<String>();

        for(int i = 0 ; i<List.size() ; i++)
        {
            System.out.println(List.get(i).getText());
            elemntsNames.add(List.get(i).getText());
        }

        int x =	elemntsNames.indexOf(elemntText);

        return List.get(x);
    }


}
