package login;

import base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import utilites.ExcelUtility;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

       private LoginPage loginPage ;
       private AccountPage accountPage;
       ExcelUtility excel = new ExcelUtility("TestData.xlsx");


    @BeforeMethod
       public void callPages() {
        loginPage = new LoginPage(driver) ;
        accountPage=new AccountPage(driver);
       }

        @Test(priority = 1,dataProvider = "logindata")

        public void testLogin (String email , String password ,String testCase) {
            driver.findElement(By.cssSelector("a.login")).click();
            loginPage.login(email,password);
            switch(testCase)
            {
                case "valid" :
                    Assert.assertTrue(driver.getTitle().contains("My account - My Store"));
                    accountPage.clickLogout();
                    break;

                case "Invalid" :

                    Assert.assertTrue(loginPage.getErrMsg().contains("Authentication failed."));
                    break;


            }


        }

        @Test
        public void login(){
            driver.findElement(By.cssSelector("a.login")).click();
            loginPage.validLogin();
        }




    @DataProvider
    public Object[][] logindata(){
        Object[][] logindata = new Object [2][3] ;
        excel.fillarrayfromeexcel(logindata, "LoginData");
        return logindata ;
    }

}
