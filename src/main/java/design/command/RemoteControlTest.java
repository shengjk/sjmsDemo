package design.command;

/**
 * @author shengjk1
 * @date 2020/11/10
 */
/*
工作队列类，线程池、日志请求

可以用来实现 日志和事务系统
 */
public class RemoteControlTest {
	public static void main(String[] args) {
		//定义执行的方法，具体有具体的命令执行
		SimpleRemoteControl remoteControl = new SimpleRemoteControl();
		Light light = new Light();
		
		//封装了具体要执行的命令
		//由 SimpleRemoteControl 执行
		LightOnCommand lightOnCommand = new LightOnCommand(light);
		remoteControl.setCommand(lightOnCommand);
		remoteControl.buttonWasPressed();
		
		LightOffCommand lightOffCommand = new LightOffCommand(light);
		remoteControl.setCommand(lightOffCommand);
		remoteControl.buttonWasPressed();
		
		GarageDoor garageDoor = new GarageDoor();
		GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
		remoteControl.setCommand(garageDoorOpenCommand);
		remoteControl.buttonWasPressed();
		
	}
}
