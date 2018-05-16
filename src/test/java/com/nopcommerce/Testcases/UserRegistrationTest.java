package com.nopcommerce.Testcases;

import com.nopcommerce.Pages.Register_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

public class UserRegistrationTest extends ExtentTestConfiguration {

    protected static WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe"); //ChromeDriver 2.37
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void cleanUp() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }


    @Test
    public void testCase1() {
        test = extent.createTest("Registration");

        driver.get("http://demo.nopcommerce.com");
        driver.findElement(By.xpath("//div[@class='header-links']/ul/li/a[@href='/register']")).click();

        Register_Page registrationPage = new Register_Page(driver);

        registrationPage.setGender("Male");
        registrationPage.setFirstName("Andy");
        registrationPage.setLastName("Anderson");
        registrationPage.setDateOfBirthDay("10");
        registrationPage.setDateOfBirthMonth("May");
        registrationPage.setDateOfBirthYear("1990");
        int randNumber = (int) (Math.random() * 10000);
        registrationPage.setEmail("andy.anderson" + randNumber + "@test.com");
        registrationPage.setCompany("Andy&Sons");
        registrationPage.setNewsletterCheckbox(false);
        registrationPage.setPassword("kksuuo23");
        registrationPage.setConfirmPassword("kksuuo23");
        registrationPage.clickRegisterButton();
        assertEquals(registrationPage.getConfirmationText(), "Your registration completed");
        driver.findElement(By.xpath("//div[@class='header-links']/ul/li/a[@href='/logout']")).click();
    }

    @Test
    public void testCase2() {
        test = extent.createTest("Registration with empty data fields");

        driver.get("http://demo.nopcommerce.com");
        driver.findElement(By.xpath("//div[@class='header-links']/ul/li/a[@href='/register']")).click();

        Register_Page registrationPage = new Register_Page(driver);

        registrationPage.clickRegisterButton();
        assertEquals(registrationPage.getFirstNameErrorMessage(), "First name is required.");
        assertEquals(registrationPage.getlLastNameErrorMessage(), "Last name is required.");
        assertEquals(registrationPage.getEmailErrorMessage(), "Email is required.");
        assertEquals(registrationPage.getPasswordErrorMessage(), "Password is required.");
        assertEquals(registrationPage.getConfirmPasswordErrorMessage(), "Password is required.");

    }

    @Test
    public void testCase3() {
        test = extent.createTest("Registration with invalid data");

        driver.get("http://demo.nopcommerce.com");
        driver.findElement(By.xpath("//div[@class='header-links']/ul/li/a[@href='/register']")).click();

        Register_Page registrationPage = new Register_Page(driver);

        registrationPage.setGender("Male");
        registrationPage.setFirstName("Olga");
        registrationPage.setLastName("Liepa");
        registrationPage.setDateOfBirthDay("20");
        registrationPage.setDateOfBirthMonth("October");
        registrationPage.setDateOfBirthYear("1990");
        registrationPage.setEmail("andy.anderson.test.com");
        registrationPage.setCompany("Andy79");
        registrationPage.setNewsletterCheckbox(true);
        registrationPage.setPassword("123");
        registrationPage.setConfirmPassword("1234");
        registrationPage.clickRegisterButton();
        assertEquals(registrationPage.getEmailErrorMessage(), "Wrong email");
        assertEquals(registrationPage.getPasswordErrorMessage(), "The password should have at least 6 characters.");
        assertEquals(registrationPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match.");
    }
}
