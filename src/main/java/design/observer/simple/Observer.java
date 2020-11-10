package design.observer.simple;

/**
 * @author shengjk1
 * @date 2020/11/9
 */
//观察者，观察者的目的是对主题数据发生变化的一种处理方式
public interface Observer {
	void update(int value);
}
