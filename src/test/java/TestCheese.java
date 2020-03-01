import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCheese {
    ChromeDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/80/chromedriver.exe");
    }

    @BeforeEach
    public void beforeEach() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void afterEach() {
        driver.close();
        driver.quit();
    }

    @Test
    public void testSearchingForCheeseReturnsTooMuchCheese() {
        // arrange
        GoogleHomePage google = new GoogleHomePage(driver);

        // act
        google.setSearchQuery("cheese");
        google.executeSearch();

        // assert
        String stats = google.getStatsText();
        assertTrue(stats.contains(" 777 "), "There is too much cheese on the internet");
    }
}
