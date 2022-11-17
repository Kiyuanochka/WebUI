package ru.gb.Lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.Assertion;

public class SelectEducationTest {
    WebDriver driver;
    MainPage mainPage;


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.get("https://gb.ru/");

    }

    @Test
    void SelectEducationTest() throws InterruptedException {
        mainPage.clickSingInButton()
                .login("xxx", "xxx")
                .goChooseProgram()
                .selectDirection("Дизайн");
        Assertions.assertTrue((driver.findElement(By.xpath("//div[contains(text(),'Дизайн')]")).isDisplayed()));
        Thread.sleep(5000);

    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }
}



