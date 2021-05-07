package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author shengjk1
 * @date 2021/4/29
 */
public class RawHttpServer {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8000);

		while (true) {
			Socket socket = serverSocket.accept();
			System.out.println("a socket created");

			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
			StringBuilder requestBuilder = new StringBuilder();

			String line = "";
			while (!(line = bufferedReader.readLine()).isEmpty()) {
				requestBuilder.append(line + "\n");
			}
			String request = requestBuilder.toString();
			System.out.println("request = " + request);

			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bufferedWriter.write("HTTP/1.1 200 ok \n\n HelloWorld\n");

			bufferedWriter.flush();
			socket.close();
		}
	}
}
