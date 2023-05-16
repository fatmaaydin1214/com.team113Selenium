package day2_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverGetMethodlari {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");

        WebDriver driver=new ChromeDriver();

        System.out.println(driver.getWindowHandle());

        System.out.println(driver.getWindowHandles());

        driver.get("https://www.amazon.com");
        System.out.println(driver.getPageSource());
        //web sayfasinin tum kaynak kodlarini döndürür

        driver.close();
    }
}
