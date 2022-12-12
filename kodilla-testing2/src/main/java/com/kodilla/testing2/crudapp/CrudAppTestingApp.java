package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CrudAppTestingApp {

public static final String domain = "https://coriv.github.io/";
public static final String xPathTask = "html/body/main/section/form/fieldset/input";
public static final String xPathDescription = "html/body/main/section/form/fieldset/textarea";
public static final String xPathSelect  = "//select[1]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(domain);

        WebElement elementTask = driver.findElement(By.xpath(xPathTask));
        elementTask.sendKeys("New task by testing app");

        WebElement elementDesc = driver.findElement(By.xpath(xPathDescription));
        elementDesc.sendKeys("Added by selenium web driver");

        while (!driver.findElement(By.xpath(xPathSelect)).isDisplayed());

        WebElement select = driver.findElement(By.xpath(xPathSelect));
        Select selectBoard = new Select(select);
        selectBoard.selectByIndex(1);
    }
}
