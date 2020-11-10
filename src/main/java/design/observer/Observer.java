package design.observer;

/**
 * @author shengjk1
 * @date 2020/11/9
 */
public interface Observer {
	public void update(float temp, float humidity, float pressure);
}
