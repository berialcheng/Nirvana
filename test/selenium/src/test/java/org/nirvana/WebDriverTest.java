package org.nirvana;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by zhongch on 6/17/2016.
 */
public class WebDriverTest {

    private static WebDriver driver = null;

    @BeforeClass
    public static void beforeClass(){
        //Step 1- Driver Instantiation: Instantiate driver object as FirefoxDriver
        //System.setProperty("webdriver.firefox.bin", "D:/Program Files/Mozilla firefox/firefox.exe");
        //driver = new FirefoxDriver();

        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\zhongch\\Desktop\\chromedriver_win32\\chromedriver.exe");
        //driver = new ChromeDriver();

        System.setProperty("phantomjs.binary.path", "C:\\Users\\zhongch\\Desktop\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
        driver = new PhantomJSDriver();

        //driver = new HtmlUnitDriver();
    }

    @org.junit.Test
    public void test1(){
        driver.navigate().to("https://www.baidu.com");

        Assert.assertEquals("Title audit failed!", "百度一下，你就知道", driver.getTitle());


        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                driver.findElement(By.name("wd"));
                return Boolean.TRUE;
            }
        });

        WebElement element = driver.findElement(By.name("wd"));
        element.sendKeys("Selenium");

        WebElement searchElement = driver.findElement(By.id("su"));
        searchElement.click();

        Assert.assertEquals("Title audit failed!", "selenium_百度搜索", driver.getTitle());
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
        driver.quit();
    }
}
