import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class TestAllert {
    @Test
    public void testAllertButtonOne() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/alerts");
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        ".//button[(@class='btn btn-primary' and @id='alertButton')]")));
        WebElement webElement = driver.findElement(By.xpath(
                ".//button[(@class='btn btn-primary' and @id='alertButton')]"));
        webElement.click();
        driver.switchTo().alert().accept();
        driver.quit();
    }
    @Test
    public void testAllertButtonTwo() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/alerts");
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        ".//button[(@class='btn btn-primary' and @id='timerAlertButton')]")));
        WebElement webElement = driver.findElement(By.xpath(
                ".//button[(@class='btn btn-primary' and @id='timerAlertButton')]"));
        webElement.click();
        new WebDriverWait(driver, 6).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        driver.quit();
    }
    @Test
    public void testAllertButtonThree() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        Actions actions = new Actions(driver);
        driver.get("https://demoqa.com/alerts");
        new WebDriverWait(driver, 4)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        ".//button[(@class='btn btn-primary' and @id='confirmButton')]")));
        WebElement webElement = driver.findElement(By.xpath(
                ".//button[(@class='btn btn-primary' and @id='confirmButton')]"));
        //webElement.click();
        actions.moveToElement(webElement).click().perform();
        driver.switchTo().alert().dismiss();
        String textCancel = driver.findElement(By.id("confirmResult")).getText();
        assertEquals("You selected Cancel", textCancel);
        driver.quit();
    }
}
