package ru.leroymerlin.qa.test.vedportal;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Driver {

    private static final int SCREEN_WIDTH = 1366;
    private static final int SCREEN_HEIGHT = 768;

    protected WebDriver driver;
    protected JavascriptExecutor jse;

    @BeforeSuite
    static void setUpAll() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\60096212\\IdeaProjects\\LMTest\\win\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "./win/chromedriver.exe");
    }

    @BeforeTest
    void initDriver() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--window-size=" + SCREEN_WIDTH + "," + SCREEN_HEIGHT);
        driver = new ChromeDriver(option);
        jse = (JavascriptExecutor)driver;
    }

    @AfterTest
    void closeUp() {
        if ("ab".equals("ab"))
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


//    WebElement searchButton = wait.until(
//            visibilityOfElementLocated
//                    (searchButtonSelector));

    public void scrollBy(int y) {
        jse.executeScript("window.scrollBy(0, "+ y + ")");
    }

    public boolean isVisible(WebElement el) {
        int elY = el.getLocation().getY();
        int elX = el.getLocation().getX();
        int elWidth = el.getSize().getWidth();
        int elHeight = el.getSize().getHeight();
        int scroll = (int) jse.executeScript("return Math.max(document.body.scrollHeight, document.documentElement.scrollHeight,document.body.offsetHeight, document.documentElement.offsetHeight,document.body.clientHeight, document.documentElement.clientHeight);");
        return scroll < elY && SCREEN_HEIGHT + scroll > elY + elHeight && SCREEN_WIDTH > elX + elWidth
                ? true
                : false;
    }

}
