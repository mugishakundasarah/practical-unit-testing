package com.practicalunittesting;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider
    public static final Object[][] getMoney() {
        return new Object[][]{
                {10, "USD"},
                {20, "EUR"}
        };
    }


}
