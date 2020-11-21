package design.state;

/**
 * @author shengjk1
 * @date 2020/11/11
 */
/*
如何对对象内的状态建模
通过创建一个实例变量来持有状态值，并在方法内书写条件代码来处理不同的状态
 */
public class GumballMachine {
	final static int SOLD_OUT = 0;
	final static int NO_QUARTER = 1;
	final static int HAS_QUARTER = 2;
	final static int SOLD = 3;
	
	int state = SOLD_OUT;
	
}
