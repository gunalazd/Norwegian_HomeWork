package com.nopcommerce.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Register_Page {

    WebDriver driver;

    By genderMale = By.xpath("//div[@class='gender']/span/input[@value='M']");
    By genderFemale = By.xpath("//div[@class='gender']/span/input[@value='F']");
    By firstName = By.id("FirstName");
    By firstNameError = By.xpath("//span[@class='field-validation-error']/span[@for='FirstName']");
    By lastName = By.id("LastName");
    By lastNameError = By.xpath("//span[@class='field-validation-error']/span[@for='LastName']");
    By email = By.id("Email");
    By emailError = By.xpath("//span[@class='field-validation-error']/span[@for='Email']");
    By dateOfBirthDay = By.xpath("//div[@class='inputs date-of-birth']//select[@name='DateOfBirthDay']");
    By dateOfBirthMonth = By.xpath("//div[@class='inputs date-of-birth']//select[@name='DateOfBirthMonth']");
    By dateOfBirthYear = By.xpath("//div[@class='inputs date-of-birth']//select[@name='DateOfBirthYear']");
    By company = By.id("Company");
    By newsletterCheckbox = By.id("Newsletter");
    By password = By.id("Password");
    By passwordError = By.xpath("//span[@class='field-validation-error']/span[@for='Password']");
    By confirmPassword = By.id("ConfirmPassword");
    By confirmPasswordError = By.xpath("//span[@class='field-validation-error']/span[@for='ConfirmPassword']");
    By registerButton = By.id("register-button");
    By resultText = By.xpath("//div[@class='page registration-result-page']//div[@class='result']");


    public Register_Page(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String fName) {
        driver.findElement(firstName).sendKeys(fName);
    }

    public void setLastName(String lName) {
        driver.findElement(lastName).sendKeys(lName);
    }

    public void setEmail(String emailValue) {
        driver.findElement(email).sendKeys(emailValue);
    }

    public void setDateOfBirthDay(String dayValue) {
        Select dropdown = new Select(driver.findElement(dateOfBirthDay));
        dropdown.selectByValue(dayValue);
    }

    public void setDateOfBirthMonth(String monthValue) {
        Select dropdown = new Select(driver.findElement(dateOfBirthMonth));
        dropdown.selectByVisibleText(monthValue);
    }

    public void setDateOfBirthYear(String yearValue) {
        Select dropdown = new Select(driver.findElement(dateOfBirthYear));
        dropdown.selectByValue(yearValue);
    }

    public void setCompany(String companyValue) {
        driver.findElement(company).sendKeys(companyValue);
    }

    public void setNewsletterCheckbox(boolean checkboxValue) {
        if (!checkboxValue) {
            if (driver.findElement(newsletterCheckbox).isSelected()) {
                driver.findElement(newsletterCheckbox).click();
            }
        } else {
            if (!driver.findElement(newsletterCheckbox).isSelected()) {
                driver.findElement(newsletterCheckbox).click();
            }
        }
    }

    public void setPassword(String passwordValue) {
        driver.findElement(password).sendKeys(passwordValue);
    }

    public void setConfirmPassword(String confirmPasswordValue) {
        driver.findElement(confirmPassword).sendKeys(confirmPasswordValue);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void setGender(String genderValue) {
        if (genderValue == "Male") {
            driver.findElement(genderMale).click();
        } else if (genderValue == "Female") {
            driver.findElement(genderFemale).click();
        }
    }

    public String getConfirmationText() {
        String text = driver.findElement(resultText).getText();
        return text;
    }

    public String getFirstNameErrorMessage() {
        String text = driver.findElement(firstNameError).getText();
        return text;
    }

    public String getlLastNameErrorMessage() {
        String text = driver.findElement(lastNameError).getText();
        return text;
    }

    public String getEmailErrorMessage() {
        String text = driver.findElement(emailError).getText();
        return text;
    }

    public String getPasswordErrorMessage() {
        String text = driver.findElement(passwordError).getText();
        return text;
    }

    public String getConfirmPasswordErrorMessage() {
        String text = driver.findElement(confirmPasswordError).getText();
        return text;
    }
}
