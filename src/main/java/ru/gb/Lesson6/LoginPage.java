package ru.gb.Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user_email")
    private WebElement emailField;

    @FindBy(id = "user_password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value = \"Войти\"]")
    private WebElement submitButton;

    public MyAccountPage login(String login, String password){
        emailField.sendKeys(login);
        passwordField.sendKeys(password);
        submitButton.click();
        return new MyAccountPage(driver);
    }
}
