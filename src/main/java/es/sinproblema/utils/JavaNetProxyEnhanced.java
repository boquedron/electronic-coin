package es.sinproblema.utils;

import java.net.Proxy;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class JavaNetProxyEnhanced {

	Proxy proxy = null;
	Set<String> nonProxyHosts = new HashSet<String>();

	public JavaNetProxyEnhanced(Proxy proxy) {
		this.proxy = proxy;
	}

	public Proxy getProxy() {		
		return proxy;
	}

	public void addnonProxyHost(String host) {
		this.nonProxyHosts.add(host.trim());
	}		
	
	public Proxy getProxy(URL url) {		
		if (this.nonProxyHosts.contains(url.getHost())) {
			return java.net.Proxy.NO_PROXY;
		}
		return this.proxy;
	}
	
	@Override
	public String toString() {
		return String.format("%s with non-proxy-hosts %s", this.proxy.toString(), this.nonProxyHosts.toString());
		
	}

}
