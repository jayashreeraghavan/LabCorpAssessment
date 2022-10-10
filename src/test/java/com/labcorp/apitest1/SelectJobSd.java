package com.labcorp.apitest1;

import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectJobSd {
    ChromeDriver driver = new ChromeDriver();

    @BeforeAll
    public static void before_all() {
        WebDriverManager.chromedriver().setup();
    }


    @Given("I open {string} and type {string}")
    public void iOpenAndType(String arg0, String arg1) {
        driver.manage().window().maximize();
        driver.get(arg0);
        driver.findElement(By.id("typehead")).click();
        driver.findElement(By.id("typehead")).sendKeys(arg1);
    }

    @When("Select Autosuggestion having {string}")
    public void selectAutosuggestionHaving(String arg0) {
        WebElement jobHeading = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#ph-search-job-heading > ppc-content")));
        if (jobHeading.isDisplayed()) {
            WebElement autoSuggest = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#typehead-result-item-0 > .au-target .au-target")));
            if (autoSuggest.getText().contains(arg0)) {
                autoSuggest.click();
            }
        }
    }

    @Then("Browse to the position  and confirm job tile is {string}")
    public void browseToThePositionAndConfirmJobTileIs(String arg0) {
        boolean isHavingJobTitle = driver.findElement(By.className("job-title")).getText().contains(arg0);
        Assertions.assertTrue(isHavingJobTitle);
    }

    @After
    public void quitDriver() {
        driver.quit();
    }
}
