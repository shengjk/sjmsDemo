package design.command;

/**
 * @author shengjk1
 * @date 2020/11/10
 */
/*
执行命令
 */
public class SimpleRemoteControl {
	Command slot;
	
	public SimpleRemoteControl() {
	}
	
	public void setCommand(Command command) {
		slot = command;
	}
	
	public void buttonWasPressed() {
		slot.execute();
	}
}
