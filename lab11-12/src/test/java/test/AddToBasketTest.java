package test;

import model.AddToBasketData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.AddToBasketPage;
import service.AddToBasketService;

import java.time.Duration;

public class AddToBasketTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private AddToBasketData addToBasket;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testAddToBasket() {
        AddToBasketPage addToBasketPage = new AddToBasketPage(driver, wait);
        AddToBasketService addToBasketService = new AddToBasketService();

        driver.get("https://www.ahmadtea.com/");

        addToBasketPage.hoverOverTeaArtistryLink();
        addToBasketPage.clickTeaCollectionsLink();

        addToBasketPage.clickLearnMoreButtonInBlackTeas();

        addToBasketPage.clickShopNowButton();

         addToBasketPage.clickEnglishBreakfastTeaTeabags();

         addToBasketPage.incrementQuantityFor100TaggedTeabags();

        addToBasketPage.clickAddToBasketButton();

        addToBasketService.addToBasket(addToBasket);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
