package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");

        String pageSource= driver.getPageSource();

        // pageSource'un meow icerdigini test edin

        String expectedKelime="meow";

        if (pageSource.contains(expectedKelime)){
            System.out.println("pageSource testi PASSED");
        }else {
            System.out.println("pageSource testi FAILED, MEOW kelimesi bulunamadi");
        }


        Thread.sleep(3000);
        driver.close();
    }
}
