package core.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.TimeZone;

public class Action {

    protected WebDriver driver = Core.getDriver();
    private final int DURATION = 15;

    protected void println(String value) {
        DateFormat df = new SimpleDateFormat("YY-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("America/Bogota"));
        String date = df.format(new Date());
        String ANSI_ORANGE = "\u001B[33m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_RESET = "\u001B[0m";
        System.out.println(ANSI_ORANGE + "[" + date + "] -> " + ANSI_GREEN + value + ANSI_RESET);
    }

    protected WebElement element(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DURATION));
        return wait.until(d -> driver.findElement(locator));
    }

    protected void click(By locator) {
        this.println("[Click] -> " + locator);
        try {
            element(locator).click();
        } catch (RuntimeException we) {
            ErrorInteraction(String.valueOf(locator));
        }
    }

    protected void sendKeys(By locator, String value) {
        this.println("[SendKeys] -> " + locator + " => " + value);
        try {
            element(locator).sendKeys(value);
        } catch (RuntimeException we) {
            ErrorInteraction(String.valueOf(locator));
        }
    }

    protected String script(String script) {
        this.println("[Script] -> " + script);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript(script);
    }

    private void ErrorInteraction(String description) {
        this.println("Error Interaction: " + description);
        throw new RuntimeException("Error Interaction: " + description);
    }
}
