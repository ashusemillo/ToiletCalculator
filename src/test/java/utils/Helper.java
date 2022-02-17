package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {

    public static void scrollIntoView(WebDriver driver, WebElement element){
//        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
//                + "var elementTop = arguments[0].getBoundingClientRect().top;"
//                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
//        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        //Scroll to bottom
        js.executeScript("window.scrollBy(0,1100)");
    }

    public static void waitUntilVisibilityOf(WebDriver driver, WebElement element, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
