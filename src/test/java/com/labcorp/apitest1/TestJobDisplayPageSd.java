package com.labcorp.apitest1;

import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestJobDisplayPageSd {

    ChromeDriver driver = new ChromeDriver();

    @BeforeAll
    public static void before_all() {
        WebDriverManager.chromedriver().setup();
    }

    @Given("I'm in Job Page with Job id {string}")
    public void iMInJobPageWithJobId(String arg0) {
        driver.manage().window().maximize();
        driver.get(arg0);
    }

    @Then("verify job data")
    public void verifyJobData() {
        String location = " Durham, North Carolina, United States of America ";
        String jobTitle = driver.findElement(By.className("job-title")).getText();
        String jobLocation = driver.findElement(By.cssSelector(".au-target.job-location")).getText().replace("Location\n", "");
        String jobId = driver.findElement(By.xpath("//span[@class='au-target jobId']")).getText();
        String expectedJd = "The right candidate for this role will participate in the test automation technology development and best practice models";
        String expectedBulletinPoint = "Prepare test plans, budgets, and schedules";
        String expectedExperience = "5+ years of experience in QA automation development and scripting";
        String familiarTools = driver.findElement(By.xpath("//p[contains(text(),'Familiar with common test automation tools includi')]")).getText();

        WebElement jdInfoElement = this.driver.findElement(By.cssSelector(".jd-info"));

        Assertions.assertTrue(jobTitle.contains("QA Test Automation Developer"));
        Assertions.assertTrue(jobLocation.trim().contains(location.trim()));
        Assertions.assertTrue(jobId.contains("21-90223_RM"));
        Assertions.assertTrue(getJdSentence(jdInfoElement).contains(expectedJd.trim()));
        Assertions.assertTrue(getBulletPoint(jdInfoElement, "Management Support:", 1).contains(expectedBulletinPoint.trim()));
        Assertions.assertFalse(getBulletPoint(jdInfoElement, "Requirements:", 2).contains(expectedExperience.trim())); // This will fail because Dot missing under Requirements in 2 bulletpoint
        Assertions.assertTrue(familiarTools.split(":", 2)[1].trim().startsWith("Selenium"));
    }

    public String getJdSentence(WebElement jdInfoElement) {
        List<WebElement> pElements = jdInfoElement.findElements(By.xpath("./child::*"));
        String[] jobDescriptionSentence = pElements.get(2).getText().split("\\.");
        String actualJd = jobDescriptionSentence[4].trim();
        return actualJd;
    }

    public String getBulletPoint(WebElement jdInfoElement, String boldText, int bulletinPosition) {
        List<WebElement> pElements = jdInfoElement.findElements(By.xpath("./child::*"));
        int bulletPointPosition = 0;
        for (int i = 0; i < pElements.size(); i++) {
            if (pElements.get(i).getText().equals(boldText)) {
                bulletPointPosition = i + 1;
                break;
            }
        }
        String[] bulletPointsAsArr = pElements.get(bulletPointPosition).getText().split("\\.");
        return bulletPointsAsArr[bulletinPosition];
    }


    //p[contains(text(),'Familiar with common test automation tools includi')]
    @After
    public void quitDriver() {
        driver.quit();
    }
}
