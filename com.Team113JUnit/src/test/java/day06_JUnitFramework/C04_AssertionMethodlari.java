package day06_JUnitFramework;

import org.junit.Assert;

public class C04_AssertionMethodlari {
    public void  test01(){

        int sayi1 = 20;
        int sayi2 = 10;
        int sayi3 = 30;

        // sayi1'in sayi2'den buyuk old test edin

        Assert.assertTrue(sayi1>sayi2);   //sayi1>sayi2 passed


        // sayi1'in sayi3'den buyuk olmadigini test edin

        Assert.assertFalse(sayi1>sayi3);

        //sayi1'in sayi3'den kucuk old test edin

        Assert.assertTrue(sayi1<sayi3);
    }
}
