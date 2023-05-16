package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CssSelector {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdrive.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");

        driver.manage().window().maximize();

        driver.navigate().refresh();

        String expectedMetin="Spend less";
        String actualTitle= driver.getTitle();

        if (actualTitle.contains(expectedMetin)){
            System.out.println("Title testi PASSED");
        }else {
            System.out.println("Title testi FAILED");
        }
        driver.findElement(By.linkText("Gift Cards")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("a[aria-label='Birthday']")).click();

        driver.findElement(By.xpath("//li[@class='a-carousel-card acswidget-carousel__card'][1] ")).click();
        driver.findElement(By.xpath("//button[@id='gc-mini-picker-amount-1'][1]")).click();

        WebElement urunUcretElementi= driver.findElement(By.xpath("(//span[text()='$25.00'])[1]"));

        System.out.println(urunUcretElementi.getText());

        String expectedUcret="$25.00";
        String actualUcretYazisi=urunUcretElementi.getText();

        if (expectedUcret.equals(actualUcretYazisi)){
            System.out.println("Gift Card ucret testi PASSED");
        }else {
            System.out.println("Gift Card ucret testi FAILED");
        }


        Thread.sleep(2000);
        driver.close();

    }
}
