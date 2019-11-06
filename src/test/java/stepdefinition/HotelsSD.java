package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.BasePage;
import framework.webPages.HomePageHotels;
import framework.webPages.SearchPageHotels;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import java.text.ParseException;

public class HotelsSD extends BasePage {
    
    private HomePageHotels hotels = new HomePageHotels();
    private SearchPageHotels searchPageHotels = new SearchPageHotels();

    @Given("^I am on hotels.com Home Page$")
    public void setHotelsPage() {
        Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(), "https://www.hotels.com/");
        hotels.clickOnPopupCloseButton();
    }

    @Then("^I select (.+) from room dropdown$")
    public void iSelectSelect_roomsFromRoomDropdown(String selectRoomStr) throws InterruptedException {

        hotels.clickOnOccupancyDropDown();
        Thread.sleep(2000);
        hotels.selectFromDropDown("More options…");
        Thread.sleep(2000);

        switch (selectRoomStr) {
            case "1" :
                hotels.selectRoomFromDropDown("1");
                Thread.sleep(2000);
                break;
            case "2" :
                hotels.selectRoomFromDropDown("2");
                Thread.sleep(2000);
                break;
            case "3" :
                hotels.selectRoomFromDropDown("3");
                Thread.sleep(2000);
                break;
            case "4" :
                hotels.selectRoomFromDropDown("4");
                Thread.sleep(2000);
                break;
            case "5" :
                hotels.selectRoomFromDropDown("5");
                Thread.sleep(2000);
                break;
            case "6" :
                hotels.selectRoomFromDropDown("6");
                Thread.sleep(2000);
                break;
            case "7" :
                hotels.selectRoomFromDropDown("7");
                Thread.sleep(2000);
                break;
            case "8" :
                hotels.selectRoomFromDropDown("8");
                Thread.sleep(2000);
                break;
            case "9+" :
                hotels.selectRoomFromDropDown("9");
                Thread.sleep(2000);
                break;
        }
    }


    @And("^I verify (.+) is displayed$")
    public void iVerifyNumber_of_room_dropdownIsDisplayed(int numberOfRoomDropdown) throws InterruptedException {
        switch (numberOfRoomDropdown) {
            case 1 :
                Assert.assertTrue(hotels.isAdultAndChildrenDisplayed(), "Rooms1 are not displayed");
                break;
            case 2 :
                Assert.assertTrue(hotels.isRoomNumberDisplayed("2"),"Rooms2 are not displayed");
                break;
            case 3 :
                Assert.assertTrue(hotels.isRoomNumberDisplayed("3"),"Rooms3 are not displayed");
                break;
            case 4 :
                Assert.assertTrue(hotels.isRoomNumberDisplayed("4"),"Rooms4 are not displayed");
                break;
            case 5 :
                Assert.assertTrue(hotels.isRoomNumberDisplayed("5"),"Rooms5 are not displayed");
                break;
            case 6 :
                hotels.scrollDown(0,300);
                Assert.assertTrue(hotels.isRoomNumberDisplayed("6"),"Rooms6 are not displayed");
                break;
            case 7 :
                hotels.scrollDown(0,400);
                Assert.assertTrue(hotels.isRoomNumberDisplayed("7"),"Rooms7 are not displayed");
                break;
            case 8 :
                hotels.scrollDown(0,500);
                Assert.assertTrue(hotels.isRoomNumberDisplayed("8"),"Rooms8 are not displayed");
                break;
            case 0 :
                Assert.assertFalse(hotels.isElementPresent());
                break;
        }
    }

    @Given("^I am on default locations search result screen$")
    public void iAmOnDefaultLocationsSearchResultScreen() throws InterruptedException {
        hotels.setDestinationValue("New York");
        hotels.selectCheckInAndCheckOutDate();
    }

    @When("^I select property class (.+)$")
    public void iSelectPropertyClassStars(String starHotel) throws InterruptedException {
        switch (starHotel) {
            case "5 stars" :
                searchPageHotels.clickOnFiveStarCheckBox();
                searchPageHotels.scrollDownAsBottom();
                searchPageHotels.starHotel45List();
                //System.out.println("5 Star List : " +searchPageHotels.starHotel45List());
                break;

            case "4 stars" :
                searchPageHotels.clickOnFourStarCheckBox();
                searchPageHotels.scrollDownAsBottom();
                searchPageHotels.starHotel45List();
                //System.out.println("4 Star List : " +searchPageHotels.starHotel45List());
                break;

            case "3 stars" :
                searchPageHotels.clickOnThreeStarCheckBox();
                searchPageHotels.scrollDownAsBottom();
                Thread.sleep(5000);
                searchPageHotels.starHotel3List();
                //System.out.println("3 Star List : " +searchPageHotels.starHotel3List());
                break;
        }
    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void iVerifySystemDisplaysOnlyStarsHotelsOnSearchResult(String starHotel) {
        switch (starHotel) {
            case "5 stars":
                Assert.assertTrue(searchPageHotels.isStarOfHotelRight("5"));
                break;

            case "4 stars":
                Assert.assertTrue(searchPageHotels.isStarOfHotelRight("4"));
                break;

            case "3 stars":
                Assert.assertTrue(searchPageHotels.isStarOfHotelRight("3"));
                break;
        }
    }

    @Then("^I verify system displays all hotels within (\\d+) miles radius of airport$")
    public void iVerifySystemDisplaysAllHotelsWithinMilesRadiusOfAirport(int arg0) throws InterruptedException, ParseException {

        searchPageHotels.selectRadiusOfMile();
        searchPageHotels.scrollDownAsBottom();
        searchPageHotels.hotelList();
        searchPageHotels.radiusMileList();
        Assert.assertTrue(searchPageHotels.isRadiusMileRight(),"Out of range expected radius mile");
    }

    @And("^I verify Hilton Hotel is within radius$")
    public void iVerifyHiltonHotelIsWithinRadius() {
        Assert.assertTrue(searchPageHotels.isHotelContainsInList("Hilton New York"),"Hotel is not displayed");
    }

    @Then("^I verify todays deal is less than \\$(\\d+)$")
    public void iVerifyTodaysDealIsLessThan$(int arg0) throws ParseException {
       Assert.assertTrue(searchPageHotels.isTodayDealLessThanExpected(arg0), "Todays deal price is not less than " + arg0);
    }
}