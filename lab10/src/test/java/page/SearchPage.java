package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By searchIconLocator = By.id("search-box-icon");
    private By searchFormLocator = By.id("searchform");
    private By searchInputLocator = By.id("s");
    private By searchButtonLocator = By.id("searchsubmit");

    public SearchPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void search(String query) {
        // Нажатие на иконку поиска
        WebElement searchIcon = driver.findElement(searchIconLocator);
        searchIcon.click();

        // Ожидание видимости формы поиска
        WebElement searchForm = wait.until(ExpectedConditions.visibilityOfElementLocated(searchFormLocator));

        // Поиск поля ввода в форме и ввод поискового запроса
        WebElement searchInput = searchForm.findElement(searchInputLocator);
        searchInput.sendKeys(query);

        // Поиск кнопки поиска и клик по ней
        WebElement searchButton = searchForm.findElement(searchButtonLocator);
        searchButton.click();
    }
}
