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
import java.util.List;

public class LaunchCareerSd {

    ChromeDriver driver = new ChromeDriver();


    @BeforeAll
    public static void before_all() {
        WebDriverManager.chromedriver().setup();
    }

    @Given("Open labcorp site")
    public void openLabcorpSite() {
        driver.manage().window().maximize();
        driver.get("https://www.labcorp.com/");
    }

    @When("click on career link")
    public void clickOnCareerLink() {
        WebElement careerHref = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Careers')]")));
        careerHref.click();
    }

    @Then("verify Im in  career search page")
    public void verifyImInCareerSearchPage() {
         //confirm the career page is opened by the presence of text Job Search
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));
        List<WebElement> elements = driver.findElements(By.linkText("Job Search"));
        Assertions.assertTrue(!elements.isEmpty());
    }

    @After
    public void quitDriver() {
        driver.quit();
    }



}
