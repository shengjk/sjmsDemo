package socket.step3;

import java.io.IOException;

/**
 * @author shengjk1
 * @date 2021/4/29
 */
@FunctionalInterface
public interface IHandlerInterface {

	void handler(Request request, Respone respone) throws IOException;
}

