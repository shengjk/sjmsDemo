package xmht.javabase.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by shengjk1 on 2018/4/11
 */
/*
注释从语法上来看几乎与修饰符的使用一模一样
注解的定义看起来很像接口的定义，事实上，与其他接口一样，注解也会编译成class文件

在注解中，一般都会包含一些元素以表示某些值。当分析处理注解时，程序或工具可以利用这些值。
注解的元素看起来像接口的方法，唯一的区别是你可以为其指定默认值

咩有注解元素的称为标记注解


注解元素的可用类型
 */
@Target(ElementType.METHOD)  //定义你的注解将应用于什么地方，例如一个方法或者一个域
@Retention(RetentionPolicy.RUNTIME)//定义注解在哪个级别可用，在源代码中(SOURCE)，类文件中(CLASS)或者运行时(RUNTIME)
public @interface Test {

}
