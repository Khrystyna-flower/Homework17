import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    By laptopsAndComputersMenu = By.xpath("//sidebar-fat-menu//a[contains(@href, 'computers-notebooks')]");
    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver,WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public LaptopsAndComputersPage clickOnLaptopsAndComputersCategory() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(laptopsAndComputersMenu)).click();
        return new LaptopsAndComputersPage(driver, wait);
    }

}
