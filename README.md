amazon-cart-test
================
Sample Selenium Test Script

Authors: 
Steven Bennett
Wayne Jackson

Description:
This Selenium project launches a Firefox window to Amazon.com.  From here it attempts to test the basic functionality of
the shopping cart.  We confirm that the cart is initially empty, from there we find the query box and enter a string
to search.  When the results of the search are displayed, we find the first result and go to it's page.  From there we
add this item to the cart and verify that the cart has increased its count to one item.
 
 Usage:
 $ java -jar Cart/dist/Cart.jar