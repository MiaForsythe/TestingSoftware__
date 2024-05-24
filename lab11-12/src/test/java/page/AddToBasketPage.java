package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToBasketPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By teaArtistryLinkLocator = By.xpath("//a[contains(text(),'Tea Artistry')]");
    private By teaCollectionsLinkLocator = By.xpath("//a[contains(text(),'tea collections')]");
    private By learnMoreButtonInBlackTeasLocator = By.xpath("//div[contains(text(),'black teas')]//ancestor::div[@class='product-image-wrapper']//a[contains(text(),'Learn more')]");
    private By shopNowButtonLocator = By.xpath("//a[contains(text(),'Shop now')]");
    private By englishBreakfastTeaTeabagsLocator = By.xpath("//span[contains(text(),'English Breakfast Tea - Teabags')]");
    private By quantityIncrementLocator = By.xpath("//span[contains(text(),'100 Tagged Teabags')]//ancestor::li//div[@class='qty-increment']");
    private By addToBasketButtonLocator = By.xpath("//button[contains(text(),'Add to basket')]");

    public AddToBasketPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void hoverOverTeaArtistryLink() {
        WebElement teaArtistryLink = wait.until(ExpectedConditions.visibilityOfElementLocated(teaArtistryLinkLocator));
        Actions actions = new Actions(driver);
        actions.moveToElement(teaArtistryLink).perform();
    }

    public void clickTeaCollectionsLink() {
        WebElement teaCollectionsLink = wait.until(ExpectedConditions.elementToBeClickable(teaCollectionsLinkLocator));
        teaCollectionsLink.click();
    }

    public void clickLearnMoreButtonInBlackTeas() {
        WebElement learnMoreButton = wait.until(ExpectedConditions.elementToBeClickable(learnMoreButtonInBlackTeasLocator));
        learnMoreButton.click();
    }

    public void clickShopNowButton() {
        WebElement shopNowButton = wait.until(ExpectedConditions.elementToBeClickable(shopNowButtonLocator));
        shopNowButton.click();
    }

    public void clickEnglishBreakfastTeaTeabags() {
        WebElement englishBreakfastTeaTeabags = wait.until(ExpectedConditions.elementToBeClickable(englishBreakfastTeaTeabagsLocator));
        englishBreakfastTeaTeabags.click();
    }

    public void incrementQuantityFor100TaggedTeabags() {
        WebElement quantityIncrement = wait.until(ExpectedConditions.elementToBeClickable(quantityIncrementLocator));
        quantityIncrement.click();
    }

    public void clickAddToBasketButton() {
        WebElement addToBasketButton = wait.until(ExpectedConditions.elementToBeClickable(addToBasketButtonLocator));
        addToBasketButton.click();
    }

    public void addToBasket() {
        hoverOverTeaArtistryLink();
        clickTeaCollectionsLink();
        clickLearnMoreButtonInBlackTeas();
        clickShopNowButton();
        clickEnglishBreakfastTeaTeabags();
        incrementQuantityFor100TaggedTeabags();
        clickAddToBasketButton();
    }
}
