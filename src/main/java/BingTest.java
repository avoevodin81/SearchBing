import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BingTest {
    public static void main(String[] args) {
        //create the new google driver
        WebDriver driver = new BingTest().getDriver();
        //open the bing search page
        driver.get("https://www.bing.com/");

        //find the input search field by class name
        WebElement input = driver.findElement(By.className("b_searchbox"));
        //fill the input field
        input.sendKeys("automation");
        //submit the form
        input.submit();

        //create the wait element
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait the next navigation element by class name
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("sb_pagN")));

        //print to console the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        //create the list of the search results by class name
        List<WebElement> titles = driver.findElements(By.className("b_algo"));

        //print to console the titles of the search results
        for (WebElement element : titles) {
            System.out.println(element.findElement(By.tagName("a")).getText());
        }

        //quit the google driver
        driver.quit();
    }

    public WebDriver getDriver() {
        //get driver path property
        String driverPath = System.getProperty("user.dir") + "/driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

        return new ChromeDriver();
    }
}
