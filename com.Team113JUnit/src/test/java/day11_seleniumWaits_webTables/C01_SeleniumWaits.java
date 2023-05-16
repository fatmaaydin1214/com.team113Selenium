package day11_seleniumWaits_webTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_SeleniumWaits {
    /*
    Otomasyon yaparken sayfanin yuklenmesi ve webelementlerin yuklenmesi icin gerekli sureyi
    implicitly wait ile ayarlariz
    implicitly wait sayfanin yuklenmesi ve herbir webelementin bulunmasi icin tanimlanan max. beklemem suresidir

    her islem icin sifirdan baslaer ve max sure doluncaya kadar gorevi tamamlamaya calisir



    2. Iki tane metod olusturun : implicitWait() , explicitWait()
     Iki metod icin de asagidaki adimlari test edin.
    3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    4. Remove butonuna basin.
    5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    6. Add buttonuna basin
    7. It’s back mesajinin gorundugunu test edin

     */
    @Test
    public void test01(){
        //implicity wait in rolunu gorebilmek iicin
        // baslangic ayarlarini bu test methodunda yapalim


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text() = 'Remove']")).click();
        //5. "It's gone!" mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneElementi = driver.findElement(By.xpath("//p[text() =\"It's gone!\"]"));

        Assert.assertTrue(itsGoneElementi.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //7. It's back mesajinin gorundugunu test edin
        WebElement itsBackElementi= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsBackElementi.isDisplayed());
        driver.close();
    }
    @Test
    public void explitcitlyWaitTesti(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text() = 'Remove']")).click();

        //5. "It's gone!" mesajinin goruntulendigini dogrulayin.

        /*
            Burada testi manuel olarak yapip
            bir karar vermemiz gerekiyor
            1- test etmek istedigimiz webelement zaten gorunuyorsa
                webelementi locate yapip sonra ozel beklemeyi tanimlarim.
            2- test etmek istedigimiz elementin ulasilabilir olmasi icin
                beklemek gerekiyorsa
                locatari verip, "bu locator ile bir element locate edene kadar
                exception firlatma bekle" diyebiliriz
         */

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement itsGoneElementi =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text() =\"It's gone!\"]")));
        Assert.assertTrue(itsGoneElementi.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //7. It's back mesajinin gorundugunu test edin
        WebElement itsBackElementi =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsBackElementi.isDisplayed());
        driver.close();
    }

}
