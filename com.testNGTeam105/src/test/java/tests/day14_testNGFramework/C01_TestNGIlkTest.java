package tests.day14_testNGFramework;

import org.testng.annotations.Test;

public class C01_TestNGIlkTest {
    //testNG test methodlarini isim sirasina gore calistirir.
    // Priority degeri verilen methodlar priority kucukten buxyuge dogru calisir
    //esit olan priority degerlerinde harf sirasina gore calisir
    //eger priority degeri yazmazsak priority=0 kabul edilir


    @Test (priority = 5)
    public void ilkTest(){
        System.out.println("Ilk test calisti");
    }
    @Test (priority = 8)
    public void ikinciTest(){
        System.out.println("Ikinci test calisti");
    }
    @Test (priority = 10)
    public void ucuncuTest(){
        System.out.println("Ucuncu test calisti");
    }
}
