import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.automationpractice.Test.*;

public class testcases {

    public static WebDriver driver = null;

    @BeforeTest
    public void openBrowser(){
        String testUrl = "http://automationpractice.com/index.php";
        driver = launchChromeBrowser(testUrl);
    }

    @Test
    public void scenario1() {
        try {
            //--------- Test Scenario - 1 --------
            //Step 1- Add to the cart a Faded Short Sleeve T Shirt, size medium, colour blue
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

            //Step 2- Add to the cart an Evening Dress, size small, colour beige
            mouseOver("dresses", 1, driver);
            click("quickview", driver);
            switchFrame("frame", driver);
            selectDropdown("dropdown", "S", driver);
            click("beigecolor", driver);
            click("addtocart", driver);
            verifyCartQuantity("verifycartquantity", driver);
            click("continueshopping", driver);

            //Step 3- Add to the cart a Printed Summer Dress, size medium, colour orange
            mouseOver("dresses", 2, driver);
            colorselection("Filterorangecolor", driver);
            click("quickview", driver);
            switchFrame("frame", driver);
            selectDropdown("dropdown", "M", driver);
            click("orangecolor", driver);
            click("addtocart", driver);
            verifyCartQuantity("verifycartquantity", driver);
            click("checkout", driver);
            isDisplayed("shoppingcartheading", driver);

            //--------- Test Scenario - 2 --------
            //Step 1- Remove the Evening Dress from the cart
            click("deleteEveningDress", driver);

            //Step 2- Add a second Faded Short Sleeve T Shirt of the same size and colour
            click("quantityplus", driver);
            Thread.sleep(5000);

            //Step 3- Assert the total for each line in the cart
            verifyAmount("TshirttotalPrice", "$33.02", driver);
            verifyAmount("SummerdressTotalPrice", "$28.98", driver);

            //Step 4- Assert the cart total is $64.00"
            verifyAmount("totalCartAmount", "$64.00", driver);

        }catch(Exception ex){
            System.out.println("Exception occurred "+ex.getMessage());
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

}
