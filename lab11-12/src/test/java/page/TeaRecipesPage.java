package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TeaRecipesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public TeaRecipesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#menu-item-2122 > a")
    private WebElement teaArtistryLink;

    @FindBy(css = "#menu-item-2127 > a")
    private WebElement teaRecipesLink;

    @FindBy(id = "difficulty")
    private WebElement difficultyDropdown;

    @FindBy(id = "time_to_make")
    private WebElement timeDropdown;

    @FindBy(id = "blend")
    private WebElement blendDropdown;

    @FindBy(css = "#at_posts_wrap > div:nth-child(2) > div.recipe_btn > a")
    private WebElement viewRecipeButton;

    public void clickTeaArtistryLink() {
        teaArtistryLink.click();
    }

    public void clickTeaRecipesLink() {
        wait.until(ExpectedConditions.visibilityOf(teaRecipesLink)).click();
    }


    public void selectRecipeOptions(String difficulty, String time, String blend) {
        wait.until(ExpectedConditions.visibilityOf(difficultyDropdown));

        new Select(difficultyDropdown).selectByVisibleText(difficulty);

        wait.until(ExpectedConditions.visibilityOf(timeDropdown));

        new Select(timeDropdown).selectByVisibleText(time);

        wait.until(ExpectedConditions.visibilityOf(blendDropdown));

        new Select(blendDropdown).selectByVisibleText(blend);

        try {
            Thread.sleep(2000); // Подождать 2 секунды
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickViewRecipeButton() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        wait.until(ExpectedConditions.visibilityOf(viewRecipeButton));
        js.executeScript("arguments[0].scrollIntoView(true);", viewRecipeButton);
        Thread.sleep(1000);
        js.executeScript("arguments[0].click();", viewRecipeButton);
        Thread.sleep(5000);
    }
}
