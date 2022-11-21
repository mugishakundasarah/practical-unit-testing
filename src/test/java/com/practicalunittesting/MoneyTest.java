package com.practicalunittesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class MoneyTest {
	private final static int VALID_AMOUNT = 5;
	private final static String VALID_CURRENCY = "USD";

	@DataProvider
	private static  final Object[][] getInvalidAmount(){
		return new Integer[][] {{-12387},{-5}, {-1}};
	}

	@DataProvider
	private static Object[][] getInvalidCurrency(){
		return new String[][] {{null}, {""}};
	}

	@Test(dataProvider = "getInvalidAmount" ,expectedExceptions = IllegalArgumentException.class)
	public void shouldThrowIAEForInvalidAmount(int invalidAmount){
		Money money = new Money(invalidAmount, VALID_CURRENCY);
	}

	@Test(dataProvider = "getInvalidCurrency", expectedExceptions = IllegalArgumentException.class)
	public void shouldThrowIAEForInvalidCurrency(String invalidCurrency){
		Money money = new Money(VALID_AMOUNT, invalidCurrency);
	}

	@Test(dataProvider = "getMoney", dataProviderClass = DataProviders.class)
	public void constructorShouldSetAmountAndCurrency(int amount, String currency){
		Money money = new Money(amount, currency);
		assertEquals(money.getAmount(), amount);
		assertEquals(money.getCurrency(), currency);
	}

}
