package com.opencart.stepdefs;

import com.opencart.pages.HomePage;
import com.opencart.pages.PagesFactory;
import com.opencart.utils.Enums;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class HomePageSteps {

    private final HomePage homePage;

    public HomePageSteps() {
        homePage = PagesFactory.getInstance().getHomePage();
    }

    @And("the user clicks go home button")
    public void theUserClicksGoHomeButton() {
        homePage.goHome();
    }


    @And("the user adds one item to the cart")
    public void theUserAddsOneItemToTheCart() {
        homePage.addItemToCart(Enums.HomePageItems.product_40);
    }

    @And("the user clicks go checkout")
    public void theUserClicksGoCheckout() {
        homePage.goToCheckout();
    }

    @And("the user clicks the cart summary button")
    public void theUserClicksTheCartSummaryButton() {
        homePage.clickDropDownCartButton();
    }

    @When("the user clicks each of the remove items button")
    public void theUserClicksTheRemoveButton() {
        homePage.removeElementsFromCart();
    }

    @Then("the cart is emptied")
    public void theCartIsEmptied() {
        Assert.assertEquals("Error some items weren't removed", 0, homePage.getNumberOfItemsInCart());
    }

    @Then("the cart has {int} item in it")
    public void theCartHasItemInIt(int nItems) {
        Assert.assertEquals("Error some items weren't removed", nItems, homePage.getNumberOfItemsInCart());
    }
}
