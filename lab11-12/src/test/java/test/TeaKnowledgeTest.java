package test;

import driver.DriverSingleton;
import model.TeaKnowledgeData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.TeaKnowledgePage;
import service.TeaKnowledgeDataService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

public class TeaKnowledgeTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private TeaKnowledgePage teaWebsitePage;
    private TeaKnowledgeData teaKnowledgeData;
    private final Logger log = LogManager.getLogger(TeaKnowledgeTest.class);

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = DriverSingleton.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        teaWebsitePage = new TeaKnowledgePage(driver, wait);
        teaKnowledgeData = TeaKnowledgeDataService.getTestData();
    }

    @Test
    public void navigateAndSelectRecipe() {
        try {
            log.info("Starting test: navigateAndSelectRecipe");
            driver.get(teaKnowledgeData.getMainPageUrl());
            log.info("Navigated to Ahmad Tea website");

            teaWebsitePage.clickInfusedWithImpactLink(teaKnowledgeData.getInfusedWithImpactLinkText());
            teaWebsitePage.clickLatestNewsLink(teaKnowledgeData.getLatestNewsLinkText());
            teaWebsitePage.clickTeaKnowledgeLink(teaKnowledgeData.getTeaKnowledgeLinkText());
            teaWebsitePage.waitForTeaKnowledgePageToLoad();
            teaWebsitePage.scrollDownPage();
            teaWebsitePage.expandNinthDiv(teaKnowledgeData.getSpecificBlockCssSelector());
            teaWebsitePage.clickContinueReadingLink(teaKnowledgeData.getSpecificLinkCssSelector());
            teaWebsitePage.clickSpecificBlock(teaKnowledgeData.getSpecificBlockCssSelector());
            teaWebsitePage.clickSpecificLink(teaKnowledgeData.getSpecificLinkCssSelector());

        } catch (Exception e) {
            log.error("An error occurred during the test", e);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Tearing down the test");
        DriverSingleton.closeDriver();
    }
}
