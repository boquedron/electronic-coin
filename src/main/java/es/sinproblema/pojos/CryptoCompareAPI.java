package es.sinproblema.pojos;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.util.HashMap;

import es.sinproblema.utils.HttpUtils;
import es.sinproblema.utils.JavaNetProxyEnhanced;

public class CryptoCompareAPI extends AbstractPriceSnapshot {

	@Override
	public float getBitcoinValue(EnumCurrency enumCurrency) {
		HashMap<String, String> properties = new HashMap<String, String>();
		
		switch (enumCurrency) {
		case EURO:
			System.out.println("EURO");
			properties.put("fsyms", "BTC");
			properties.put("tsyms", "EUR");

			// java.net.Proxy proxy = new java.net.Proxy(java.net.Proxy.Type.HTTP, new InetSocketAddress(host, Integer.parseInt(port)));
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("host", 80));
			try {
				HttpURLConnection conn = HttpUtils.sendGet("https://min-api.cryptocompare.com/data/pricemulti?", properties,
						new JavaNetProxyEnhanced(proxy));
				// JsonReader reader = new JsonReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
				// reader.
				// Gson g = new Gson().newJsonReader(reader);
				// Version version = new Gson().fromJson(reader, Version.class);
				// System.out.println(Newreader.);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block

			} catch (IOException e) {
				// TODO Auto-generated catch block

			}
			break;
		case USD:
			System.out.println("USD");
			break;
		default:
			System.out.println("desconocido");
		}
		return 10;
	}

	@Override
	public float getEthereumValue(EnumCurrency enumCurrency) {
		// TODO Auto-generated method stub
		return 0;
	}

}
