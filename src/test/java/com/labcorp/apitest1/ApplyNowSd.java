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
import java.util.ArrayList;

public class ApplyNowSd {
    ChromeDriver driver = new ChromeDriver();


    @BeforeAll
    public static void before_all() {
        WebDriverManager.chromedriver().setup();
    }

    @Given("I'm in Job Apply page  {string}")
    public void iMInJobApplyPage(String arg0) {
        driver.manage().window().maximize();
        driver.get(arg0);
    }

    @When("I click Apply Now button")
    public void iClickApplyNowButton() {
        WebElement applyNow = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@aria-label='Apply Now for COVAGLOBAL2190223RMEXTERNALENGLOBAL']")));
        applyNow.click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        WebElement careerHref = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@alt='careers']")));
        Assertions.assertTrue(careerHref.isEnabled());
    }

    @Then("I entering Username {string} And password  {string}")
    public void iEnteringUsernameAndPassword(String arg0, String arg1) {
        WebElement signIn = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@aria-label='Sign In']")));
        driver.findElement(By.id("input-4")).click();
        driver.findElement(By.id("input-4")).sendKeys(arg0);
        driver.findElement(By.id("input-5")).click();
        driver.findElement(By.id("input-5")).sendKeys(arg1);
        if (signIn.isDisplayed()) {
            signIn.click();
        }
    }

    @Then("verify application data")
    public void verifyApplicationData() {
        WebElement viewMyapplication = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@role='link']")));
        viewMyapplication.click();
        WebElement roleDesc = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='css-85ki2w']")));
        WebElement jobId = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='css-x4yhc3']")));
        WebElement jobStatus = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='css-1ynlkts']")));
        Assertions.assertTrue(roleDesc.getText().contains("QA"));
        Assertions.assertTrue(jobId.getText().contains("21-90223_RM"));
        Assertions.assertTrue(jobStatus.getText().contains("In Process"));
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
    }

    @After
    public void quitDriver() {
        driver.quit();
    }
}
