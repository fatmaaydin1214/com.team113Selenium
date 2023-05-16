package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {
    public static void main(String[] args) throws InterruptedException {
        /*
        1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        2- Add Element butonuna basin
        3- Delete butonu’nun gorunur oldugunu test edin
        4- Delete tusuna basin
        5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
         */
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();

        WebElement deleteButonuElementi= driver.findElement(By.xpath("//button[@class='added-manually']"));

        if (deleteButonuElementi.isDisplayed()){
            System.out.println("delete butonu testi PASSED");
        }else {
            System.out.println("delete butonu testi FAILED");
        }

        Thread.sleep(2000);

        deleteButonuElementi.click();

        WebElement addElementsElementi= driver.findElement(By.xpath("//h3"));

        if (addElementsElementi.isDisplayed()){
            System.out.println("add/remove elements testi PASSED");
        }else {
            System.out.println("add/remove elements testi FAILED");

        }

        Thread.sleep(3000);
        driver.close();

    }
}
