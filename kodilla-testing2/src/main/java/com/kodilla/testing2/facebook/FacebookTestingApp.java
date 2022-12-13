package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacebookTestingApp {
    private static final String DOMAIN = "https://facebook.com";
    private static final String XPATH_COOKIES = "//div[@class=\"_4-i2 _pig _9o-c _9pll _50f4\"]/div[3]/button[1]";
    private static final String XPATH_CREATE_ACCOUNT = "//div[@class=\"_6ltg\"]/a";
    private static final String XPATH_FORM = "//form[@method=\"post\" and @id=\"reg\"]";
    private static final String XPATH_NAME = XPATH_FORM + "/div[1]/div[1]/div[1]/div[1]/div/input";
    private static final String XPATH_SURNAME = XPATH_FORM + "/div[1]/div[1]/div[1]/div[2]/div/div[1]/input";
    private static final String XPATH_MAIL = XPATH_FORM + "/div[1]/div[2]/div/div[1]/input";
    private static final String XPATH_MAIL_REPEAT = XPATH_FORM + "/div[1]/div[3]/div/div/div[1]/input";
    private static final String XPATH_PASS = XPATH_FORM + "/div[1]/div[4]/div/div[1]/input";
    private static final String XPATH_DAY_OF_BIRTH = XPATH_FORM + "/div[1]/div[5]/div[2]/span/span/select[1]";
    private static final String XPATH_MONTH_OF_BIRTH = XPATH_FORM + "/div[1]/div[5]/div[2]/span/span/select[2]";
    private static final String XPATH_YEAR_OF_BIRTH = XPATH_FORM + "/div[1]/div[5]/div[2]/span/span/select[3]";
    private static final String XPATH_SEX_MAN = XPATH_FORM + "/div[1]/div[7]/span/span[2]/input";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(DOMAIN);

        driver.findElement(By.xpath(XPATH_COOKIES)).click();
        driver.findElement(By.xpath(XPATH_CREATE_ACCOUNT)).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(XPATH_NAME)).sendKeys("Sebastian");
        driver.findElement(By.xpath(XPATH_SURNAME)).sendKeys("Testing");
        driver.findElement(By.xpath(XPATH_MAIL)).sendKeys("test@test.com");
        driver.findElement(By.xpath(XPATH_PASS)).sendKeys("TestPassword");

        WebElement dayOfBirth = driver.findElement(By.xpath(XPATH_DAY_OF_BIRTH));
        Select daySelect = new Select(dayOfBirth);
        daySelect.selectByIndex(19);

        WebElement monthOfBirth = driver.findElement(By.xpath(XPATH_MONTH_OF_BIRTH));
        Select monthSelect = new Select(monthOfBirth);
        monthSelect.selectByIndex(3);

        WebElement yearOfBirth = driver.findElement(By.xpath(XPATH_YEAR_OF_BIRTH));
        Select yearSelect = new Select(yearOfBirth);
        yearSelect.selectByVisibleText("1995");

        driver.findElement(By.xpath(XPATH_SEX_MAN)).click();
        driver.findElement(By.xpath(XPATH_MAIL_REPEAT)).sendKeys("test@test.com");

        Thread.sleep(2000);
        driver.close();
    }
}
