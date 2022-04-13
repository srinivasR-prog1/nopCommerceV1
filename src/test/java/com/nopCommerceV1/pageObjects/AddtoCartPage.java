package com.nopCommerceV1.pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddtoCartPage {
	WebDriver driver;

	public AddtoCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.LINK_TEXT, using = "Home")
	@CacheLookup
	WebElement lnkHome;

	@FindBy(how = How.ID, using = "product_enteredQuantity_43")
	@CacheLookup
	WebElement gcQuantity;
	
	@FindBy(how = How.ID, using = "product_enteredQuantity_4")
	@CacheLookup
	WebElement proQuantity;

	@FindBy(how = How.XPATH, using = "//button[text()='Add to cart']")
	@CacheLookup
	WebElement addToCart;

	@FindBy(how = How.ID, using = "giftcard_43_RecipientName")
	@CacheLookup
	WebElement giftRecipientName;
	
	@FindBy(how = How.ID, using = "giftcard_43_RecipientEmail")
	@CacheLookup
	WebElement giftRecipientEmail;
	
	@FindBy(how = How.ID, using = "giftcard_43_SenderName")
	@CacheLookup
	WebElement giftSenderName;
	
	@FindBy(how = How.ID, using = "giftcard_43_SenderEmail")
	@CacheLookup
	WebElement giftSenderEmail;

	public void rdHDDandOs(String productName, String textElement) throws InterruptedException {

		List<WebElement> liElement = driver.findElements(By.xpath("//label[contains(@for,'" + productName + "')]"));
		for (int i = 0; i < liElement.size(); i++) {
			String text1 = liElement.get(i).getText();
			if (text1.equals(textElement)) {
				liElement.get(i).click();
				Thread.sleep(3000);
				break;

			}

		}

	}

	public void checkbox(String... value) {

		List<WebElement> listUncheck = driver.findElements(By.name("product_attribute_5"));

		for (int i = 0; i < listUncheck.size(); i++) {

			if (listUncheck.get(i).isSelected() == true) {

				listUncheck.get(i).click();

			}

		}

		List<WebElement> listElements = driver.findElements(By.xpath("//dd[@id='product_attribute_input_5']//label"));

		for (int j = 0; j < listElements.size(); j++) {
			String textCheckbox = listElements.get(j).getText();
			for (String val : value) {

				if (textCheckbox.equals(val)) {

					listElements.get(j).click();
					break;

				}

			}

		}

	}

	public void clickLink() {

		lnkHome.click();

	}

	public void prodQuntitiyValue(int Quan) {

		proQuantity.clear();

		proQuantity.sendKeys(String.valueOf(Quan));

	}
	
	public void gcQuntitiyValue(int Quantity) {

		gcQuantity.clear();

		gcQuantity.sendKeys(String.valueOf(Quantity));

	}

	public void clickAddtoCart() {

		addToCart.click();

	}

	public void receipientName(String gcName) {

		giftRecipientName.clear();
		giftRecipientName.sendKeys(gcName);

	}
	
	public void receipientEmail(String rcMail) {

		giftRecipientEmail.clear();
		giftRecipientEmail.sendKeys(rcMail);

	}
	public void SenderName(String gcSenderName) {

		giftSenderName.clear();
		giftSenderName.sendKeys(gcSenderName);

	}
	
	public void senderEmail(String gcSenderMail) {

		giftSenderEmail.clear();
		giftSenderEmail.sendKeys(gcSenderMail);

	}

}
