一.再次拾起java8
1.如果lambda表达式的参数类型可以被推导出来，那就可以省略。这里与python，scala都是统一的
2.lambda表达式只在某些分支中有返回值是不对的。而python或者scala会返回他们的超类
3.lambda表达式主要针对的是函数式接口,在java8中只包含一个抽象方法的接口，lambda相对于内部类更为简洁了些
4.java8中设计者们新增加了很多函数式接口。任何一个lambda表达式都可以等价转化为函数式接口
5.方法引用 x->System.out.println(x) ==>System.out::println有点像scala当中的 println(_)
    对象::实例方法，类::静态方法，类::实例方法
