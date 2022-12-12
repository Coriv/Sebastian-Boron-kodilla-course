package com.kodilla.testing2.ebay;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EBayTestingApp {

    public static final String ELEMENT = "_nkw";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://ebay.com");

        WebElement searchedElement = driver.findElement(By.name(ELEMENT));
        searchedElement.sendKeys("laptop");
        searchedElement.submit();
    }
}
