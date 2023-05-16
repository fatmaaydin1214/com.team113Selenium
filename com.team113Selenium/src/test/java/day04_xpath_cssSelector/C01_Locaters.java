package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_Locaters {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       /* 1- https://www.amazon.com/ sayfasına gidin.
        2- Arama kutusuna “city bike” yazip aratin
        3- Görüntülenen sonuçların sayısını yazdırın
        4- Listeden ilk urunun resmine tıklayın.

        */

        driver.get("https://www.amazon.com/");

        WebElement aramaKutusuElememnti= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusuElememnti.sendKeys("city bike"+ Keys.ENTER);

        WebElement aramaSonucuElementi= driver.findElement(By.className("sg-col-inner"));
        System.out.println(aramaSonucuElementi.getText());

        List<WebElement> urunResimElememntleriList= driver.findElements(By.className("s-image"));
        urunResimElememntleriList.get(0).click();

        Thread.sleep(2000);
        driver.close();
    }
}
