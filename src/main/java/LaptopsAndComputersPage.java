import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaptopsAndComputersPage {

    By laptopsCategory = By.xpath("//a[contains(@href, '/notebooks/') and contains(@class, 'tile-cats__heading')]");
    WebDriver driver;
    WebDriverWait wait;

    public LaptopsAndComputersPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public FilterLogic clickOnLaptopsCategory() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(laptopsCategory)).click();
        return new FilterLogic(driver, wait);
    }

}

