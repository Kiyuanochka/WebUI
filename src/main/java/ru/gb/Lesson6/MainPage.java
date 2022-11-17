package ru.gb.Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{


    @FindBy(xpath = "//div[@class=\"mn-header_hidden-mobile\"]/a[.='Войти']")
    private WebElement singInButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickSingInButton(){
        singInButton.click();
        return new LoginPage(driver);
    }




}
