package com.nopCommerceV1.testCases;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (br.equals("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {

		driver.quit();

	}

	public static void selectDropDown(String name, String text) {

		WebElement element = driver.findElement(By.name(name));

		Select dropDownElement = new Select(element);
		List<WebElement> listElements = dropDownElement.getOptions();

		for (int i = 0; i < listElements.size(); i++) {

			String dropDownText = listElements.get(i).getText();
			if (dropDownText.equals(text)) {
				listElements.get(i).click();
				break;

			}

		}

	}

	public static void selectDropDownContains(String name, String text) {

		WebElement element = driver.findElement(By.name(name));

		Select dropDownElement = new Select(element);
		List<WebElement> listElements = dropDownElement.getOptions();

		for (int k = 0; k < listElements.size(); k++) {

			String dropDownText = listElements.get(k).getText();
			if (dropDownText.contains(text)) {
				listElements.get(k).click();
				break;

			}

		}

	}

	public String RandomUtils() {

		String randomGenerating = RandomStringUtils.randomAlphanumeric(8);

		return randomGenerating;
	}

	public static String screenShot(String screenshotName) throws AWTException, IOException {
		String df = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
		String path1 = System.getProperty("user.dir") + "/Screenshot/" + screenshotName + df + ".jpg";
		BufferedImage image = new Robot()
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "jpg", new File(path1));
		return path1;

	}

	public WebElement explicitWait(int sec, By locator) {

		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wt.until(ExpectedConditions.elementToBeClickable(locator));
		return driver.findElement(locator);

	}

	public WebElement explicitWaitVisibility(int sec, By locator) {

		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wt.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);

	}

	public WebElement genericTitle(By locator) {

		return driver.findElement(locator);

	}

}
