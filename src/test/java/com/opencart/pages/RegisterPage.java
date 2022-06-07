package com.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPage extends BasePage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/register";

    @FindBy(id = "input-firstname")
    private WebElement nameInput;

    @FindBy(id = "input-email")
    private WebElement lastNameInput;

    @FindBy(id = "input-lastname")
    private WebElement emailInput;

    @FindBy(id = "input-telephone")
    private WebElement telephoneInput;

    @FindBy(id = "input-password")
    private WebElement passwordInput;

    @FindBy(id = "input-confirm")
    private WebElement passwordInput2;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement continueButton;

    // alerta de mail repetido
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement usedMailAlert;

    // alertas de los campos
    @FindBy(xpath = "//div[@class='col-sm-10']")
    private List<WebElement> inputFields;

    @FindBy(xpath = "//input[@type='checkbox' and @name='agree']")
    private WebElement privacyPolicyCheckbox;

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // GETTERS & SETTERS
    @Override
    public WebElement getPageLoadedTestElement() {
        return continueButton;
    }

    public void setName(String value) {
        if (value.isEmpty()) value = "";
        nameInput.sendKeys(value);
    }

    public void setLastName(String value) {
        if (value.isEmpty()) value = "";
        lastNameInput.sendKeys(value);
    }

    public void setEmail(String value) {
        if (value.isEmpty()) value = "";
        emailInput.sendKeys(value);
    }

    public void setPassword(String value) {
        if (value.isEmpty()) value = "";
        passwordInput.sendKeys(value);
        passwordInput2.sendKeys(value);
    }

    public void setTelephone(String value) {
        if (value.isEmpty()) value = "";
        telephoneInput.sendKeys(value);
    }

    // METODOS
    public void clickContinue() {
        continueButton.click();
    }

    public void acceptPrivacyPolicy() {
        privacyPolicyCheckbox.click();
    }

    public boolean isProperErrorMessageDisplayed(String field, String error) {
        for (WebElement elem: inputFields) {
            WebElement errorMsg = elem.findElement(By.xpath(".//div[@class='text-danger' and contains(text(), '"+field+"')]"));
            if (errorMsg.getText().equalsIgnoreCase(error))
                return true;
        }
        return false;
    }

    public boolean isAlertMessageDisplayed() {
        return usedMailAlert.isDisplayed();
    }
}
