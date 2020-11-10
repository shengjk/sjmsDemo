package design.observer;

/**
 * @author shengjk1
 * @date 2020/11/9
 */
public interface Subject {
	public void registerObserver(Observer observer);
	
	public void removeObserver(Observer observer);
	
	public void notifyObservers();
}
