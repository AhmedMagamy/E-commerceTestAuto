package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private WebDriver driver;
    private By logOut = By.xpath("//div/a[@class='logout']");

    public void clickLogout(){
        driver.findElement(logOut).click();
    }

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }
}
