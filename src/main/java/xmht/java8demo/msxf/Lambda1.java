package msxf;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * Created by shengjk1 on 2016/11/22.
 */
public class Lambda1 {
	public static void main(String[] args) {
		Runnable a=()-> System.out.println("aaa");
		BinaryOperator<Long> add=(x,y)->x+y;//add 代表两个数字相加的那行代码
		Comparator<String> comp=(first,second)->Integer.compare(first.length(),second.length());
		Predicate<Integer> integerPredicate=x->x>5;
	}
}
