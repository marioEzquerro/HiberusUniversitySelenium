package com.hiberus.university.selenium.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class PagesFactory {

    private static PagesFactory instance;
    private final WebDriver driver;
    private final CheckOutStepOnePage checkOutStepOnePage;
    private final com.hiberus.university.selenium.pages.checkOutStepTwoPage checkOutStepTwoPage;
    private final InventoryPage inventoryPage;
    private final LoginPage loginPage;
    private final CartPage cartPage;

    public PagesFactory(WebDriver driver) {
        this.driver = driver;
        checkOutStepOnePage = new CheckOutStepOnePage(driver);
        checkOutStepTwoPage = new com.hiberus.university.selenium.pages.checkOutStepTwoPage(driver);
        inventoryPage = new InventoryPage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
    }

    public static void start(WebDriver driver) {
        instance = new PagesFactory(driver);
    }

    public static PagesFactory getInstance() {
        return instance;
    }

}
