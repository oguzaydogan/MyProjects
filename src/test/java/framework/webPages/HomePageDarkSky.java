package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class HomePageDarkSky extends BasePage {

    //Element locators
    private By darkSkyAPI = By.linkText("Dark Sky API");
    private By signUp = By.xpath("//a[@class='button filled']");
    private By registerButton = By.xpath("/html/body/div[1]/form/div/div/fieldset/div[4]/div/button");
    private By emailAdressTextField = By.xpath("//input[@name='_csrf']");
    private By dailyTempList = By.xpath("//div[@id='timeline']//div[@class='temps']//span/descendant::span");
    private By currentTemp = By.xpath("//span[@class='summary swap']");
    private By todayIcon = By.xpath("//span[contains(text(),'Today')]");
    private By todayMinTemp = By.xpath("//*[@id=\"week\"]/a[1]/span[2]/span[1]");
    private By todayMaxTemp = By.xpath("//*[@id=\"week\"]/a[1]/span[2]/span[3]");
    private By todayMinTemp2 = By.xpath("//*[@id=\"week\"]/div[2]/div[1]/div[2]/div[1]/span[1]/span[1]");
    private By todayMaxTemp2 = By.xpath("//*[@id=\"week\"]/div[2]/div[1]/div[2]/div[1]/span[3]/span[1]");
    private By hoursTimeLine = By.xpath("//div[@id='timeline']//div[@class='hours']/descendant::span//span");

    //Field Variables
    private int currentTempInt = 0;

    //Lists
    List<Integer> currentOptionsInt = new ArrayList<>();


    //Methods
    public void clickDarkSkyApi() {
        clickOn(darkSkyAPI);
    }

    public void clickSignUp() {
        clickOn(signUp);
    }

    public void clickRegisterButton() {
        clickOn(registerButton);
    }

    public void isEmailAdressTextFieldVisible() {
        isElementDisplayed(emailAdressTextField);
    }

    public void getDailyTempList() throws ParseException {
        List<WebElement> dailyTemps = SharedSD.driver.findElements(dailyTempList);
        for (WebElement temp : dailyTemps) {
            String tempStr = temp.getText();
            int tempDailyInt = ((Number) NumberFormat.getInstance().parse(tempStr)).intValue();
            currentOptionsInt.add(tempDailyInt);
        }
    }

    public void getCurrentTemp() throws ParseException {
        String currentTempStr = SharedSD.driver.findElement(currentTemp).getText();
        currentTempInt = ((Number) NumberFormat.getInstance().parse(currentTempStr)).intValue();
    }

    public boolean isTempWithInRange() {
        int minListInt = Collections.min(currentOptionsInt);
        int maxListInt = Collections.max(currentOptionsInt);
        return  currentTempInt <= maxListInt && currentTempInt >= minListInt;
    }

    public void clickTodayIcon() {
        try {
           webAction(todayIcon).click();
        } catch (Exception e) {}
    }

    public int getTodaysMinTempValue() throws ParseException {
        String minTempToday = SharedSD.driver.findElement(todayMinTemp).getText();
        int minTempTodayInt = ((Number) NumberFormat.getInstance().parse(minTempToday)).intValue();
        return minTempTodayInt;
    }

    public int getTodaysMaxTempValue() throws ParseException {
        String maxTempToday = SharedSD.driver.findElement(todayMaxTemp).getText();
        int maxTempTodayInt = ((Number) NumberFormat.getInstance().parse(maxTempToday)).intValue();
        return maxTempTodayInt;
    }

    public int getTodayMinDisplayValue() throws ParseException, InterruptedException {
        waitElement(todayMinTemp2);
        String minTempToday2 = SharedSD.driver.findElement(todayMinTemp2).getText();
        int minTempTodayInt2 = ((Number) NumberFormat.getInstance().parse(minTempToday2)).intValue();
        return minTempTodayInt2;
    }

        public int getTodayMaxDisplayValue() throws ParseException {
        waitElement(todayMaxTemp2);
        String maxTempToday2 = SharedSD.driver.findElement(todayMaxTemp2).getText();
        int maxTempTodayInt2 = ((Number) NumberFormat.getInstance().parse(maxTempToday2)).intValue();
        return maxTempTodayInt2;
    }


    public List<String> currentHoursList() {
        List<String> currentHoursInTlStr = new ArrayList<>();
        List<WebElement> hoursInTimeLineList = SharedSD.driver.findElements(hoursTimeLine);
        for (WebElement hour : hoursInTimeLineList) {
            String hoursStr = hour.getText();
            currentHoursInTlStr.add(hoursStr);
        }
        return currentHoursInTlStr;
    }

    public List<String> timesList() {
        List<String> times = new ArrayList<String>();
        LocalDateTime dateStart = LocalDateTime.now();
        for (int i = 0; i < 24; i += 2) {
            LocalDateTime dateStop = dateStart.plusHours(i);

            String d2 = dateStop.format(DateTimeFormatter.ofPattern("ha"));
            times.add(d2);

            ListIterator<String> iterator = times.listIterator();
            while (iterator.hasNext()) {
                String s = iterator.next();
                iterator.set(s.toLowerCase());
                times.set(0, "Now");
            }
        }return times;
    }
}

