package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_IlkTest {
    public static void main(String[] args) throws InterruptedException {
       /*
        Yeni bir class olusturalim : C03_GetMethods

        9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin
        10. Sayfayi kapatin.

        */

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 3. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

       // 4. Sayfa basligini(title) yazdirin
        System.out.println("Sayfa basligi"+ driver.getTitle());

        //  5. Sayfa basliginin “Amazon” icerdigini test edin
        //  yazilim testinin beklenen degerlerin gerceklesip gerceklesmedigii kontrol eder
        String expectedIcerik= "Amazon";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedIcerik)){
            System.out.println("Title amazon iceriyor, test PASSED");
        }else {
            System.out.println("Title amazon icermiyor, test FAILED");
        }
        // 6. Sayfa adresini(url) yazdirin
        System.out.println("sayfa URL"+ driver.getCurrentUrl());

        // 7. Sayfa url’inin “amazon” icerdigini test edin.

        expectedIcerik= "amazon";
        String actualUrl= driver.getCurrentUrl();

        if (actualUrl.contains(expectedIcerik)){
            System.out.println(" amazon iceriyor, test PASSED" );
        }else {System.out.println(" amazon icermiyor, test FAILED" );

        }
        //8. Sayfa handle degerini yazdirin
        System.out.println("Sayfanin handle degeri : " + driver.getWindowHandle());
        //9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin
        expectedIcerik="alisveris";
        String actualPageSource= driver.getPageSource();
        if (actualPageSource.contains(expectedIcerik)){
            System.out.println("Sayfa kaynak kodlari alisveris iceriyor, test PASSED");
        }else {
            System.out.println("Sayfa kaynak kodlari alisveris icermiyor, test FAILED");
        }
        //10. Sayfayi kapatin.
        Thread.sleep(3000);
        driver.close();


    }
}
