package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.SearchPage;
import model.SearchData;
import service.SearchDataService;

import java.time.Duration;

public class SearchTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private SearchPage searchPage;
    private SearchData searchData;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        searchPage = new SearchPage(driver, wait);
        searchData = SearchDataService.getSearchData();
    }

    @Test
    public void searchOnAhmadTea() {
        driver.get("https://www.ahmadtea.com/");
        searchPage.search(searchData.getSearchQuery());
        wait.until(webDriver -> webDriver.getCurrentUrl().contains(searchData.getExpectedUrlPart()));
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        Assert.assertTrue(currentUrl.contains(searchData.getExpectedUrlPart()), "Incorrect URL: " + currentUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
