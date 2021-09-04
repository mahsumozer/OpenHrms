package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigsReader;
import utils.Constants;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

        switch (ConfigsReader.getPropValue("browser")){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", Constants.GECKODRIVER_PATH);
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Browser is not supported");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        driver.get(ConfigsReader.getPropValue("applicationUrl"));
    pageInitializer.initializePageObjects();
    }

    @AfterMethod(alwaysRun = true)
    public void close(){
        if(driver!=null){
            driver.quit();
        }
    }
}
