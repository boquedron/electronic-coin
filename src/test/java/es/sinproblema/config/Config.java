package es.sinproblema.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

@Configuration
@PropertySource(value = "classpath:config/application.properties")
public class Config {

	@Autowired
	Environment env;

	@Bean(name = "readProxy")
	public Proxy getProxy() {

		if (Boolean.valueOf(this.env.getRequiredProperty("proxy.enabled".trim()))) {
			String host = this.env.getRequiredProperty("proxy.host".trim());
			String port = this.env.getRequiredProperty("proxy.port").trim();

			return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(host, Integer.parseInt(port)));
		} else {
			return new Proxy(Type.DIRECT, null);
		}
	}

}
