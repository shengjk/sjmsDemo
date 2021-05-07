package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.function.Function;

/**
 * @author shengjk1
 * @date 2021/4/29
 */
public class Step2Server {
	ServerSocket             serverSocket;
	Function<String, String> handler;

	public Step2Server(Function<String, String> handler) {
		this.handler = handler;
	}

	public void listen(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		while (true) {
			this.accept();
		}

	}

	public void accept() throws IOException {
		//blocking
		Socket socket = serverSocket.accept();
		new Thread(() -> {
			try {
				this.handler(socket);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}

	public void handler(Socket socket) throws IOException {

		try {
			System.out.println("a socket created");

			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
			StringBuilder requestBuilder = new StringBuilder();

			String line = "";
			while (true) {
				line = bufferedReader.readLine();
				if (line == null || line.isEmpty()) {
					break;
				}
				requestBuilder.append(line + "\n");
			}
			String request = requestBuilder.toString();
			System.out.println("request = " + request);

			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String resonse = this.handler.apply(request);
			bufferedWriter.write(resonse);

			bufferedWriter.flush();
			socket.close();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		Step2Server step1Server = new Step2Server(req -> {
			return "HTTP/1.1 200 ok \n\n Goold!\n";
		});
		step1Server.listen(8000);
	}
}
