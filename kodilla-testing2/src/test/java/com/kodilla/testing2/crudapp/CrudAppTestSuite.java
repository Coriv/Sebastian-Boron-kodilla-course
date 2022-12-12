package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class CrudAppTestSuite {
    private static WebDriver driver;
    private static Random generator;
    private static final String BASE_URL = "https://coriv.github.io";

    @BeforeAll
    public static void initTest() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @AfterAll
    public static void cleanUpAfterTest() {
        driver.close();
    }

    private String createCrudAppTaskTest() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action, \"v1/task\")]/fieldset[1]/input";
        final String XPATH_TASK_DESC = "//form[contains(@action, \"v1/task\")]/fieldset[2]/textarea";
        final String XPATH_BUTTON_ADD = "//form[contains(@action, \"v1/task\")]/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);            // [1]
        String taskContent = taskName + " content";

        WebElement taskField = driver.findElement(By.xpath(XPATH_TASK_NAME));
        taskField.sendKeys(taskName);

        WebElement descField = driver.findElement(By.xpath(XPATH_TASK_DESC));
        descField.sendKeys(taskContent);

        WebElement buttonAdd = driver.findElement(By.xpath(XPATH_BUTTON_ADD));
        buttonAdd.click();
        Thread.sleep(2000);

        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) {
        driver.navigate().refresh();

        while(!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(By.xpath("//form[@class=\"datatable__row\")]"))
                .stream()
                .filter(anyForm -> driver.findElement(By.xpath("//p[@class=\"datatable__field-value\"]")))
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTaskTest();
    }
}
