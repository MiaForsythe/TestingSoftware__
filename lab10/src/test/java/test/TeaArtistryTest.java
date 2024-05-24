package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.TeaArtistryPage;

public class TeaArtistryTest {
    private WebDriver driver;
    private TeaArtistryPage teaArtistryPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        teaArtistryPage = new TeaArtistryPage(driver);
    }

    @Test
    public void navigateAndSelectRecipe() throws InterruptedException {
        driver.get("https://www.ahmadtea.com/");
        teaArtistryPage.clickTeaArtistryLink();
        teaArtistryPage.clickTeaRecipesLink();
        teaArtistryPage.selectRecipeOptions("Hard", "10 minutes", "Earl Grey");
        teaArtistryPage.clickViewRecipeButton();
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
