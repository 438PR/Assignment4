package edu.csumb.cst438fa16.hangman;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * User story:
 *
 *   As a user I want to be able to enter a character and submit as a guess
 *	So that I can take steps to solve the puzzle
 */
public class WebdriverIT {
    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() {
        driver.get("http://localhost:8080/hangman.html");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /**
     * Acceptance test:
     *
     * Given user is on the hangman page:
     *		1. A char can be entered in the element "newGuesses"
     * 		2. when a char is entered:
     *			the char is displayed in the guesses element
     */
    @Test
    public void testSubmitCharGuess() {
        driver.findElement(By.id("newGuesses")).sendKeys("a");
        driver.findElement(By.id("submit")).click();

        (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.textToBe(By.id("oldGuesses"), "a"));
    }
}