package com.practicalunittesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class ExerciseTest {
    @DataProvider
    public static Object[][] getReversedStrings(){
        return new Object[][]{
                {"Hello", "olleH"},
                {"madam","madam"},
                {"rotor", "rotor"}
        };
    }

    @DataProvider
    public static  Object[][] getInvalidStrings(){
        return new Object[][]{
                {"s"},
                {""},
                {null}
        };
    }

    @Test(dataProvider = "getReversedStrings")
    public void passedStringShouldNotBeEmpty(String inputString, String reversedString){
        assertEquals(Exercise.reverse(inputString), reversedString);
    }

    @Test(dataProvider = "getInvalidStrings", expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowIAEForEmptyOrNullString(String s){
        Exercise.reverse(s);
    }
}
