package es.sinproblema.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.http.client.utils.URIBuilder;

public class HttpUtils {

	// static protected Logger log = Logger.getLogger(HttpUtils.getClass());

	public static HttpURLConnection sendGet(String urlString, HashMap<String, String> properties, JavaNetProxyEnhanced proxy)
			throws MalformedURLException, IOException {

		if (proxy == null) {
			proxy = new JavaNetProxyEnhanced(Proxy.NO_PROXY);
		}

		String urlString2 = urlString;

		if (properties != null) {

			try {
				URIBuilder uri = new URIBuilder(urlString);
				for (Entry<String, String> entry : properties.entrySet()) {
					uri.addParameter(entry.getKey(), entry.getValue());

				}
				urlString2=uri.toString();
				System.out.println("La URI parseada es:");
				System.out.println(urlString2);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		URL url = new URL(urlString2);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection(proxy.getProxy(url));

		conn.setRequestMethod("GET");
		conn.connect();
		conn.disconnect();

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		StringBuilder sb = new StringBuilder();
		String output;
		while ((output = br.readLine()) != null) {
			sb.append(output);
		}
		System.out.println(sb.toString());

		System.out.println(String.format("HTTP Response obtained for URL \"%s\" is \"%s %s\"", url.toString(), conn.getResponseMessage(),
				conn.getResponseCode()));
		System.out.println(conn.getInputStream().toString());
		// HttpUtil.log.info(String.format("HTTP Response obtained for URL \"%s\" is \"%s %s\"", url.toString(), conn.getResponseMessage(),
		// conn.getResponseCode()));
		return conn;
	}

}
