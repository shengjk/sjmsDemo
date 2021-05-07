package socket.step3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shengjk1
 * @date 2021/4/29
 */
public class Respone {
	private Socket socket;
	private String status;
	private Map    codeMap;

	public Respone(Socket socket) {
		this.socket = socket;
		if (codeMap == null) {
			codeMap = new HashMap();
			codeMap.put("200", "OK");
		}

	}

	public void send(String msg) throws IOException {
		String resp = "HTTP/1.1 " + this.status + " " + this.codeMap.get(this.status) + "\n";
		resp += "\n";
		this.sendRaw(resp);

	}

	public void sendRaw(String msg) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bufferedWriter.write(msg);
		bufferedWriter.flush();
		socket.close();
	}
}
