/* Generic package name, Java classes like to use packages to organize their directory structures. */
package com.company.selenium.cart;

/* Import the Selenium server classes from the library file we included in our lib folder so we can invoke
the Selenium driver methods.
 */
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
        int cartCount = 0;
        /*
        Write some steps here to find the cart element on the page with Selenium.
         */
        if (cartCount == 0) {
            System.out.println("PASS");
        } else {
            System.err.println("FAIL");
            System.err.println("Initial cart count was nonzero: " + cartCount);
            System.exit(1);
        }

        System.out.print("Performing search...");
        /*
        Find the query box and enter our query into it.  When you simulate the enter key, it should bring us to the
        result page of the search.
         */
        if ( driver.getCurrentUrl().compareTo(AMAZON_URL) != 0) {
            /* Page successfully changed... don't know if it's the right page but going to assume it is. */
            System.out.println("PASS");
        } else {
            System.err.println("FAIL");
            System.err.println("Page did not change.");
            System.exit(2);
        }

        System.out.print("Adding item to cart...");
        /*
        Find a way to open the page of a result product and click the add to cart element.
         */
        System.out.println("PASS");

        System.out.print("Verifying final cart contents...");
        /*
        Like in the first step, find the cart element, breakout the cart count and verify the count is now 1.
         */
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
