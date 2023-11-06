package Minso.test.form;

import Minso.settings.RetryTest;
import Minso.settings.TestSetup;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class sendForm extends TestSetup {

    @Test (groups = {"form", "sendForm"}, priority = 1, retryAnalyzer = RetryTest.class)
    @Description("sendFormAddEmployee")
    public void sendFormAddEmployee () throws InterruptedException {

        WebElement selectNext = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='uArJ5e UQuaGc YhQJj zo8FOc ctEux'] span[class='l4V7wb Fxmcue']")));
        selectNext.click();

        WebElement addFirstName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[role='list'] div:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(1) div:nth-child(1) input:nth-child(1)")));
        addFirstName.sendKeys(firstName);

        WebElement addLastName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div:nth-child(3) div:nth-child(1) div:nth-child(1) div:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(1) div:nth-child(1) input:nth-child(1)")));
        addLastName.sendKeys(lastName);

        WebElement addDateIfBirth = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='date']")));
        addDateIfBirth.sendKeys(dateOfBirth);

        WebElement selectFulltArbetsforDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[role='listbox']")));
        selectFulltArbetsforDropdown.click();

        WebElement selectYes = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div:nth-child(9) > div:nth-child(2) > form:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > span:nth-child(2)")));
        selectYes.click();

        Thread.sleep(1000);

        WebElement selectNext3 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div:nth-child(9) > div:nth-child(2) > form:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > span:nth-child(3) > span:nth-child(1)")));
        selectNext3.click();

        boolean verifyNewHeadingForm = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "Lägg till tjänstledighet"));
        Assert.assertTrue(verifyNewHeadingForm);

    }

    @Test(groups = {"form", "sendForm"}, priority = 1, retryAnalyzer = RetryTest.class, dependsOnMethods = "sendFormAddEmployee")
    @Description("sendFormAddLeave")
    public void sendFormAddLeave() throws InterruptedException {

        boolean verifyHeadingForm = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "Lägg till tjänstledighet"));
        Assert.assertTrue(verifyHeadingForm);

        WebElement addSocialSecurityNumber = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[role='list'] div:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(1) div:nth-child(1) input:nth-child(1)")));
        addSocialSecurityNumber.sendKeys(socialSecurityNumber);

        WebElement addFrom = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='date']")));
        addFrom.sendKeys(onLeaveFromDate);

        Thread.sleep(1000);

        WebElement selectNext3 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body div[class='Uc2NEf'] div[class='teQAzf'] form[id='mG61Hd'] div[class='RH5hzf RLS9Fe'] div[class='lrKTG'] div[class='ThHDze'] div[class='DE3NNc CekdCb'] div[class='lRwqcd'] div:nth-child(2) span:nth-child(1)")));
        selectNext3.click();

        boolean verifyHeadingReportSalary = driver.getPageSource().contains("Rapportera lön");
        Assert.assertTrue(verifyHeadingReportSalary);

    }

    @Test(groups = {"form", "sendForm"}, priority = 1, retryAnalyzer = RetryTest.class, dependsOnMethods = "sendFormAddLeave")
    @Description("sendFormReportSalary")
    public void sendFormReportSalary () throws InterruptedException {

        boolean verifyHeadingReportSalary = driver.getPageSource().contains("Rapportera lön");
        Assert.assertTrue(verifyHeadingReportSalary);

        WebElement addSocialSecurityNumber = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='rFrNMe k3kHxc RdH0ib yqQS1 zKHdkd'] input[type='text']")));
        addSocialSecurityNumber.sendKeys(socialSecurityNumber);

        WebElement addNewMonthlySalary = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".whsOnd.zHQkBf[jsname='YPqjbf'][autocomplete='off'][tabindex='0'][aria-labelledby='i5']")));
        addNewMonthlySalary.sendKeys(monthlySalary);

        WebElement addNewMonthlySalaryFrom = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='date']")));
        addNewMonthlySalaryFrom.sendKeys(monthlySalaryFromDate);

        WebElement sendFrom = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='uArJ5e UQuaGc Y5sE8d VkkpIf QvWxOd'] span[class='l4V7wb Fxmcue']")));
        sendFrom.click();

        boolean verifySubmittedVerification = driver.getPageSource().contains("Ditt svar är registrerat.");
        Assert.assertTrue(verifySubmittedVerification);

    }
}