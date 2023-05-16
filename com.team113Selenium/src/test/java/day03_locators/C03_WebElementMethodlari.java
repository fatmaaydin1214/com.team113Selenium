package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WebElementMethodlari {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazon sayfasina gidip arama kutusunu locate edelim
        driver.get("https://www.amazon.com/");
        WebElement aramaKutusuElementi= driver.findElement(By.id("twotabsearchtextbox"));
        System.out.println(aramaKutusuElementi.isDisplayed());
        System.out.println(aramaKutusuElementi.isEnabled());

        System.out.println(aramaKutusuElementi.getText());

        aramaKutusuElementi.sendKeys("Nutella");
        Thread.sleep(2000);
        aramaKutusuElementi.clear();

        System.out.println(aramaKutusuElementi.getSize());
        System.out.println(aramaKutusuElementi.getSize().height);

        System.out.println(aramaKutusuElementi.getTagName());

        aramaKutusuElementi.getAttribute("class");
        // nav-input navprogressive-attribute

        System.out.println(aramaKutusuElementi.getLocation());
        aramaKutusuElementi.getRect().getDimension();

        Thread.sleep(2000);
        driver.close();
    }
}
