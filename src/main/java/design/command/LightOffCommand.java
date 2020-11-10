package design.command;

/**
 * @author shengjk1
 * @date 2020/11/10
 */
public class LightOffCommand implements Command {
	Light light;
	
	public LightOffCommand(Light light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		light.off();
	}
}
