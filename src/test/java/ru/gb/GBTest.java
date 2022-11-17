package ru.gb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class GBTest {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser(){
        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        actions = new Actions(webDriver);
        webDriver.get("https://gb.ru/");
    }

    @Test
    void searchOfJob() throws InterruptedException {
       /* ((JavascriptExecutor)webDriver).executeScript("let element = document.evaluate(\"//div [@class='PushCollector']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null)\n" +
                "element.singleNodeValue.remove()");
        Thread.sleep(5000);*/

        webDriver.manage().window().setSize(new Dimension(1366, 768));
        webDriver.findElement(By.xpath("//a[text()='Поиск работы']")).click();
        Assertions.assertTrue(webDriver.getCurrentUrl().contains("career"));

        Thread.sleep(5000);}
    @Test
        void searchingButton() throws InterruptedException {

        webDriver.findElement(By.xpath("//div [contains(@class,'mn-header__icons')] //img [contains(@alt,'magnifier-icon')]")).click();
        webDriver.findElement(By.xpath("//input [contains(@class,'mn-search-panel__input')]")).sendKeys("Карьера");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button [contains(@class,'mn-search-panel__submit')]")));

        webDriver.findElement(By.xpath("//button [contains(@class,'mn-search-panel__submit')]")).click();
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
        Assertions.assertTrue(webDriver.getCurrentUrl().contains("search"));

        Thread.sleep(5000);}
    @Test
        void postsButton() throws InterruptedException {

        webDriver.manage().window().setSize(new Dimension(1366, 768));
        webDriver.findElement(By.xpath("//a [text()='Журнал']")).click();
        Assertions.assertTrue(webDriver.getCurrentUrl().contains("posts"));
        Thread.sleep(5000);}
    @Test
        void menuButton() throws InterruptedException {

        webDriver.get("https://gb.ru/");
        webDriver.findElement(By.xpath("//div [contains(@class,'mn-trigger-menu mn-header_hidden-mobile')]")).click();
        //webDriver.findElement(By.xpath("//span[text()='Мероприятия']"));

        Assertions.assertTrue(webDriver.findElement(By.xpath("//span[text()='Мероприятия']")).isDisplayed());
        Thread.sleep(5000);


    }


    @AfterEach
    void tearDown(){
        webDriver.quit();
    }

}
