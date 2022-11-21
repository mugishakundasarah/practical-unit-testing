package com.practicalunittesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class FahrenheitCelciusConverterTest {
    @DataProvider
    public  static Object[][] getTempsInCelcius(){
        return new Object[][]{
            {0,32}, {37,98}, {100,212}
        };
    }

    @DataProvider
    public  static Object[][] getTempsInFahrenheit(){
        return new Object[][]{
                {32,0}, {100,37}, {212,100}
        };
    }

    @Test(dataProvider = "getTempsInCelcius")
    public void shouldConvertCelciusToFahrenheit(int tempInCelcius, int tempInFahrenheit){
        assertEquals(FarenheitCelciusConverter.toFahrenheit(tempInCelcius), tempInFahrenheit);
    }

    @Test(dataProvider = "getTempsInFahrenheit")
    public void shouldConvertFahrenheitToCelcius(int tempInFahrenheit, int tempInCelcius){
        assertEquals(FarenheitCelciusConverter.toCelcius(tempInFahrenheit), tempInCelcius);
    }
}