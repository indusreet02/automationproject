package org.automationpractice;

import org.openqa.selenium.WebDriver;

public class Main extends Test {
    public static void main(String[] args) {

        try {
            System.out.println("--------- Test Scenario - 1 --------");
            System.out.println("Step 1- Add to the cart a Faded Short Sleeve T Shirt, size medium, colour blue ");
            String testUrl = "http://automationpractice.com/index.php";
            WebDriver driver = launchChromeBrowser(testUrl);
            isDisplayed("homepage", driver);
            click("tshirt", driver);
            isDisplayed("catalog", driver);
            click("quickview", driver);
            switchFrame("frame", driver);
            selectDropdown("dropdown", "M", driver);
            click("color", driver);
            click("addtocart", driver);
            verifyCartQuantity("verifycartquantity1", driver);
            click("continueshopping", driver);

            System.out.println("Step 2- Add to the cart an Evening Dress, size small, colour beige ");
            mouseOver("dresses", 1, driver);
            click("quickview", driver);
            switchFrame("frame", driver);
            selectDropdown("dropdown", "S", driver);
            click("beigecolor", driver);
            click("addtocart", driver);
            verifyCartQuantity("verifycartquantity2", driver);
            click("continueshopping", driver);

            System.out.println("Step 3- Add to the cart a Printed Summer Dress, size medium, colour orange ");
            mouseOver("dresses", 2, driver);
            colorselection("Filterorangecolor", driver);
            click("quickview", driver);
            switchFrame("frame", driver);
            selectDropdown("dropdown", "M", driver);
            click("orangecolor", driver);
            click("addtocart", driver);
            verifyCartQuantity("verifycartquantity3", driver);
            System.out.println("Doing Checkout and verifying my cart page is displayed");
            click("checkout", driver);
            isDisplayed("shoppingcartheading", driver);


            System.out.println("--------- Test Scenario - 2 --------");
            System.out.println("Step 1- Remove the Evening Dress from the cart");
            click("deleteEveningDress", driver);
            System.out.println("Step 3- Add a second Faded Short Sleeve T Shirt of the same size and colour ");
            click("quantityplus", driver);
            Thread.sleep(10000);
            System.out.println("Step 3- Assert the total for each line in the cart ");
            verifyAmount("TshirttotalPrice", "$33.02", driver);
            verifyAmount("SummerdressTotalPrice", "$28.98", driver);
            System.out.println("Step 4- Assert the cart total is $64.00");
            verifyAmount("totalCartAmount", "$64.00", driver);

            driver.quit();
        }catch (Exception ex){
            System.out.println("Exception occurred "+ ex.getMessage());
        }

    }
}