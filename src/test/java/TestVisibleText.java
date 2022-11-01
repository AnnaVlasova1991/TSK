import org.openqa.selenium.By;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class TestVisibleText {
    @Test
    public void testDoubleClick() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        Actions actions = new Actions(driver);
        driver.get("https://demoqa.com/buttons");
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickBtn")));
        WebElement webElement = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(webElement).perform();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickMessage")));
        String textDoubleClick = driver.findElement(By.id("doubleClickMessage")).getText();
        assertEquals("You have done a double click", textDoubleClick);
        driver.quit();
    }
    @Test
    public void testRightClick() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        Actions actions = new Actions(driver);
        driver.get("https://demoqa.com/buttons");
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("rightClickBtn")));
        WebElement webElement = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(webElement).perform();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("rightClickMessage")));
        String textDoubleClick = driver.findElement(By.id("rightClickMessage")).getText();
        assertEquals("You have done a right click", textDoubleClick);
        driver.quit();
    }
    @Test
    public void testLeftClick() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        Actions actions = new Actions(driver);
        driver.get("https://demoqa.com/buttons");
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[(@class='btn btn-primary' and text()='Click Me')]")));
        WebElement webElement = driver.findElement(By.xpath(".//button[(@class='btn btn-primary' and text()='Click Me')]"));
        webElement.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicClickMessage")));
        String textDoubleClick = driver.findElement(By.id("dynamicClickMessage")).getText();
        assertEquals("You have done a dynamic click", textDoubleClick);
        driver.quit();
    }

}
