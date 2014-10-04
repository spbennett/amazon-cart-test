package com.company.selenium.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by steve.bennett on 9/29/2014.
 * Description: Selenium QA test script that will go to Amazon.com then test cart functionality.
 */
public class Cart {

    static final String AMAZON_URL = "http://www.amazon.com/";
    static final String AMAZON_QUERY = "justin bieber cd";

    public static void main(String[] args) {

        System.out.print("Opening firefox...");
        WebDriver driver = new FirefoxDriver();
        driver.get(AMAZON_URL);
        System.out.println("PASS");

        System.out.print("Verifying initial cart contents...");
        String cartElement = "";
        try {
            cartElement = driver.findElement(By.id("nav-cart-count")).getText();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            // Couldn't find cart count, try alternate lookup.
            //cartElement = driver.findElement(By.id("nav-cart")).findElement(By.tagName("span")).getAttribute("nav-cart-count");
            System.err.println("ERROR");
            System.err.println("Unable to find cart count.");
            System.exit(1);
        }
        int cartCount = Integer.parseInt(cartElement);
        if (cartCount == 0) {
            System.out.println("PASS");
        } else {
            System.err.println("FAIL");
            System.err.println("Initial cart count was nonzero: " + cartCount);
            System.exit(1);
        }

        System.out.print("Performing search...");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(AMAZON_QUERY + Keys.RETURN);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        if ( driver.getCurrentUrl().compareTo(AMAZON_URL) != 0) {
            /* Page successfully changed... don't know if it's the right page but going to assume it is. */
            System.out.println("PASS");
        } else {
            System.err.println("FAIL");
            System.err.println("Page did not change.");
            System.exit(2);
        }

        System.out.print("Adding item to cart...");
        String itemLink = driver.findElement(By.id("result_0")).findElement(By.className("newaps")).findElement(By.tagName("a")).getAttribute("href");
        driver.get(itemLink);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        WebElement addToCart = driver.findElement(By.id("submit.add-to-cart"));
        addToCart.click();
        System.out.println("PASS");

        System.out.print("Verifying final cart contents...");
        cartElement = driver.findElement(By.id("nav-cart-count")).getText();
        cartCount = Integer.parseInt(cartElement);
        if (cartCount == 1) {
            System.out.println("PASS");
        } else {
            System.err.println("FAIL");
            System.err.println("Final cart count was not one: " + cartCount);
            System.exit(3);
        }

        System.out.println("All tests passed.");
        driver.quit();
    }
}
