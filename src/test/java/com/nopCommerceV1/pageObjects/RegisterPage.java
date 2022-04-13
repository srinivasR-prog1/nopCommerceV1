package com.nopCommerceV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[text()='Register']")
	@CacheLookup
	WebElement lnkRegister;

	@FindBy(name = "Gender")
	@CacheLookup
	WebElement rdMale;

	@FindBy(name = "FirstName")
	@CacheLookup
	WebElement txtFirstName;

	@FindBy(name = "LastName")
	@CacheLookup
	WebElement txtLastName;

	@FindBy(name = "DateOfBirthDay")
	@CacheLookup
	WebElement selectDay;

	@FindBy(name = "DateOfBirthMonth")
	@CacheLookup
	WebElement selectMonth;

	@FindBy(name = "DateOfBirthYear")
	@CacheLookup
	WebElement selectYear;

	@FindBy(name = "Email")
	@CacheLookup
	WebElement selectEmail;

	@FindBy(name = "Password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(name = "ConfirmPassword")
	@CacheLookup
	WebElement txtCnfPassword;

	@FindBy(name = "register-button")
	@CacheLookup
	WebElement btnRegister;

	@FindBy(xpath = "//div[@class='result']")
	@CacheLookup
	WebElement registerText;

	@FindBy(xpath = "//a[text()='Continue']")
	@CacheLookup
	WebElement lnkContinue;

	public void clickRegisterLnk() {
		lnkRegister.click();

	}

	public void clickRdMaleButton() {

		rdMale.click();

	}

	public void UsrFirstName(String ufname) {
		txtFirstName.clear();
		txtFirstName.sendKeys(ufname);

	}

	public void usrLastName(String ulname) {
		txtLastName.clear();
		txtLastName.sendKeys(ulname);

	}

	public void usrSelectDay(String usday) {
		selectDay.clear();
		selectDay.sendKeys(usday);

	}

	public void usrSelectMonth(String usmonth) {
		txtLastName.clear();
		txtLastName.sendKeys(usmonth);

	}

	public void usrSelectyear(String usyear) {
		txtLastName.clear();
		txtLastName.sendKeys(usyear);

	}

	public void usrEmail(String email) {
		selectEmail.clear();
		selectEmail.sendKeys(email);

	}

	public void usrPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);

	}

	public void usrCnfPassword(String cnfPwd) {
		txtCnfPassword.clear();
		txtCnfPassword.sendKeys(cnfPwd);

	}

	public void clickBtnRegister() {

		btnRegister.click();

	}

	public String getRegisterText() {

		String textValue = registerText.getText();
		return textValue;

	}

	public void clickLnkContinue() {
		lnkContinue.click();

	}

}
