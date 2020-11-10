package design.observer.simple;


/**
 * @author shengjk1
 * @date 2020/11/9
 */
//主题，注册观察者、remove观察者、
// nofity observer  通知完之后，具体 Observer 要做什么完全在于 Observer
// 把通知与实现解耦了
public interface Subject {
	//注册一个观察者
	void registerObserver(Observer o);
	
	void removeObserver(Observer o);
	
	void notifyObservers();
	
}
