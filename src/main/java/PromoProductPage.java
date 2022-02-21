import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PromoProductPage {

    By promoLabel = By.xpath("//app-label[contains(@class, 'main-slider__label')]");
    WebDriver driver;
    WebDriverWait wait;

    public PromoProductPage (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement returnLabelElement() {
        return driver.findElement(promoLabel);
    }
}

