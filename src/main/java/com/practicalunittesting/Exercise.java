package com.practicalunittesting;

import java.util.ArrayList;
import java.util.List;

public class Exercise {
    public static String reverse(String s){
        if(s == null || s.isEmpty()){
            throw new IllegalArgumentException("String should not be null or empty");
        }
        if(s.length() == 1){
            throw  new IllegalArgumentException("String length should be atleast 2 characters");
        }

        List<String> tempArray = new ArrayList<>(s.length());
        for (int i=0; i<s.length(); i++){
            tempArray.add(s.substring(i, i+1));
        }

        StringBuilder reversedString = new StringBuilder(s.length());
        for(int i = tempArray.size()-1; i>=0; i--){
            reversedString.append(tempArray.get(i));
        }
        return reversedString.toString();
    }
}