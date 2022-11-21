package com.practicalunittesting;

public class FarenheitCelciusConverter {

    public static int toFahrenheit(int tempInCelcius){
        int result = (tempInCelcius * 9/5 ) + 32 ;
        return  result;
    }

    public static int toCelcius(int tempInFarenheit){
        int result = (tempInFarenheit - 32)  * 5/9;
        return result;
    }
}
