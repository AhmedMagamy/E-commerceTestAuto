package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilites.ExcelUtility;

public class LoginPage {
    private WebDriver driver ;
    ExcelUtility excel = new ExcelUtility("TestData.xlsx");
    private By emailField = By.id("email");
    private By passwordField = By.id("passwd");
    private By loginButton = By.xpath("//span/i[@class='icon-lock left']");
    private By errMsg = By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li");


    // Any class need to use login page must pass his driver to it
    public LoginPage(WebDriver browser){
        this.driver = browser;
    }

    public void setEmail(String username){
        driver.findElement(emailField).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public  void clickLogin(){
        driver.findElement(loginButton).click();
    }

    public String getErrMsg() {
       return driver.findElement(errMsg).getText();
    }

        public void login(String email ,String password){
        setEmail(email);
        setPassword(password);
        clickLogin();

        }

        public void validLogin(  ){
       String email =excel.getCellDataString("LoginData",0,0);
       String password=excel.getCellDataString("LoginData",0,1);
        login(email,password);

        }


}
