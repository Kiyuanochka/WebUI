package ru.gb.Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@class=\"mn-bottom-nav__list mn-header_hidden-mobile\"]//a[@href=\"/courses/all\"][contains(text(),'Выбор программы')]")
    private WebElement chooseProgramButton;

    public ChooseProgramPage goChooseProgram() throws InterruptedException {
        Thread.sleep(5000);

        chooseProgramButton.click();
        return new ChooseProgramPage(driver);

    }

}
