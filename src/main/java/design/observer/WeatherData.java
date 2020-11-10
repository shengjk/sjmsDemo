package design.observer;

import java.util.ArrayList;

/**
 * @author shengjk1
 * @date 2020/11/9
 */
public class WeatherData implements Subject {
	private ArrayList<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		this.observers = new ArrayList<>();
	}
	
	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}
	
	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}
	
	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(temperature, humidity, pressure);
		}
	}
}
