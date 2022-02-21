import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Homework {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/");
    }

    @Test
    public void checkPromoLabelOnProductPage() {
        WebElement promoLabelOnProductPage = new MainPage(driver, wait)
                .clickOnLaptopsAndComputersCategory()
                .clickOnLaptopsCategory().checkRozetkaSellerCheckbox()
                .enterMaxPrice("100000").openFirstPromoProductPage()
                .returnLabelElement();
        Assert.assertTrue(promoLabelOnProductPage.isDisplayed());
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
