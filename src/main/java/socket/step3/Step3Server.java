package socket.step3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author shengjk1
 * @date 2021/4/29
 */
public class Step3Server {
	ServerSocket      serverSocket;
	IHandlerInterface httpHandler;

	public Step3Server(IHandlerInterface httpHandler) {
		this.httpHandler = httpHandler;
	}

	public void listen(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		while (true) {
			this.accept();
		}
	}

	protected void accept() throws IOException {
		Socket scoket = serverSocket.accept();
		new Thread(() -> {
			try {
				this.handler(scoket);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}

	private void handler(Socket socket) throws IOException {
		Request request = new Request(socket);
		Respone respone = new Respone(socket);
		this.httpHandler.handler(request, respone);
	}

	public static void main(String[] args) throws IOException {
		Step3Server step3Server = new Step3Server((req, resp) -> {
			resp.send("Gettings");
		});
		step3Server.listen(8000);
	}
}

