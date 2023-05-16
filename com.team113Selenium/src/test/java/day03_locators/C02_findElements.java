package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_findElements {
    public static void main(String[] args) throws InterruptedException {
       /* Automation Exercise Category Testi
        1- Bir test class’i olusturun ilgili ayarlari yapin
        2- https://www.automationexercise.com/ adresine gidin
        3- Category bolumundeki elementleri locate edin
        4- Category bolumunde 3 element oldugunu test edin
        5- Category isimlerini yazdirin
        6- Sayfayi kapatin

        */

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.automationexercise.com/");

        List<WebElement> categoryElementsList= driver.findElements(By.className("panel-title"));



        int expectedSize=3;
        int actualSize= categoryElementsList.size();

        if (expectedSize==actualSize){
            System.out.println("Category Element test PASSED");
        }else {
            System.out.println("Category Element test FAILED");
        }

        for (WebElement eachelement:categoryElementsList
        ) {
            System.out.println(eachelement.getText());

        }

        Thread.sleep(3000);
        driver.close();

    }
}
