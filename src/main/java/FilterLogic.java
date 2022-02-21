import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilterLogic {

    By rozetkaSellerCheckbox = By.xpath("//a[contains(@href, 'seller=rozetka')]");
    By brandsFilter = By.xpath("//div[@data-filter-name='producer']//*[@width='16']");
    By maxPriceField = By.xpath("//input[@formcontrolname='max']");
    By okButton = By.xpath("//button[text()= ' Ok ']");
    By firstPromoProductThumbnail = By.xpath("//span[contains(@class, 'promo-label_type_action')]/..");
    WebDriver driver;
    WebDriverWait wait;

    public FilterLogic(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public FilterLogic checkRozetkaSellerCheckbox() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(rozetkaSellerCheckbox)).click();
        return this;
    }

    public FilterLogic enterMaxPrice(String maxPrice) {
        /* I added a line of code below because Brand Filter on a left-hand side is expended, and max price
         input field, which is underneath it, is not visible on my laptop (I have a small screen - 13 in.),
         so my test was constantly failing.  JavascriptExecutor did not work.
        */
       driver.findElement(brandsFilter).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(maxPriceField)).clear();
        driver.findElement(maxPriceField).sendKeys(maxPrice);
        driver.findElement(okButton).click();
        return this;
    }

    public PromoProductPage openFirstPromoProductPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstPromoProductThumbnail)).click();
        return new PromoProductPage(driver, wait);
    }


}
