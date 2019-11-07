package xmht.javabase.effictjava.chapter02.test01;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shengjk1
 * @date 2019-05-13
 */
public class Services {
	private Services() {
	};
	
	private static final Map<String, Provider> providers = new ConcurrentHashMap<>();
	public static final String DEFAULT_PROVIDER_NAME = "<def>";
	
	public static void registerDefaultProvider(Provider provider) {
		registerProvider(DEFAULT_PROVIDER_NAME, provider);
	}
	
	public static void registerProvider(String name, Provider provider) {
		providers.put(name, provider);
	}
	
	public static IService newInstance() {
		return newInstance(DEFAULT_PROVIDER_NAME);
	}
	
	public static IService newInstance(String name) {
		Provider p = providers.get(name);
		if (p == null) {
			throw new IllegalArgumentException("No provider registered with name :" + name);
		}
		return p.newService();
	}
	
	
}
