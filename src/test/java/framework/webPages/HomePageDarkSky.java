package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    WebDriverWait wait = new WebDriverWait(SharedSD.driver, 10);

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
    private int minTempTodayInt = 0;
    private int maxTempTodayInt = 0;
    private int minTempTodayInt2 = 0;
    private int maxTempTodayInt2 = 0;
    private int currentTempInt = 0;

    //Lists
    List<Integer> currentOptionsInt = new ArrayList<>();
    List<String> currentHoursInTlStr = new ArrayList<>();
    List<String> times = new ArrayList<String>();

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

    public void verifyCurrentTempFromDailyTl() {
        int minListInt = Collections.min(currentOptionsInt);
        int maxListInt = Collections.max(currentOptionsInt);
        if (currentTempInt <= maxListInt && currentTempInt >= minListInt) {
            boolean isCurrentTempInRange = true;
            Assert.assertTrue(isCurrentTempInRange, "Test passed");
        }
    }

    public void clickTodayIcon() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(todayIcon));
            clickOn(todayIcon);

        } catch (Exception e) {}
    }

    public void scrollDown(int horizontal, int vertical) throws InterruptedException {
        JavascriptExecutor jsScrollBy = (JavascriptExecutor) SharedSD.driver;
        jsScrollBy.executeScript("scrollBy(" + horizontal + "," + vertical + ");");
        Thread.sleep(2000);
    }

    public void getTodaysMinAndMaxTempValue() throws ParseException, InterruptedException {
        String minTempToday = SharedSD.driver.findElement(todayMinTemp).getText();
        minTempTodayInt = ((Number) NumberFormat.getInstance().parse(minTempToday)).intValue();
        System.out.println("Todays min Temp is : " + minTempTodayInt);
        String maxTempToday = SharedSD.driver.findElement(todayMaxTemp).getText();
        maxTempTodayInt = ((Number) NumberFormat.getInstance().parse(maxTempToday)).intValue();
        System.out.println("Todays max Temp is : " + maxTempTodayInt);
    }

    public void getTodayMinAndMaxTempDisplayValue() throws ParseException {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(todayMinTemp2));
        String minTempToday2 = SharedSD.driver.findElement(todayMinTemp2).getText();
        minTempTodayInt2 = ((Number) NumberFormat.getInstance().parse(minTempToday2)).intValue();
        System.out.println("Todays min Temp 2 is : " + minTempTodayInt2);
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(todayMaxTemp2));
        String maxTempToday2 = SharedSD.driver.findElement(todayMaxTemp2).getText();
        maxTempTodayInt2 = ((Number) NumberFormat.getInstance().parse(maxTempToday2)).intValue();
        System.out.println("Todays max Temp 2 is : " + maxTempTodayInt2);

    }

    public void verifyTodaysLowAndHighTemp() {
        Assert.assertEquals(minTempTodayInt, minTempTodayInt2);
        Assert.assertEquals(maxTempTodayInt, maxTempTodayInt2);

    }

    public void getHoursListFromTimeLine() {
        List<WebElement> hoursInTimeLineList = SharedSD.driver.findElements(hoursTimeLine);
        for (WebElement hour : hoursInTimeLineList) {
            String hoursStr = hour.getText();
            currentHoursInTlStr.add(hoursStr);
        }
    }

    public void getHoursListFromSystem() {
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
        }
    }

    public void verifyHoursTlAndSystem() {
        Assert.assertEquals(currentHoursInTlStr,times);

    }
}

