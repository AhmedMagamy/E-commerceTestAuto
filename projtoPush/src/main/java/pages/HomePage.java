package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    protected WebDriver driver ;
    By dresses = By.xpath("/html/body/div[1]/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnDresses(){
        driver.findElement(dresses).click();
    }


}
