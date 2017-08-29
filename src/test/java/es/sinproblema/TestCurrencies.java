package es.sinproblema;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import es.sinproblema.pojos.AbstractPriceSnapshot.EnumCurrency;
import es.sinproblema.pojos.CryptoCompareAPI;

public class TestCurrencies {

	protected Logger log = Logger.getLogger(this.getClass());

	@Test(priority = 1)
	public void test1() {
		
		CryptoCompareAPI crypto = new CryptoCompareAPI();
		crypto.getBitcoinValue(EnumCurrency.EURO);
	}
}
