package design.command;

/**
 * @author shengjk1
 * @date 2020/11/10
 */
public class LightOnCommand implements Command {
	Light light;
	
	public LightOnCommand(Light light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		light.on();
	}
}
