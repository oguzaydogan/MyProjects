package framework.webPages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import stepdefinition.SharedSD;
import java.time.LocalDate;


public class HomePageHotels extends BasePage {
    LocalDate today = LocalDate.now();
    LocalDate cOutDate = today.plusDays(1);

    boolean isRoomDisplayed = false;

    //Field Variables
    private int curYear = today.getYear();
    private int curMonth = today.getMonthValue()-1;
    private int curDate = today.getDayOfMonth();
    private int coYear = cOutDate.getYear();
    private int coMonth = cOutDate.getMonthValue()-1;
    private int coDate = cOutDate.getDayOfMonth();

    //Element locators
    private By roomsAdult =  By.xpath("//select[@id='qf-0q-room-0-adults']");
    private By roomChildren= By.xpath("//select[@id='qf-0q-room-0-children']");
    private By destinationField = By.xpath("//input[@id='qf-0q-destination']");
    private By checkIn = By.xpath("///input[@id='qf-0q-localised-check-in']");
    private By checkOut = By.xpath("//input[@id='qf-0q-localised-check-out']");
    private By selectOccupancy = By.xpath("//select[@id='qf-0q-compact-occupancy']");
    private By selectRoom = By.xpath("//select[@id='qf-0q-rooms']");
    private By numberOfRooms = By.xpath("//span[contains(text(),'Room')]");
    private By cInDateXpath = By.xpath("//td[@data-date='"+curYear+"-"+curMonth+"-"+curDate+"']//a");
    private By cOutDateXpath = By.xpath("//td[@data-date='"+coYear+"-"+coMonth+"-"+coDate+"']//a");
    private By searchButton = By.xpath("//button[@class='cta cta-strong']");
    private By previousMonthButton = By.xpath("//div[@class='widget-daterange widget-daterange-start widget-daterange-visible widget-daterange-below']//div[1]//div[1]//button[1]");
    private By popUpCloseButton = By.xpath("//button[@class='cta widget-overlay-close']");


    public void clickOnPopupCloseButton() {clickOn(popUpCloseButton);
    }

    public void clickOnOccupancyDropDown() {
        clickOn(selectOccupancy);
    }

    public void selectFromDropDown(String dropdownText) {
        selectFromDropdownByVisText(selectOccupancy,dropdownText);

    }
    public void selectRoomFromDropDown(String dropdownText) {
        selectFromDropdownByValue(selectRoom, dropdownText);
    }

    public boolean isAdultAndChildrenDisplayed() {
        if(isElementDisplayed(roomsAdult) && isElementDisplayed(roomChildren)) {
            isRoomDisplayed = true;

        }return isRoomDisplayed;
    }

    public boolean isRoomNumberDisplayed(String i) {
        numberOfRooms = By.xpath("//span[contains(text(),'Room "+i+":')]");
            if(isElementDisplayed(numberOfRooms)) {
                isRoomDisplayed = true;
        }return isRoomDisplayed;
    }
    public boolean isElementPresent() {
        return SharedSD.driver.findElements(By.xpath("//span[contains(text(),'Room 9:')]")).size() != 0;
    }

    public void setDestinationValue(String destination) throws InterruptedException {
        clickOn(destinationField);
        setValue(destinationField,destination);
        WebElement destinationElement = SharedSD.getDriver().findElement(destinationField);
        destinationElement.sendKeys(Keys.TAB);
        Thread.sleep(2000);
    }

    public void selectCheckInAndCheckOutDate() throws InterruptedException {
        if(isElementDisplayed(previousMonthButton)) {
            clickOn(previousMonthButton);
        }
            clickOn(cInDateXpath);
            clickOn(checkOut);
            clickOn(cOutDateXpath);
            clickOn(searchButton);
        }
    }

