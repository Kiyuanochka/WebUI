package ru.gb.Lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage{

    @FindBy(xpath = "//div[contains(@class,'mn-header_hidden-mobile')]/a[.='Войти']")
    private WebElement singInButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickSingInButton(){
        singInButton.click();
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//div [contains(@class,'mn-header__icons')] //img [contains(@alt,'magnifier-icon')]")
    private WebElement searchingButton;
    @FindBy(xpath = "//input [contains(@class,'mn-search-panel__input')]")
    private WebElement enterField;
    @FindBy(xpath = "//button [contains(@class,'mn-search-panel__submit')]")
    private WebElement enterButton;

    public void clickSearchingButton(){
        searchingButton.click();
        enterField.sendKeys("Карьера");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button [contains(@class,'mn-search-panel__submit')]")));
        enterButton.click();
    }

    @FindBy(xpath = "//a [text()='Журнал']")
    private WebElement postsButton;

    public void clickPostsButton(){
        driver.manage().window().setSize(new Dimension(1366, 768));
        postsButton.click();
    }

    @FindBy(xpath = "//div [contains(@class,'mn-trigger-menu mn-header_hidden-mobile')]")
    private WebElement menuButton;

    public  void clickMenuButton() throws InterruptedException {
        menuButton.click();
    }}