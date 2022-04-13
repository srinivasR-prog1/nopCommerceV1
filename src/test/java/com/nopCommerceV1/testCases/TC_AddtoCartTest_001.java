package com.nopCommerceV1.testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.nopCommerceV1.pageObjects.AddtoCartPage;

public class TC_AddtoCartTest_001 extends BaseClass {

	String productTitlecompName = "Build your own computer";
	String productTitleAppleMac = "Apple MacBook Pro 13-inch";
	String productTitleHTCOne = "HTC One M8 Android L 5.0 Lollipop";
	String productTitleVirtualGift = "$25 Virtual Gift Card";
	String text = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
	String text1 = "8GB [+$60.00]";

	@Test
	public void addtoCartTest() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		AddtoCartPage acp = new AddtoCartPage(driver);

		List<WebElement> listofTitleName = driver.findElements(By.xpath("//button[text()='Add to cart']"));
		By locatortitlecomp = By.xpath("//a[text()='Build your own computer']");

		String compTitle = genericTitle(locatortitlecomp).getText();

		By locatortitleApple = By.xpath("//a[text()='Apple MacBook Pro 13-inch']");

		String appleTitle = genericTitle(locatortitleApple).getText();

		By locatortitleHTC = By.xpath("//a[text()='HTC One M8 Android L 5.0 Lollipop']");

		String HtcTitle = genericTitle(locatortitleHTC).getText();

		By locatortitleGift = By.xpath("//a[text()='$25 Virtual Gift Card']");

		String VirtualTitle = genericTitle(locatortitleGift).getText();

		for (int j = 0; j < listofTitleName.size(); j++) {

			if (compTitle.equals(productTitlecompName) && (j == 0)) {

				{

					listofTitleName.get(j).click();
					selectDropDownContains("product_attribute_1", text);
					selectDropDownContains("product_attribute_2", text1);
					acp.rdHDDandOs("product_attribute_3_", "400 GB [+$100.00]");
					acp.rdHDDandOs("product_attribute_4_", "Vista Premium [+$60.00]");
					acp.checkbox("Acrobat Reader [+$10.00]", "Total Commander [+$5.00]");
					acp.clickAddtoCart();
					By locatorcart = By.xpath("//p[contains(text(),'The product has been added to your')]");
					explicitWaitVisibility(40, locatorcart);
					By locatorHome = By.linkText("Home");
					try {
						explicitWait(30, locatorHome).click();
					} catch (ElementClickInterceptedException e) {
						WebElement element = driver.findElement(By.linkText("Home"));
						js.executeScript("arguments[0].click();", element);

					}

				}

			}

			if (appleTitle.equals(productTitleAppleMac) && (j == 1))

			{

				try {
					listofTitleName.get(j).click();
				} catch (StaleElementReferenceException e) {
					listofTitleName = driver.findElements(By.xpath("//button[text()='Add to cart']"));
					listofTitleName.get(j).click();

				}
				acp.prodQuntitiyValue(3);
				try {
					acp.clickAddtoCart();
				} catch (StaleElementReferenceException e) {
					WebElement cartElement2 = driver.findElement(By.xpath("//button[text()='Add to cart']"));
					cartElement2.click();
				}

				By locatorcart = By.xpath("//p[contains(text(),'The product has been added to your')]");
				explicitWaitVisibility(40, locatorcart);
				By locatorHome = By.linkText("Home");
				try {
					explicitWait(30, locatorHome).click();
				} catch (ElementClickInterceptedException e1) {
					WebElement element = driver.findElement(By.linkText("Home"));
					js.executeScript("arguments[0].click();", element);

				}

			}

			if (HtcTitle.equals(productTitleHTCOne) && (j == 2))

			{
				try {
					listofTitleName.get(j).click();
				} catch (StaleElementReferenceException e) {
					listofTitleName = driver.findElements(By.xpath("//button[text()='Add to cart']"));
					listofTitleName.get(j).click();
				}

				By locatorcart = By.xpath("//p[contains(text(),'The product has been added to your')]");
				explicitWaitVisibility(40, locatorcart);

			}

			if (VirtualTitle.equals(productTitleVirtualGift) && (j == 3)) {

				try {

					listofTitleName.get(j).click();
				} catch (StaleElementReferenceException e) {
					listofTitleName = driver.findElements(By.xpath("//button[text()='Add to cart']"));
					listofTitleName.get(j).click();
				}

				acp.receipientName("Subbu");
				acp.receipientEmail(RandomUtils() + "@gmail.com");
				acp.SenderName("Madhan");
				acp.senderEmail(RandomUtils() + "@gmail.com");
				acp.gcQuntitiyValue(3);
				try {
					acp.clickAddtoCart();
				} catch (StaleElementReferenceException e) {
					WebElement cartElement3 = driver.findElement(By.xpath("//button[text()='Add to cart']"));
					cartElement3.click();
				}
				
				WebElement shopCart= driver.findElement(By.xpath("//span[text()='Shopping cart']"));
				WebElement goToCart= driver.findElement(By.xpath("//button[text()='Go to cart']"));
				Actions act=new Actions(driver);
				act.moveToElement(shopCart).moveToElement(goToCart).click().perform();
				driver.findElement(By.id("termsofservice")).click();
				driver.findElement(By.id("checkout")).click();
			}

		}

	}
}
