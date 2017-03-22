package msxf.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2016/7/27.
 */
public class Stream1 {
	public static void main(String[] args) {
		long count= Arrays.asList(1,2,3,4,5,6,11,7,8,9,0,10).stream().filter(x->x>5)
				.count();
		System.out.println(count);
		//常用的流操作
		List<String> collected= Stream.of("a","2","c").collect(Collectors.toList());
		/*
		2)比较的逻辑不同，结果可能不同。
assertSame是对象直接比较。assertEquals能利用被比较对象提供的比较逻辑来进行比较。
使得同样的条件下，两者的运行结果不一定相同。
简单解释如下：
assertEquals(Object A,  Object B) 的比较逻辑：
如果 A,B都是Null,返回true。否则调用 A.equals(B)来判断。

assertSame(Object A, Object B)的比较逻辑：
以A == B运算的结果来判断。

A.equals(B) 和 A==B 的差别在于。
如果A没有重写java.lang.Object的equals方法，
那么就是两个java对象的内存地址比较，比较结果和 A==B的结果相同。
如果A重写了equals方法(比如GregorianCalendar，BigDecimal类)，
那么比较的结果不一定和A==B的结果相同。
		 */
		assertEquals(Arrays.asList("a","2","c"),collected);
	}
}
