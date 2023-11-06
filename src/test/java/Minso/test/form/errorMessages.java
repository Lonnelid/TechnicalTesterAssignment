package Minso.test.form;

import Minso.settings.RetryTest;
import Minso.settings.TestSetup;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class errorMessages extends TestSetup {

    @Test (groups = {"form", "errorMessage"}, priority = 1, retryAnalyzer = RetryTest.class)
    @Description("errorMessageAddEmployee")
    public void errorMessageAddEmployee() throws InterruptedException {

        WebElement selectNext = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='uArJ5e UQuaGc YhQJj zo8FOc ctEux'] span[class='l4V7wb Fxmcue']")));
        selectNext.click();

        WebElement addNonFirstName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[role='list'] div:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(1) div:nth-child(1) input:nth-child(1)")));
        addNonFirstName.sendKeys(Keys.TAB);
        Boolean errorMessageNonFirstName = wait.until((ExpectedConditions.textToBePresentInElementLocated(By.tagName("Body"), "Det här är en obligatorisk fråga")));
        assertTrue(errorMessageNonFirstName);

        WebElement addNonLastName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div:nth-child(3) div:nth-child(1) div:nth-child(1) div:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(1) div:nth-child(1) input:nth-child(1)")));
        addNonLastName.sendKeys(Keys.TAB);
        Boolean errorMessageNonLastName = wait.until((ExpectedConditions.textToBePresentInElementLocated(By.tagName("Body"), "Det här är en obligatorisk fråga")));
        assertTrue(errorMessageNonLastName);

        WebElement addNonDateIfBirth = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='date']")));
        addNonDateIfBirth.sendKeys(Keys.TAB, Keys.TAB, Keys.TAB);
        Boolean errorMessageNonDateIfBirth = wait.until((ExpectedConditions.textToBePresentInElementLocated(By.tagName("Body"), "Det här är en obligatorisk fråga")));
        assertTrue(errorMessageNonDateIfBirth);

        WebElement selectNonFulltArbetsforDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[role='listbox']")));
        Actions actions = new Actions(driver);
        actions.sendKeys(selectNonFulltArbetsforDropdown, Keys.TAB).perform();
        Boolean errorMessageNonFulltArbetsforDropdown = wait.until((ExpectedConditions.textToBePresentInElementLocated(By.tagName("Body"), "Det här är en obligatorisk fråga")));
        assertTrue(errorMessageNonFulltArbetsforDropdown);

        WebElement selectNext2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body div[class='Uc2NEf'] div[class='teQAzf'] form[id='mG61Hd'] div[class='RH5hzf RLS9Fe'] div[class='lrKTG'] div[class='ThHDze'] div[class='DE3NNc CekdCb'] div[class='lRwqcd'] div:nth-child(2) span:nth-child(1)")));
        selectNext2.click();

        boolean verifyHeadingForm = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "Lägg till anställd"));
        Assert.assertTrue(verifyHeadingForm);

        WebElement addFirstName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[role='list'] div:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(1) div:nth-child(1) input:nth-child(1)")));
        addFirstName.sendKeys(firstName);

        WebElement addLastName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div:nth-child(3) div:nth-child(1) div:nth-child(1) div:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(1) div:nth-child(1) input:nth-child(1)")));
        addLastName.sendKeys(lastName);

        WebElement addDateOffBirth = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='date']")));
        addDateOffBirth.sendKeys(dateOfBirth);

        WebElement selectFulltArbetsforDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[role='listbox']")));
        selectFulltArbetsforDropdown.click();

        WebElement selectYes = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div:nth-child(9) > div:nth-child(2) > form:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > span:nth-child(2)")));
        selectYes.click();

        Thread.sleep(1000);

        boolean errorMessageIsNotPresent = !driver.getPageSource().contains("Det här är en obligatorisk fråga");
        Assert.assertTrue(errorMessageIsNotPresent);

        WebElement selectNext3 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div:nth-child(9) > div:nth-child(2) > form:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > span:nth-child(3) > span:nth-child(1)")));
        selectNext3.click();

        boolean verifyNewHeadingForm = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "Lägg till tjänstledighet"));
        Assert.assertTrue(verifyNewHeadingForm);

    }

    @Test(groups = {"form", "errorMessage"}, priority = 1, retryAnalyzer = RetryTest.class, dependsOnMethods = "errorMessageAddEmployee")
    @Description("errorMessageAddLeave")
    public void errorMessageAddLeave() throws InterruptedException {

        boolean verifyHeadingForm = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "Lägg till tjänstledighet"));
        Assert.assertTrue(verifyHeadingForm);

        WebElement addNonSocialSecurityNumber = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[role='list'] div:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(1) div:nth-child(1) input:nth-child(1)")));
        addNonSocialSecurityNumber.sendKeys(Keys.TAB);
        Boolean errorMessageNonSocialSecurityNumber = wait.until((ExpectedConditions.textToBePresentInElementLocated(By.tagName("Body"), "Det här är en obligatorisk fråga")));
        assertTrue(errorMessageNonSocialSecurityNumber);

        WebElement addNonFrom = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='date']")));
        addNonFrom.sendKeys(Keys.TAB, Keys.TAB, Keys.TAB);
        Boolean errorMessageNonFrom = wait.until((ExpectedConditions.textToBePresentInElementLocated(By.tagName("Body"), "Det här är en obligatorisk fråga")));
        assertTrue(errorMessageNonFrom);

        WebElement selectNext2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body div[class='Uc2NEf'] div[class='teQAzf'] form[id='mG61Hd'] div[class='RH5hzf RLS9Fe'] div[class='lrKTG'] div[class='ThHDze'] div[class='DE3NNc CekdCb'] div[class='lRwqcd'] div:nth-child(2) span:nth-child(1)")));
        selectNext2.click();

        boolean verifyHeadingAddLeave = driver.getPageSource().contains("Lägg till tjänstledighet");
        Assert.assertTrue(verifyHeadingAddLeave);

        WebElement addSocialSecurityNumber = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[role='list'] div:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(1) div:nth-child(1) input:nth-child(1)")));
        addSocialSecurityNumber.sendKeys(socialSecurityNumber);

        WebElement addFrom = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='date']")));
        addFrom.sendKeys(onLeaveFromDate);

        Thread.sleep(1000);

        boolean errorMessageIsNotPresent = !driver.getPageSource().contains("Det här är en obligatorisk fråga");
        Assert.assertTrue(errorMessageIsNotPresent);

        WebElement selectNext3 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body div[class='Uc2NEf'] div[class='teQAzf'] form[id='mG61Hd'] div[class='RH5hzf RLS9Fe'] div[class='lrKTG'] div[class='ThHDze'] div[class='DE3NNc CekdCb'] div[class='lRwqcd'] div:nth-child(2) span:nth-child(1)")));
        selectNext3.click();

        boolean verifyHeadingReportSalary = driver.getPageSource().contains("Rapportera lön");
        Assert.assertTrue(verifyHeadingReportSalary);

    }

    @Test(groups = {"form", "errorMessage"}, priority = 1, retryAnalyzer = RetryTest.class, dependsOnMethods = "errorMessageAddLeave")
    @Description("errorMessageReportSalary")
    public void errorMessageReportSalary () {

        boolean verifyHeadingReportSalary = driver.getPageSource().contains("Rapportera lön");
        Assert.assertTrue(verifyHeadingReportSalary);

        WebElement addNonSocialSecurityNumber = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='rFrNMe k3kHxc RdH0ib yqQS1 zKHdkd'] input[type='text']")));
        addNonSocialSecurityNumber.sendKeys(Keys.TAB);
        Boolean errorMessageNonSocialSecurityNumber = wait.until((ExpectedConditions.textToBePresentInElementLocated(By.tagName("Body"), "Det här är en obligatorisk fråga")));
        assertTrue(errorMessageNonSocialSecurityNumber);

        WebElement addNonNewMonthlySalary = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".whsOnd.zHQkBf[jsname='YPqjbf'][autocomplete='off'][tabindex='0'][aria-labelledby='i5']")));
        addNonNewMonthlySalary.sendKeys(Keys.TAB);
        Boolean errorMessageNonNewMonthlySalary = wait.until((ExpectedConditions.textToBePresentInElementLocated(By.tagName("Body"), "Det här är en obligatorisk fråga")));
        assertTrue(errorMessageNonNewMonthlySalary);

        WebElement addNonNewMonthlySalaryFrom = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='date']")));
        addNonNewMonthlySalaryFrom.sendKeys(Keys.TAB, Keys.TAB, Keys.TAB);
        Boolean errorMessageNonNewMonthlySalaryFrom = wait.until((ExpectedConditions.textToBePresentInElementLocated(By.tagName("Body"), "Det här är en obligatorisk fråga")));
        assertTrue(errorMessageNonNewMonthlySalaryFrom);

        WebElement addSocialSecurityNumber = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='rFrNMe k3kHxc RdH0ib yqQS1 zKHdkd'] input[type='text']")));
        addSocialSecurityNumber.sendKeys(socialSecurityNumber);

        WebElement addNewMonthlySalary = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".whsOnd.zHQkBf[jsname='YPqjbf'][autocomplete='off'][tabindex='0'][aria-labelledby='i5']")));
        addNewMonthlySalary.sendKeys(monthlySalary);

        WebElement addNewMonthlySalaryFrom = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='date']")));
        addNewMonthlySalaryFrom.sendKeys(monthlySalaryFromDate);

        boolean errorMessageIsNotPresent = !driver.getPageSource().contains("Det här är en obligatorisk fråga");
        Assert.assertTrue(errorMessageIsNotPresent);

    }
}