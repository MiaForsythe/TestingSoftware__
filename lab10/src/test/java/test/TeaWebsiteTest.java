package test;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.TeaWebsitePage;

import java.time.Duration;

public class TeaWebsiteTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private TeaWebsitePage teaWebsitePage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        driver = new EdgeDriver();

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        teaWebsitePage = new TeaWebsitePage(driver, wait);
    }

    @Test
    public void navigateAndSelectRecipe() {
        try {
            driver.get("https://www.ahmadtea.com/");

            teaWebsitePage.clickInfusedWithImpactLink();

            teaWebsitePage.clickLatestNewsLink();

            teaWebsitePage.clickTeaKnowledgeLink();

            teaWebsitePage.waitForTeaKnowledgePageToLoad();

            teaWebsitePage.scrollDownPage();

            teaWebsitePage.expandNinthDiv();

            teaWebsitePage.clickContinueReadingLink();

            teaWebsitePage.clickSpecificBlock();

            teaWebsitePage.clickSpecificLink();

            Thread.sleep(5000);

        } catch (TimeoutException e) {
            System.out.println("Timed out waiting for the element: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
        } catch (WebDriverException e) {
            System.out.println("WebDriver error: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
