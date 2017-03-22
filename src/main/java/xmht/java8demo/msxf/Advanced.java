package msxf;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by shengjk1 on 2016/11/28.
 * <p>
 * 高级集合类和收集器
 */
public class Advanced {
	public static void main(String[] args) {
		List<Object> collect = Stream.of("a", 2, "c").collect(Collectors.toList());
		collect.forEach(x -> System.out.println(x));
		//方法引用，
		// ，虽然这是一个方法，但不需要在后面
//		加括号，因为这里并不调用该方法。我们只是提供了和Lambda 表达式等价的一种结构，
//		在需要时才会调用凡是使用Lambda 表达式的地方，就可以使用方法引用
		//标准语法为Classname::methodName
//		collect.forEach(collect::System.out.println);
		
		Set<Integer> un = new HashSet<>(Arrays.asList(1, 2, 30, 4));
		un.stream().unordered().map(x -> x + 1)
				.forEachOrdered(x -> System.out.println(x));
		
		
		//收集器  这是一个大项
		//指定的集合类型
		un.stream().collect(Collectors.toCollection(TreeSet::new)).forEach(
				x -> System.out.println(x)
		);

//		public double averageNumberOfTracks(List<Album> albums) {
//			return albums.stream()
//					.collect(averagingInt(album -> album.getTrackList().size()));
//		}
		
		//数据分块  将其分解成两个集合 partitioningBy
//		public Map<Boolean, List<Artist>> bandsAndSolo(Stream<Artist> artists) {
//			return artists.collect(partitioningBy(artist -> artist.isSolo()));
//		}
		
		//数据分组  groupingBy
		
		//字符串
//		"[George Harrison, John Lennon, Paul McCartney, Ringo Starr, The Beatles]"
//		String result =artists.stream().map(Artist::getName)
//						.collect(Collectors.joining(", ", "[", "]"));
//
		//分完组之后进行计数
		un.stream().collect(groupingBy(x -> x, counting()));
		//mapping
//		un.stream().collect(groupingBy(x->x,mapping(y->y,xxx)));
		
		//自定义收集器
//		public class StringCollector implements Collector<String, StringCombiner, String> {}
		
		//并行化
		System.out.println("==========================");
		un.parallelStream().forEach(x -> System.out.println(x));
		
		IntStream.range(0, 10);
		
		
		
	}
	
	private static IntFunction<Integer> twoDiceThrows() {
		return i -> {
			ThreadLocalRandom random = ThreadLocalRandom.current();
			int firstThrow = random.nextInt(1, 7);
			int secondThrow = random.nextInt(1, 7);
			return firstThrow + secondThrow;
		};
	}
	
	
}
