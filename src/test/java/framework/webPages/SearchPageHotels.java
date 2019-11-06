package framework.webPages;

import gherkin.lexer.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import stepdefinition.SharedSD;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

public class SearchPageHotels extends BasePage {

    private By fiveStarCheckBox = By.xpath("//span[contains(text(),'5-star')]");
    private By fourStarCheckBox = By.xpath("//span[contains(text(),'4-star')]");
    private By threeStarCheckBox = By.xpath("//span[contains(text(),'3-star')]");
    //private By additionalInfo = By.xpath("//div[@class='additional-info']");
    private By hotel45StarXpath = By.xpath("//span[@class='star-rating-text star-rating-text-strong']");
    private By hotel3StarXpath = By.xpath("//span[@class='star-rating-text']");
    //private By hotelNameXpath = By.xpath("//div[@id='listings']//h3[@class='p-name']/descendant::a");
    private By hotelNameXpath = By.xpath("//h3[@class='p-name']");
    private By radiusMileXpath = By.xpath("//ul[@class='property-landmarks']/li[1]");
    private By radiusSizeButton = By.xpath("//select[@id='f-distance']");
    private By landmarks = By.xpath("//h3[contains(text(),'Landmarks')]");
    private By jFKCheckBox = By.xpath("//label[@id='f-label-lid-1662393']");
    private By todaysBestDeal = By.xpath("//h2[@class='header-text widget-tooltip widget-tooltip-br widget-tooltip-multiline']");
    private By bestDealPrice = By.xpath("//*[@id=\"listings\"]/ol/li[1]/article/section/aside/div[1]/a/ins");

    List<String> starHotelList = new ArrayList<>();
    List<String> hotelNameList = new ArrayList<>();
    List<Double> radiusMileList = new ArrayList<>();

    int todayBestDealPrice = 0;

    public void clickOnFiveStarCheckBox() {
        webAction(fiveStarCheckBox).click();
    }

    public void clickOnFourStarCheckBox() {
        webAction(fourStarCheckBox).click();
    }

    public void clickOnThreeStarCheckBox() {
        webAction(threeStarCheckBox).click();
    }

    public void scrollDownAsBottom() throws InterruptedException {
        for (int second = 0; ; second++) {
            if (second >= 40) {
                break;
            }
            ((JavascriptExecutor) SharedSD.driver).executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(2000);
        }
    }

    public List<String> starHotel45List() {
        List<WebElement> starHotel = SharedSD.driver.findElements(hotel45StarXpath);
        for (WebElement star : starHotel) {
            String starStr = star.getText().trim();
            starHotelList.add(starStr);
        }
        return starHotelList;
    }

    public List<String> starHotel3List() {
        List<WebElement> starHotel = SharedSD.driver.findElements(hotel3StarXpath);
        for (WebElement star : starHotel) {
            String starStr = star.getText().trim();
            starHotelList.add(starStr);
        }
        return starHotelList;
    }

    public boolean isStarOfHotelRight(String starText) {
        for (String item : starHotelList) {
            if (item.trim().startsWith(starText)) {
                return true;
            }
        }
        return false;
    }

    public void selectRadiusOfMile() throws InterruptedException {
        scrollDown(0, 600);
        if (!SharedSD.getDriver().findElement(jFKCheckBox).isDisplayed()) {
            clickOn(landmarks);
        }
        Thread.sleep(2000);
        clickOn(jFKCheckBox);
        Thread.sleep(2000);
        scrollDown(0, 600);
        //clickOn(radiusSizeButton);
        WebElement mileDropDown = SharedSD.getDriver().findElement(radiusSizeButton);
        Select miles = new Select(mileDropDown);
        miles.selectByValue("10.0");
        Thread.sleep(2000);
    }

    public List<String> hotelList() throws InterruptedException {
        List<WebElement> hotelName = SharedSD.driver.findElements(hotelNameXpath);
        for (WebElement hotel : hotelName) {
            String hotelStr = hotel.getText();
            hotelNameList.add(hotelStr);
        }
        return hotelNameList;
    }

    public List<Double> radiusMileList() throws ParseException, InterruptedException {
        List<WebElement> radiusMile = SharedSD.driver.findElements(radiusMileXpath);
        for (WebElement mile : radiusMile) {
            String radiusMileStr = mile.getText();
            double radiusMileDbl = ((Number) NumberFormat.getInstance().parse(radiusMileStr)).doubleValue();
            radiusMileList.add(radiusMileDbl);
        }
        return radiusMileList;
    }

    public boolean isRadiusMileRight() {
        for (double mile : radiusMileList) {
            if (mile <= 10) {
                return true;
            }
        }
        return false;
    }

    public boolean isHotelContainsInList(String hotelText) {
        boolean result = false;
        for (String hotel : hotelNameList) {
            if (hotel.contains(hotelText)) {
                result = true;
            }
        }
        return result;
    }

    public boolean isElementPresent() {
        return SharedSD.driver.findElements(todaysBestDeal).size() != 0;
    }

    public boolean isTodayDealLessThanExpected(int priceLimit) {
        try {
            WebElement todaysBestDealElm = SharedSD.getDriver().findElement(todaysBestDeal);

            if (todaysBestDealElm.isDisplayed()) {
                WebElement price = SharedSD.getDriver().findElement(bestDealPrice);
                String todaysBestDealPriceStr = price.getText();
                todayBestDealPrice = new Integer(NumberFormat.getCurrencyInstance().parse(todaysBestDealPriceStr).intValue());
            }
        } catch (NoSuchElementException | ParseException e) {
            e.printStackTrace();
        }
        boolean isTodayDealLessThanExpected = false;
        if (todayBestDealPrice <= priceLimit) {
            isTodayDealLessThanExpected = true;

        }
        return isTodayDealLessThanExpected;
    }
}



