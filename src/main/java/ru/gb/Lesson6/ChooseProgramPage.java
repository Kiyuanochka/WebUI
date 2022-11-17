package ru.gb.Lesson6;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ChooseProgramPage extends BasePage{

    public ChooseProgramPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//form/label")
    private List<WebElement> directionList;

    public void selectDirection(String direction) throws InterruptedException {
        directionList.stream().filter(d -> d.getText().contains(direction)).findFirst().get().click();
        Thread.sleep(5000);

            }
}
