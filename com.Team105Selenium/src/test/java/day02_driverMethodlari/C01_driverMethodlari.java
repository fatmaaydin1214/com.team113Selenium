package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_driverMethodlari {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");

        WebDriver driver= new ChromeDriver();

        driver.get("https://www.amazon.com");

        // acilan sayfanin basliginin amazon icerdigini test edin.

        String expectedKelime = "amazon";
        String actualResult= driver.getTitle();

        if (actualResult.contains(expectedKelime)){
            System.out.println("title testi PASSED");
        }else {
            System.out.println("Title amazon icermiyor, test FAILED");
            System.out.println(driver.getTitle());

        }
        // sayfanin url'sinin https://www.amazon.com/ oldugunu test edin

        String expectedUrl = " https://www.amazon.com/";
        String actualUrl= driver.getCurrentUrl();

        if(expectedUrl.equals(actualUrl)){
            System.out.println("URL testi PASSED");
        }else {
            System.out.println("URL istediginiz degerde degil");
            System.out.println(driver.getCurrentUrl());
        }

        Thread.sleep(5000);

        driver.close();
    }
}
