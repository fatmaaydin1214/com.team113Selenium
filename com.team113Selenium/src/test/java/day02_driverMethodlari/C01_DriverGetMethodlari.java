package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_DriverGetMethodlari {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());

        System.out.println(driver.getCurrentUrl());

        System.out.println(driver.getPageSource());

        System.out.println(driver.getWindowHandle()); // acilan her bir pencereye verilen unique hash koddur.
        System.out.println(driver.getWindowHandles()); // eger driver calisirken birden fazla pencere veya tab olusturulursa
        //acilan tum windows tablarinin unique hash kodlarini getirir.

        Thread.sleep(2000);
        driver.close();
    }
}
