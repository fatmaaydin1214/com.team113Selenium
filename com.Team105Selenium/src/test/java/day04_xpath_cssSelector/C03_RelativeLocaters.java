package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C03_RelativeLocaters {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin

        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");


        //2- Berlin'i 3 farkli locater ile locate edin
        WebElement sailorElementi=driver.findElement(By.xpath("//p[text()='Sailor']"));
        WebElement berlin1=
                driver.findElement(RelativeLocator.with(By.tagName("img")).above(sailorElementi)); // sailor'in ustunde
        WebElement bostonElementi= driver.findElement(By.xpath("//p[text()='Boston']"));
        WebElement berlin2=
                driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(bostonElementi));
        WebElement nyc= driver.findElement(By.xpath("//p[text()='NYC']"));
        WebElement berlin3=
                driver.findElement(RelativeLocator.with(By.tagName("img")).below(nyc));


        //3- Relative locater'larin dogru calistigini test edin
        // id'si pid7_thumb odugunu test edelim
        String expectedIdDegeri="pid7_thumb";
        String actualIdDegeri=berlin3.getAttribute("id");

        if (expectedIdDegeri.equals(actualIdDegeri)){
            System.out.println("Relative Locator testi PASSED");
        }else {
            System.out.println("Relative Locator testi FailED");
        }

        Thread.sleep(2000);
        driver.close();


    }
}
