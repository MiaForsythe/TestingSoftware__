package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TeaWebsitePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public TeaWebsitePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickInfusedWithImpactLink() {
        WebElement infusedWithImpactLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#menu-item-8612 > a")));
        infusedWithImpactLink.click();
    }

    public void clickLatestNewsLink() {
        WebElement latestNewsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#menu-item-8986 > a")));
        latestNewsLink.click();
    }

    public void clickTeaKnowledgeLink() {
        WebElement teaKnowledgeLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#site-content > section > section > ul > li:nth-child(4) > a")));
        teaKnowledgeLink.click();
    }

    public void waitForTeaKnowledgePageToLoad() {
        wait.until(ExpectedConditions.urlContains("tea-knowledge"));
    }

    public void scrollDownPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void expandNinthDiv() {
        WebElement ninthDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#at_posts_wrap > div:nth-child(9)")));
        ninthDiv.click();
    }

    public void clickContinueReadingLink() {
        WebElement continueReadingLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#at_posts_wrap > div:nth-child(9) > div.meta > a")));
        continueReadingLink.click();
    }

    public void clickSpecificBlock() {
        WebElement specificBlock = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#post-3054 > section.article_container > div:nth-child(5) > p:nth-child(4)")));
        specificBlock.click();
    }

    public void clickSpecificLink() {
        WebElement specificLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#post-3054 > section.article_container > div:nth-child(5) > p:nth-child(4) > a")));
        specificLink.click();
    }
}
