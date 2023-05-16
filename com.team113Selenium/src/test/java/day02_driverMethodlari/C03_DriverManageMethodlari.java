package day02_driverMethodlari;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_DriverManageMethodlari {
    public static void main(String[] args) throws InterruptedException {
       //  System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");

        /*
        selenium 4.7 versiyonu ile kendi driverini sisteme ekledi kodlar
        calismaya basladiginda biz driver icin yol gostermezsek selenium
        kendi driverini devreye sokar ama baslangicta driver ayari aradigi icin biraz yavas calisir
         */
        WebDriver driver= new ChromeDriver();
        driver.get("https://wwww.amazon.com/");





        Thread.sleep(1000);
        driver.manage().window().maximize();
        System.out.println("Baslangicta konum : "+driver.manage().window().getPosition());
        System.out.println("Baslangicta ebat : "+driver.manage().window().getSize());

        Thread.sleep(1000);
        driver.manage().window().fullscreen();
        System.out.println("Fullscreen konum : "+driver.manage().window().getPosition());
        System.out.println("Fullscreen ebat : "+driver.manage().window().getSize());

        Thread.sleep(1000);
        driver.manage().window().minimize();
        System.out.println("minimize konum : "+driver.manage().window().getPosition());
        System.out.println("minimize ebat : "+driver.manage().window().getSize());


        // pencereyi istedigimiz konum ve boyuta getirelim

        driver.manage().window().setPosition(new Point(50,50));
        driver.manage().window().setSize(new Dimension(500,500));
        System.out.println("istedigimiz konum : "+driver.manage().window().getPosition());
        System.out.println("istedigimiz ebat : "+driver.manage().window().getSize());


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        Thread.sleep(3000);
        driver.close();



    }
}
