package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.SearchPage;

import java.time.Duration;

public class SearchTest {
    private static final String SEARCH_QUERY = "Green Tea";
    private static final String EXPECTED_URL_PART = "?s=Green+Tea";

    private WebDriver driver;
    private WebDriverWait wait;
    private SearchPage searchPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // Инициализация экземпляра драйвера
        driver = new EdgeDriver();

        // Максимизация окна браузера
        driver.manage().window().maximize();

        // Установка явного ожидания
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Инициализация страницы поиска Ahmad Tea
        searchPage = new SearchPage(driver, wait);
    }

    @Test
    public void searchOnAhmadTea() {
        // Переход на страницу
        driver.get("https://www.ahmadtea.com/");

        // Выполнение поиска
        searchPage.search(SEARCH_QUERY);

        // Ожидание изменения URL и проверка, что URL содержит ожидаемую часть
        wait.until(ExpectedConditions.urlContains("?s="));
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        Assert.assertTrue(currentUrl.contains(EXPECTED_URL_PART), "Incorrect URL: " + currentUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
