package msxf.java;

import java.util.function.Predicate;

/**
 * Created by Administrator on 2016/7/27.
 */
public interface IntPred {
	boolean test (Integer integer);
	boolean check (Predicate<Integer> predicate);
	boolean check(IntPred intPred);
}
