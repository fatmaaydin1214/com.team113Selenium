package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {
    public static void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {

        }

    }

    public static void tumSayfaScreenshotCek(WebDriver driver) {
        //1-TakeScreenshot objesi olustur
        TakesScreenshot tss= (TakesScreenshot) driver;

        //2-Resmi son olarak kaydedecegimiz dosyayi olustur
        // her resim cektiginde ustuste kaydetmemesi icin
        // reim dosya yoluna tarih ve saat iceren bir ek yapalim
        LocalDateTime ldt= LocalDateTime.now();
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih=ldt.format(dtf);
        String dosyaYolu="target/ekranResimleri/tumEkranSs"+tarih+".jpeg";
        File tumSayfaScreenshot= new File(dosyaYolu);
        //3-tss objesi kullanarak ekran goruntusu alip, gecici dosyaya kaydet
        File geciciDosya= tss.getScreenshotAs(OutputType.FILE);
        //4-Gecici dosyayi ana dosyaya kopyala
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);
        } catch (IOException e) {

        }
    }
    public static void elementSSCek(WebElement element) throws IOException {
        //1-Screenshot alacagimiz elementi locate et.
        //2-Kaydedecegimiz dosyayi olustur
        LocalDateTime ldt= LocalDateTime.now();
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih=ldt.format(dtf);
        String dosyaYolu="target/ekranResimleri/istenenElementSs"+tarih+".jpeg";

        File elementSS= new File(dosyaYolu);

        //3-Gecici dosyayi olusturup element uzerinden secreenshot yapalim
        File gecici= element.getScreenshotAs(OutputType.FILE);
        //4-Gecici dosyayi hedef dosyaya kopyala

        try{
            FileUtils.copyFile(gecici,elementSS);

        }   catch (IOException e)  {

        }
    }
}
