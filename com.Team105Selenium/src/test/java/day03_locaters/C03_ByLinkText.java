package day03_locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ByLinkText {
    public static void main(String[] args) throws InterruptedException {

        // amazona sayfasin gidin
        // Gift Cards linkini tiklayin
        // Gift Cards sayfasina gittigini test edin

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        Thread.sleep(4000);
        WebElement giftCardsLinki= driver.findElement(By.linkText("Gift Cards"));
        giftCardsLinki.click();

        //istenen sayfaya gittigini test etmek icin
        // title'in gift card icerdigini test edebiliriz

        String expectedKelime="Gift Cards";
        String actualTitle= driver.getTitle();

        if (actualTitle.contains(expectedKelime)){
            System.out.println("Gift Card testi PASSED");

        }else {
            System.out.println("Gift Card testi FAILED");
        }

        driver.close();
    }
}
