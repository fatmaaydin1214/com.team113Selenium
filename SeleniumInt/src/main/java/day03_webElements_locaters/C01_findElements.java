package day03_webElements_locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_findElements {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        //Bir web sitesinde herhangi bir web elementini kullanabilmek icin
        //o web elementi kodlarimiza tanitmamiz gerekir.

        WebElement amazonAramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        amazonAramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        Thread.sleep(5000);
        driver.close();
    }
}
