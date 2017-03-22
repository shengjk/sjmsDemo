package msxf;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by shengjk1 on 2016/11/27.
 */
public class StreamDemo {
	public static void main(String[] args) {
		//collect
		List<Object> collect = Stream.of("a", 2, "c").collect(Collectors.toList());
		
		collect.forEach(x-> System.out.println(x));
		
		Assert.assertEquals(Arrays.asList("a", 2, "c"), collect);
		
		//如果有一个函数可以将一种类型的值转换成另外一种类型，map 操作就可以
		//使用该函数，将一个流中的值转换成一个新的流。
		//map
		Stream.of("a","b","c").map(String-> String.toUpperCase()).collect(Collectors.toList()).forEach(x-> System.out.println(x));
		
		//filter
		//flatMap flatMap 方法可用Stream 替换值， 然后将多个Stream 连接成一个Stream
		Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
				.flatMap(nu->nu.stream()).collect(Collectors.toList()).forEach(
						x-> System.out.println(x)
		);
		
		//max
		//min
		/**
		 * tracks.stream()
		 .min(Comparator.comparing(track -> track.getLength()))
		 .get();
		 */
		//reduce
		/**
		 * reduce 方法的一个重点尚未提及：reduce 方法有两种形式，一种如前面出现的需要有一
		 个初始值，另一种变式则不需要有初始值。没有初始值的情况下，reduce 的第一步使用
		 Stream 中的前两个元素。有时，reduce 操作不存在有意义的初始值，这样做就是有意义
		 的，此时，reduce 方法返回一个Optional 对象。
		 */
		
		
		
		/**
		 * 命令式编程，循环在外面，函数式编程，循环在里面
		 */
		
	}
}
