package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class BrowserUtils {
    public static void selectBy(WebElement location, String value, String methodName) {
        Select select = new Select(location);
        switch (methodName) {
            case "text":
                select.selectByVisibleText(value);
                break;

            case "value":
                select.selectByValue(value);
                break;

            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Method name is not available, Use text, value, or index");
        }
    }

    public static String getText(WebElement element) {
        return element.getText().trim();
    }

    public static String getTitleWithJS(WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString();
    }

    public static void clickWithJS(WebDriver driver, WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);

    }

    public static void scrollWithJS(WebDriver driver, WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public static void scrollWithPoint(WebDriver driver, WebElement information) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Point point = information.getLocation();
        int xCord = point.getX();
        int yCord = point.getY();
        System.out.println(xCord);
        System.out.println(yCord);
        js.executeScript("window.scrollTo(" + xCord + "," + yCord + ")");
    }

    public static void switchById(WebDriver driver, String mainId) {
        Set<String> allpageIds = driver.getWindowHandles();
        for (String id : allpageIds) {
            if (!id.equals(mainId)) {
                driver.switchTo().window(id);
            }
        }
    }

    public static void switchByTitle(WebDriver driver, String title) {
        Set<String> allPagesIds = driver.getWindowHandles();
        for (String id : allPagesIds) {
            driver.switchTo().window(id);
            if (driver.getTitle().contains("About Us")) {
                break;
            }

        }
    }public static void getScreenShot(WebDriver driver, String packageName ){

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String location = System.getProperty("user.dir")+"/scr/java/screenshot"+packageName;

        try {
            FileUtils.copyFile(file, new File(location + System.currentTimeMillis()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}







