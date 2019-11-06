package framework.webPages;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import stepdefinition.SharedSD;

import java.time.Duration;
import java.util.concurrent.BlockingDeque;

/**
 * Created by mohammadmuntakim
 */
public class BasePage {
	WebDriverWait wait = new WebDriverWait(SharedSD.driver, 10);

	// This is the most common wait function used in selenium
	public static WebElement webAction(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementClickInterceptedException.class)
				.withMessage(
						"Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		return element;
	}

	public void clickOn(By locator) {
		webAction(locator).click();
	}

	public void setValue(By locator, String value) {
		webAction(locator).sendKeys(value);
	}

	public String getTextFromElement(By locator) {
		return webAction(locator).getText();
	}

	public boolean isElementDisplayed(By locator) {
		return webAction(locator).isDisplayed();
	}

	public boolean isElementSelected(By locator) {
		return webAction(locator).isSelected();
	}

	public boolean isElementEnabled(By locator) { return webAction(locator).isEnabled(); }

	public void selectFromDropdownByValue(By locator, String dropdownText) {
		WebElement element = webAction(locator);
		Select select = new Select(element);
		//select element by visible text
		select.selectByValue(dropdownText);
	}

	public void selectFromDropdownByVisText(By locator, String dropdownText) {
		WebElement element = webAction(locator);
		Select select = new Select(element);
		//select element by visible text
		select.selectByVisibleText(dropdownText);
	}

	public void scrollDown(int horizontal, int vertical) throws InterruptedException {
			JavascriptExecutor jsScrollBy = (JavascriptExecutor) SharedSD.driver;
			jsScrollBy.executeScript("scrollBy("+horizontal + ","+ vertical +");");
		}

		public void waitElement (By locator) {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		}

	}
