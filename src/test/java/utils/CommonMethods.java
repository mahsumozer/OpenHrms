package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.BaseClass;
import testbase.pageInitializer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonMethods extends pageInitializer {

    /**
     *
     * @param element
     * @param text
     */
    public static void sendText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Method return Object of JavaScript Executor type
     * @return js object
     */
    public static JavascriptExecutor getJSExecutor(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    /**
     * Methods performs click using JavaScript executor
     * @param element
     */

    public static void jsClick(WebElement element){
        getJSExecutor().executeScript("argument[0].click;", element);
    }

    /**
     * Methods scrolls Up using JavaScript executor
     * @param pixel
     */

    public static void scrollUp(int pixel){
        getJSExecutor().executeScript("window.scrollBy(0, -"+pixel+")");
    }

    /**
     * Methods scrolls down using JavaScript executor
     * @param pixel
     */

    public static void scrollDown(int pixel){
        getJSExecutor().executeScript("window.scrollBy(0,"+ pixel+")");
    }

    /**
     *
     * @return
     */

    public static WebDriverWait getWaitObject(){
        return new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
    }

    /**
     *
     * @param element
     */

    public static void waitForClickability(WebElement element){
        getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     *
     * @param element
     */

    public static void click(WebElement element){
        waitForClickability(element);
        element.click();
    }
    public static void takeScreenShot(String fileName){
        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File(Constants.TAKE_SCREEN_SHOOT+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getTime(){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        return sdf.format(date);
    }


}
