package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.JTFPageObjects;

public class TestJTFPage {
        WebDriver driver = null;

        @BeforeTest
        public void setUpTest() {
                driver = new ChromeDriver();
        }

        @Test
        public void testJTFTitle() {
                String expectedTitle;
                String actualTitle;
                driver.get("http://localhost:8000");
                expectedTitle = "SFE";
                actualTitle = driver.getTitle();
                Assert.assertEquals(actualTitle, expectedTitle);
        }

        @Test
        public void testJTFSearchPageTitle() {
                String expectedTitle;
                String actualTitle;
                JTFPageObjects JTFPageObject = new JTFPageObjects(driver);
                driver.get("http://localhost:8000");
                JTFPageObject.setTextInTextBox("coffee");
                JTFPageObject.clickButton();
                for(String winHandle : driver.getWindowHandles()) {
                        driver.switchTo().window(winHandle);
                }
                expectedTitle = "coffee site:google.com - Google Search";
                actualTitle = driver.getTitle();
                Assert.assertEquals(actualTitle, expectedTitle);
                }

        @AfterTest
        public void tearDownTest() {
                driver.quit();
                System.out.println("Test Completed Successfully");
        }
}
