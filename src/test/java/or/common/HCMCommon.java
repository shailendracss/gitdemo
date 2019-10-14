package or.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.configData_Util.STATUS;
import com.customReporting.CustomReporter;
import com.driverManager.DriverFactory;
import com.seleniumExceptionHandling.CustomExceptionHandler;
import com.seleniumExceptionHandling.ReactTable;
import com.seleniumExceptionHandling.SeleniumMethods;

public class HCMCommon {

	private SeleniumMethods com;

	public HCMCommon() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
		com = new SeleniumMethods();
	}

	/** Spinner By Object which should be used across HCM application */
	public By spinnerLocator = By.xpath("//div[contains(@class,'spinner')]");

	/** Loading By Object which should be used across HCM application */
	public By loadingTextOrCircleLocator = By.xpath("//*[contains(@class,'loading')]");

	/**
	 * Loading Three Green Bullet By Object which should be used across HCM
	 * application
	 */
	public By loadingBullet = By.xpath("*[contains(@class,'loading-bullet')]");

	/** Success popup By Object which should be used across HCM application */
	public By successPopup = By.cssSelector("div.Toastify div[class*='success']");

	/** Error popup By Object which should be used across HCM application */
	public By errorPopup = By.cssSelector("div.Toastify div[class*='error']");

	/** React Table locator, common across all pages of HCM application */
	public By reactTableLocator = By.xpath("//div[contains(@class,'rt-table')]");

	@FindBy(xpath = "//span[contains(@class,'arrow-left')]//parent::button[@class='Table__pageButton']")
	public WebElement icon_Pagination_LeftButton;

	@FindBy(xpath = "//span[contains(@class,'arrow-right')]//parent::button[@class='Table__pageButton']")
	public WebElement icon_Pagination_RightButton;

	@FindBy(xpath = "//div[@class='view_by_']//li[contains(.,'10')]")
	public WebElement link_ViewBy_10;

	@FindBy(xpath = "//div[@class='view_by_']//li[contains(.,'20')]")
	public WebElement link_ViewBy_20;

	@FindBy(xpath = "//div[@class='view_by_']//li[contains(.,'50')]")
	public WebElement link_ViewBy_50;

	@FindBy(css = "div[class*='next'] button[disabled]")
	public WebElement icon_Next_Disabled;

	@FindBy(css = "div[class*='next'] button")
	public WebElement icon_Next;

	@FindBy(xpath = "//li[contains(.,'50')]")
	public WebElement link_50;

	public void verifyUI_Pagination_ViewBy() {
		CustomReporter.createNode("verifying Pagination and View By links");
		com.isElementPresent(icon_Pagination_LeftButton, "icon_Pagination_LeftButton");
		com.isElementPresent(icon_Pagination_RightButton, "icon_Pagination_RightButton");
		com.isElementPresent(link_ViewBy_10, "link_ViewBy_10");
		com.isElementPresent(link_ViewBy_20, "link_ViewBy_20");
		com.isElementPresent(link_ViewBy_50, "link_ViewBy_50");
	}

	/**
	 * Use this method to select any visible text value from HCM dropdowns
	 * 
	 * @param dropdown
	 *            The Webelement object
	 * @param visibleText
	 *            The visible text which you want to select
	 * @author shailendra
	 */
	public void selectByVisibleText(WebElement dropdown, String visibleText) {
		try {
			CustomReporter.report(STATUS.INFO, "Selecting option: [" + visibleText + "]");
			dropdown.click();
			com.wait(.5);
			By xp = By.xpath("//div[contains(@aria-label,'" + visibleText + "')]");
			com.javaScript_ScrollIntoMIDDLEView_AndHighlight(xp);
			//SnapshotManager.takeSnapShot("selectByVisibleText");
			DriverFactory.getDriver().findElement(xp)
					.click();
			com.waitForElementTobe_NotVisible(loadingTextOrCircleLocator);
		} catch (Exception e) {
			new CustomExceptionHandler(e, "Visible Text " + visibleText);
		}
	}

	/**
	 * This method will check the valid text search functionality, on every
	 * Listing Page
	 * 
	 * @return row number of searched data
	 * 
	 * @author shailendra Aug 29, 2019
	 */
	public int verifyValid_TextSearch(WebElement text_Search, String searchData) {
		com.sendKeys(text_Search, searchData + Keys.ENTER);
		com.wait(1);
		com.waitForElementTobe_NotVisible(loadingTextOrCircleLocator);
		
		ReactTable rct = new ReactTable(reactTableLocator);
		int row = rct.getRowWithCellText(searchData);
		if (row >= 2) {
			CustomReporter.report(STATUS.PASS,
					"Searched Data '" + searchData + "' successfully displayed in Result Table");
		} else {
			CustomReporter.report(STATUS.FAIL,
					"Searched Data '" + searchData + "' failed to displayed in Result Table");
		}

		return row;
	}

	/**
	 * This method will check the invalid text search functionality, on every
	 * Listing Page
	 * 
	 * @author shailendra Sep 3, 2019
	 */
	public void verifyInvalid_TextSearch(WebElement text_Search, String searchData, String expected) {
		com.sendKeys(text_Search, searchData + Keys.ENTER);
		com.waitForElementsTobe_NotVisible(loadingTextOrCircleLocator);

		ReactTable rct = new ReactTable(reactTableLocator);
		int row = rct.getRowWithCellText(expected);
		if (row >= 2) {
			CustomReporter.report(STATUS.PASS, "Data '" + expected + "' successfully displayed in Result Table");
		} else {
			CustomReporter.report(STATUS.FAIL, "Data '" + expected + "' failed to displayed in Result Table");
		}
	}

	/**
	 * Use this method to verify visible text of some/all options of every HCM
	 * dropdown
	 * 
	 * @param dropdown
	 *            The Webelement object
	 * @param visibleTexts
	 *            The comma separated visible texts which you want to verify in
	 *            the dropdown
	 * @author shailendra 30/08/2019
	 */
	public void verifyOptionsVisibleText(WebElement dropdown, String... visibleTexts) {
		try {
			dropdown.click();
			com.wait(.5);

			for (String visTxt : visibleTexts) {

				try {
					By xp = By.xpath("//div[contains(@aria-label,'" + visTxt + "')]");
					DriverFactory.getDriver().findElement(xp);
					com.javaScript_ScrollIntoMIDDLEView_AndHighlight(xp);
					CustomReporter.report(STATUS.PASS, "\"" + visTxt + "\" is displayed in the dropdown");
				} catch (Exception e) {
					CustomReporter.report(STATUS.FAIL, "\"" + visTxt + "\" is NOT displayed in the dropdown");
				}

			}
			dropdown.click();
		} catch (Exception e) {
			new CustomExceptionHandler(e, "Visible Text " + visibleTexts);
		}
	}

	// Table
	// $x("//div[@class='rt-table']")

	// Table >> Tbody || Thead >> Tr
	// $x("//div[@class='rt-table']//div[contains(@class,'thead') or
	// contains(@class,'tbody')]/div[contains(@class,'tr')]")

	// Thead
	// $x("//div[@class='rt-table']/div[contains(@class,'thead')]")

	// Thead >> Tr
	// $x("//div[@class='rt-table']/div[contains(@class,'thead')]/div[contains(@class,'tr')]")

	// Thead >> Tr[1] >> Td
	// $x("(//div[@class='rt-table']/div[contains(@class,'thead')]/div[contains(@class,'tr')])[1]//div[contains(@class,'td')
	// or contains(@class,'th')]")

	// Tbody
	// $x("//div[@class='rt-table']/div[contains(@class,'tbody')]")

	// Tbody >> Tr
	// $x("//div[@class='rt-table']/div[contains(@class,'tbody')]/div[contains(@class,'tr')]")

	// Tbody >> Tr[1] >> Td
	// $x("(//div[@class='rt-table']/div[contains(@class,'tbody')]/div[contains(@class,'tr')])[1]//div[contains(@class,'td')
	// or contains(@class,'th')]")

	/*
	 * 
	 * This method is used to select the month year and date from date picker
	 */

	public void monthYearAndDate(String dateObj, String dd) {
		try {

			WebDriver driver = DriverFactory.getDriver();

			String currMonth = driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']"))
					.getText();

			if (dateObj.equals(currMonth)) {
				CustomReporter.report(STATUS.PASS, "Month already selected");
			} else {
				for (int i = 1; i <= 12; i++) {
					driver.findElement(By.xpath("//button[contains(.,'Next month')]")).click();
					currMonth = driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']"))
							.getText();
					if (dateObj.equals(currMonth)) {
						CustomReporter.report(STATUS.PASS, "Month selected");
						break;
					}
				}
			}

			WebElement OnDate = driver.findElement(By.xpath("//div[@class='react-datepicker']"));

			List<WebElement> listOfWebEle = OnDate.findElements(By.xpath("//div[@class='react-datepicker__month']//following-sibling::div"));

			for (WebElement cell : listOfWebEle) {

				if (cell.getText().equals(dd)) {
					com.wait(2);
					cell.click();
					com.wait(2);
					CustomReporter.report(STATUS.PASS, "Date selected");
					break;
				}

			}

		} catch (Exception e) {
			new CustomExceptionHandler(e);
		}
	}

	/**
	 * 
	 * @author Shailendra 3 oct 19
	 */
	public void uploadFile(Object inputFileUploadObject, String absFilePath) {
		try {
			if (inputFileUploadObject instanceof By) {
				((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].className=''", com.getDynamicElement((By)inputFileUploadObject));
			}else {
				((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].className=''", (WebElement)inputFileUploadObject);
			}
			com.sendKeys(inputFileUploadObject, absFilePath);
		} catch (Exception e) {
			new CustomExceptionHandler(e, inputFileUploadObject.toString() + "|" + absFilePath);
		}
	}
}
