package msxf.java;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by 小省 .
 */
public class Test {
    public static void main(String[] args) {
//        integer作为返回值
        Function<String,Integer> function=(x)->{
            System.out.println(x+":");
//            return "function";
            return 12;
        };

        System.out.println(function.apply("hello, world"));

        //返回boolean值，string作为输入
        Predicate<String> pre=(x)->{
            System.out.println(x);
            return false;
        };

        //String作为输入，hi执行某个动作但么有返回值
        Consumer<String> con=(x)->{
            System.out.println(x);

        };
        con.accept("helllo");
        
    }
}
