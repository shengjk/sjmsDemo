package xmht.javabase.effictjava.util;

import java.util.HashMap;

/**
 * @author shengjk1
 * @date 2019-05-13
 */
public class CollectionUtil {
	public static <K,V> HashMap<K,V> newInstance(){
		return new HashMap<K,V>();
	}
}
