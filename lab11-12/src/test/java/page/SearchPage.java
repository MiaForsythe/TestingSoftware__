package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "search-box-icon")
    private WebElement searchIcon;

    @FindBy(id = "searchform")
    private WebElement searchForm;

    @FindBy(id = "s")
    private WebElement searchInput;

    @FindBy(id = "searchsubmit")
    private WebElement searchButton;

    public SearchPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void search(String query) {
        searchIcon.click();
        wait.until(ExpectedConditions.visibilityOf(searchForm));
        searchInput.sendKeys(query);
        searchButton.click();
    }
}
