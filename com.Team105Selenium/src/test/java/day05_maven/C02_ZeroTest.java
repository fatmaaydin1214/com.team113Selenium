package day05_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ZeroTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        //1- https://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2- signin butonuna tiklayin
        driver.findElement(By.id("signin_button")).click();

        //3- Login alanina "username" yazdirin
        driver.findElement(By.id("user_login")).sendKeys("username");

        //4- Password alanina "password" yazdirin
        driver.findElement(By.id("user_password")).sendKeys("password");

        //5- Sign in butonuna tiklayin
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        //6- Navigate.back yapip online banking'e tiklayip Pay bills sayfasina gidin
        driver.navigate().back();
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        //7-Amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.id("sp_amount")).sendKeys("200");

        //8- Tarih kismina "2020-09-10" yazdirin
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");

        //9- Pay butonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();

        //10- "The payment was successfully submitted." mesajinin ciktigini test edin
        WebElement successfullySubmitted= driver.findElement(By.id("alert_content"));

        if (successfullySubmitted.isDisplayed()) {
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }
        driver.close();


    }
}
