package ru.gb.Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HW {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));


        webDriver.get("https://gb.ru/");
        webDriver.findElement(By.xpath("//a[text()='Поиск работы']")).click();

        Thread.sleep(5000);

        webDriver.get("https://gb.ru/");
        webDriver.findElement(By.xpath("//div [contains(@class,'mn-header__icons')] //img [contains(@alt,'magnifier-icon')]")).click();
        webDriver.findElement(By.xpath("//input [contains(@class,'mn-search-panel__input')]")).sendKeys("Карьера");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button [contains(@class,'mn-search-panel__submit')]")));

        webDriver.findElement(By.xpath("//button [contains(@class,'mn-search-panel__submit')]")).click();
        Thread.sleep(5000);

        webDriver.get("https://gb.ru/");
        webDriver.findElement(By.xpath("//a [text()='Журнал']")).click();
        Thread.sleep(5000);

        webDriver.get("https://gb.ru/");
        webDriver.findElement(By.xpath("//div [contains(@class,'mn-trigger-menu mn-header_hidden-mobile')]")).click();

        Thread.sleep(5000);




        webDriver.quit();




    }
}
