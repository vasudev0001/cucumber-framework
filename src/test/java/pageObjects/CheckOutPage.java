package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.GenericUtils;

public class CheckOutPage extends GenericUtils {
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private By tableHeader_loc = By.xpath("//table[@id='productCartTables']/thead/tr/td");
	private By tableBody_loc = By.xpath("//table[@id='productCartTables']/tbody");
	private By placeOrderBtn_loc = By.xpath("//table[@id='productCartTables']/following-sibling::div/button");

	private By dropdown_loc = By.xpath("//div[@class='wrapperTwo']/div/select");
	private By checkOut_checkBox_loc = By.xpath("//input[@class='chkAgree']");
	private By proceedButton_loc = By.xpath("//button[contains(text(),Proceed)]");
	private By orderSuccessMsg_loc = By.xpath("//div[@class='wrapperTwo']/span");
	private By vegTable_CheckoutPage_loc = By.xpath("//table[@id=\"productCartTables\"]");

	public int getTableHeaderIndexWithName(String headerName) {
		List<WebElement> headerList = driver.findElements(tableHeader_loc);
		int headerIndex = 1;
		boolean valueFound = false;
		for (WebElement header : headerList) {
			String expectedHeaderName = header.getText();
			if (expectedHeaderName.equalsIgnoreCase(headerName)) {
				valueFound = true;
				break;
			}
			headerIndex++;
		}
		if (valueFound == false) {
			System.out.println("header not found");
			headerIndex = 0;
		}
		return headerIndex;
	}

	public int getRowData(String rowData, int columnIndex) {
		int rowIndex = 1;
		if (columnIndex > 0) {
			List<WebElement> rowDataList = driver.findElement(tableBody_loc).findElements(By.tagName("tr"));
			boolean foundRowValue = false;
			for (WebElement data : rowDataList) {
				String rowValue = data.getText().split("-")[0].trim();
				if (rowValue.equalsIgnoreCase(rowData)) {
					System.out.println(rowData + " found at row index: " + rowIndex);
					foundRowValue = true;
					break;
				}
				rowIndex++;
			}
			if (foundRowValue == false) {
				rowIndex = -1;
				System.out.println(rowData + " not found.");
			}
		} else {
			rowIndex = -1;
			System.out.println(rowData + " not found because of wrong header.");
		}

		return rowIndex;
	}

	public String getTableValue(int rowIndex, int columnIndex) {
		WebElement tableBody = driver.findElement(tableBody_loc);
		WebElement CellValue = tableBody.findElement(By.xpath("./tr[" + rowIndex + "]/td[" + columnIndex + "]"));
		String cellText = CellValue.getText().split("-")[0].trim();
		return cellText;
	}

	public void clickOnPlaceOrderButton() {
		clickOnButton(placeOrderBtn_loc);
	}

	public void selectDropdownOption(String selectCountry) {
		selectDropdownValue(dropdown_loc, selectCountry);
	}

	public void clickOnCheckOutCheckBox() {
		driver.findElement(checkOut_checkBox_loc).click();
	}

	public void clickOnProceedBtn() {
		driver.findElement(proceedButton_loc).click();
	}

	public String getOrderSuccessMessage() {
		String successMessage = driver.findElement(orderSuccessMsg_loc).getText();
		return successMessage;
	}
	
	public void wait_Untill_ProductTable_Displayed_On_CheckoutPage(int timeInSeconds) {
		waitTillElementVisisble(vegTable_CheckoutPage_loc, timeInSeconds);
	}

}
