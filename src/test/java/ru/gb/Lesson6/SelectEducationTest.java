package ru.gb.Lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;

public class SelectEducationTest {
    WebDriver driver;
    MainPage mainPage;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://gb.ru/");

    }

    @Test
    void SelectEducationTest() throws InterruptedException {
        mainPage.clickSingInButton()
                .login("test-744@mail.ru", "Test!1")
                .goChooseProgram()
                .selectDirection("Дизайн");
        Assertions.assertTrue((driver.findElement(By.xpath("//div[contains(text(),'Дизайн')]")).isDisplayed()));
        Thread.sleep(5000);}

        @Test
        void searchingButtonTest() throws InterruptedException {
            mainPage.clickSearchingButton();
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            Assertions.assertTrue(driver.getCurrentUrl().contains("search"));

            Thread.sleep(5000);}
        @Test
        void postsButtonTest() throws InterruptedException {

            mainPage.clickPostsButton();
            Assertions.assertTrue(driver.getCurrentUrl().contains("posts"));
            Thread.sleep(5000);}

        @Test
        void menuButtonTest() throws InterruptedException {
            mainPage.clickMenuButton();
            Assertions.assertTrue(driver.findElement(By.xpath("//span[text()='Мероприятия']")).isDisplayed());
            Thread.sleep(5000);

    }



    @AfterEach
    void tearDown() {
        driver.quit();
    }
}



