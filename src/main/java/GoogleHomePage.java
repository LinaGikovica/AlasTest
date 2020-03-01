import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage {
    WebDriver driver;

    private By searchField = By.name("q");
    private By resultStatusText = By.id("result-stats");

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        this.driver.navigate().to("https://www.google.com");
    }

    public void setSearchQuery(String query) {
        driver.findElement(searchField).sendKeys(query);
    }

    public void executeSearch() {
        driver.findElement(searchField).sendKeys(Keys.ENTER);
    }

    public String getStatsText() {
        return driver.findElement(resultStatusText).getText();
    }
}
