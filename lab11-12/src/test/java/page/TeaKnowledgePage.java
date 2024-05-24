package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TeaKnowledgePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private final Logger log = LogManager.getLogger(TeaKnowledgePage.class);

    public TeaKnowledgePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickInfusedWithImpactLink(String infusedWithImpactLinkText) {
        log.info("Clicking on Infused With Impact link");
        WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(infusedWithImpactLinkText)));
        link.click();
    }

    public void clickLatestNewsLink(String latestNewsLinkText) {
        log.info("Clicking on Latest News link");
        WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(latestNewsLinkText)));
        link.click();
    }

    public void clickTeaKnowledgeLink(String teaKnowledgeLinkText) {
        log.info("Clicking on Tea Knowledge link");
        WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(teaKnowledgeLinkText)));
        link.click();
    }

    public void waitForTeaKnowledgePageToLoad() {
        log.info("Waiting for Tea Knowledge page to load");
        wait.until(ExpectedConditions.urlContains("tea-knowledge"));
    }

    public void scrollDownPage() {
        log.info("Scrolling down the page");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void expandNinthDiv(String specificBlockCssSelector) {
        log.info("Expanding the ninth div");
        WebElement div = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(specificBlockCssSelector)));
        div.click();
    }

    public void clickContinueReadingLink(String specificLinkCssSelector) {
        log.info("Clicking on Continue Reading link");
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(specificLinkCssSelector)));
        link.click();
    }

    public void clickSpecificBlock(String specificBlockCssSelector) {
        log.info("Clicking on specific block");
        WebElement block = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(specificBlockCssSelector)));
        block.click();
    }

    public void clickSpecificLink(String specificLinkCssSelector) {
        log.info("Clicking on specific link");
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(specificLinkCssSelector)));
        link.click();
    }
}
