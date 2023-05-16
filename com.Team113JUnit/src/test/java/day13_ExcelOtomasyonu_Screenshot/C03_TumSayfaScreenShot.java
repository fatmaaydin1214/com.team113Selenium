package day13_ExcelOtomasyonu_Screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_TumSayfaScreenShot extends TestBase {
    @Test
    public void test01() throws IOException {
        driver.get("https://www.amazon.com");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        WebElement sonucElementi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));

        String acctualSonucYazisi= sonucElementi.getText();
        String expectedIcerik = "Nutella";
        Assert.assertTrue(acctualSonucYazisi.contains(expectedIcerik));

        TakesScreenshot tss= (TakesScreenshot) driver;
        File tumSayfaResim = new File("target/ekranResimleri/tumSayfaResim.png");

        File geciciResim = tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,tumSayfaResim);
    }
}
