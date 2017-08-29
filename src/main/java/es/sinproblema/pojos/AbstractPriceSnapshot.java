package es.sinproblema.pojos;

public abstract class AbstractPriceSnapshot {

	public enum EnumCurrency {
		EURO, USD
	}

	public abstract float getBitcoinValue(EnumCurrency enumCurrency);

	public abstract float getEthereumValue(EnumCurrency enumCurrency);

}
