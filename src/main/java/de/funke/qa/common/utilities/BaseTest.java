package de.funke.qa.common.utilities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    static final Logger logger = Logger.getLogger(BaseTest.class);

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        String pathToCommonProjectDir = System.getProperty("pathToCommonProjectDir", "/Users/cwandja/projects/common");
        System.setProperty("webdriver.chrome.driver", pathToCommonProjectDir + "/src/main/resources/chromedriver2");
        Configuration.browser = System.getProperty("selenide.browser", "chrome");
        WebDriver.Window window = WebDriverRunner.getWebDriver().manage().window();
        window.maximize();
        Dimension size = window.getSize();
        System.out.println("Display size = " + size.getWidth() + "x" + size.getHeight());
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {

    }

}