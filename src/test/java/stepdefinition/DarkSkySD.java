package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.HomePageDarkSky;
import org.testng.Assert;
import java.text.ParseException;

public class DarkSkySD {

    private HomePageDarkSky homePage = new HomePageDarkSky();

    @Given("^I am on Darksky Home Page$")
    public void setDarkSkyPage() {
        Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(), "https://darksky.net/forecast/40.7127,-74.0059/us12/en");
    }

    @And("^I click on Dark Sky API link$")
    public void iClickOnDarkSkyAPILink() {
        homePage.clickDarkSkyApi();
    }

    @And("^I click on Sign Up link$")
    public void iClickOnSignUpLink() {
        homePage.clickSignUp();
    }

    @And("^I click on Register button$")
    public void iClickOnRegisterButton() {
        homePage.clickRegisterButton();
    }

    @Then("^I verify error message \"([^\"]*)\"$")
    public void iVerifyErrorMessage(String arg0) throws Throwable {
        homePage.isEmailAdressTextFieldVisible();
    }

    @When("^I created a temperature list from Daily Timeline$")
    public void iCreateDailyTempList() throws ParseException {
        homePage.getDailyTempList();
    }

    @And("^I got current temperature$")
    public void iGetCurrentTemp() throws ParseException { homePage.getCurrentTemp();
    }

    @Then ("^I verify current temp is not greater or less then temps from daily timeline$")
    public void iVerifyCurrentTempFromDailyTl() { homePage.verifyCurrentTempFromDailyTl();
    }

    @And("^I expand todays timeline$")
    public void iExpandTodaysTimeline() throws InterruptedException {homePage.clickTodayIcon();
    }

    @When("^I scroll down the page$")
    public void iScrollDownThePage() throws InterruptedException {
        homePage.scrollDown(0,900);

    }

    @And("^I got Todays min and max temperature$")
    public void iGotTodaysMinAndMaxTemperature() throws ParseException, InterruptedException {
        homePage.getTodaysMinAndMaxTempValue();
    }

    @And("^I got Todays min and max temperature displays$")
    public void iGotTodaysMinAndMaxTemperatureDisplays() throws ParseException {
        homePage.getTodayMinAndMaxTempDisplayValue();
    }

    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void iVerifyLowestAndHighestTempIsDisplayedCorrectly() throws ParseException {
        homePage.verifyTodaysLowAndHighTemp();
    }

    @When("^I got hours list from Timeline$")
    public void iGotHoursListFromTimeline() {
        homePage.getHoursListFromTimeLine();
    }

    @And("^I check current time and next two hours incremented$")
    public void iCheckCurrentTimeAndNextTwoHoursIncremented() {
        homePage.getHoursListFromSystem();
    }

    @Then("^I verify timeline is displayed with two hours incremented$")
    public void iVerifyTimelineIsDisplayedWithTwoHoursIncremented() {
        homePage.verifyHoursTlAndSystem();
    }

}