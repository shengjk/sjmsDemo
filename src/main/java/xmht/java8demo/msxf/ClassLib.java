package xmht.java8demo.msxf;

import org.junit.Assert;

import java.util.Optional;

/**
 * Created by shengjk1 on 2016/11/27.
 */
public class ClassLib {
	public static void main(String[] args) {
		Optional<String> a=Optional.of("a");
		System.out.println(a.get());
		System.out.println(a.isPresent());
		
		Optional optional=Optional.empty();
		Optional optional1=Optional.ofNullable(null);
		
		Assert.assertFalse(optional.isPresent());
		Assert.assertFalse(optional1.isPresent());
		Assert.assertEquals("c",optional.orElse("c"));
		Assert.assertEquals("c",optional.orElseGet(()->"c"));
		
		
	}
}
