package GB_Attestation;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class GBLoginTest {

        WebDriver webDriver;
        WebDriverWait webDriverWait;
        Actions actions;

        @BeforeAll
        static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

        @BeforeEach
        void setupBrowser () {
        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        actions = new Actions(webDriver);
        webDriver.get("https://test-stand.gb.ru/login");
    }

        @Test
        void loginPositive () throws InterruptedException {

            webDriver.findElement(By.xpath("//input[@type='text']")).click();
            webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("kiyuan");
            webDriver.findElement(By.xpath("//input[@type='password']")).click();
            webDriver.findElement(By.xpath("//input[@type='password']")).sendKeys("bce6553f4e");
            webDriver.findElement(By.xpath("//div[@class='mdc-button__ripple']")).click();

            Thread.sleep(5000);
            Assertions.assertEquals("https://test-stand.gb.ru/", webDriver.getTitle());
        }
        @Test
        void loginPasswordNull () throws InterruptedException {

            webDriver.findElement(By.xpath("//input[@type='text']")).click();
            webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("kiyuan");
            webDriver.findElement(By.xpath("//input[@type='password']")).click();
            webDriver.findElement(By.xpath("//input[@type='password']")).sendKeys("");
            webDriver.findElement(By.xpath("//div[@class='mdc-button__ripple']")).click();


            Thread.sleep(5000);
            Assertions.assertTrue(webDriver.getCurrentUrl().contains(("https://test-stand.gb.ru/login")));
    }
        @Test
        void loginShort () throws InterruptedException {

            webDriver.findElement(By.xpath("//input[@type='text']")).click();
            webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("df");
            webDriver.findElement(By.xpath("//input[@type='password']")).click();
            webDriver.findElement(By.xpath("//input[@type='password']")).sendKeys("eff7d5dba3");
            webDriver.findElement(By.xpath("//div[@class='mdc-button__ripple']")).click();


            Thread.sleep(5000);
            Assertions.assertTrue(webDriver.getCurrentUrl().contains(("https://test-stand.gb.ru/login")));
        }@Test
        void loginLong () throws InterruptedException {

            webDriver.findElement(By.xpath("//input[@type='text']")).click();
            webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("sddsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfs");
            webDriver.findElement(By.xpath("//input[@type='password']")).click();
            webDriver.findElement(By.xpath("//input[@type='password']")).sendKeys("c2943a85f2");
            webDriver.findElement(By.xpath("//div[@class='mdc-button__ripple']")).click();


            Thread.sleep(5000);
        Assertions.assertTrue(webDriver.getCurrentUrl().contains(("https://test-stand.gb.ru/login")));
        }


        @AfterEach
        void tearDown () {
        webDriver.quit();
    }

    }

