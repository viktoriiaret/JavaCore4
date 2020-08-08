package HomeTests;

import L9HWPageObjects.LoginP;
import L9HWPageObjects.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginToKoel {
    private WebDriver driver;


    @BeforeMethod
    public void startUp (){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void tearDown () {
//        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void loginPass () {
        LoginP loginPage = new LoginP(driver);
        loginPage.openLoginPage();
        MainPage mainPage = loginPage.login("testpro.user04@testpro.io", "te$t$tudent");
        Assert.assertTrue(mainPage.isMain());
    }

    @Test
    public void loginFail () {
        LoginP loginPage = new LoginP(driver);
        loginPage.openLoginPage();
        loginPage.login("testpro.user04@testpro.io", "te$t$tudent");
        Assert.assertTrue(loginPage.redPhramePresents());
    }
}
