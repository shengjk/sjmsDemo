package socket.step3;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpParser;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author shengjk1
 * @date 2021/4/29
 */
public class Request {
	static        Pattern                 methodRegex = Pattern.compile("(GET|PUT|POST|DELETE|OPTIONS|TRACE|HEAD)");
	private final String                  body;
	private final String                  method;
	private final HashMap<String, String> headers;

	public Request(Socket socket) throws IOException {
		DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));

		String methodLine = HttpParser.readLine(dataInputStream, "UTF-8");
		Matcher m = methodRegex.matcher(methodLine);
		m.find();
		String method = m.group();

/*
Content-type:xxx
Lenght:xx
 */
		Header[] headers = HttpParser.parseHeaders(dataInputStream, "UTF-8");
		HashMap<String, String> headerMap = new HashMap<>();
		for (Header header : headers) {
			headerMap.put(header.getName(), header.getValue());
		}

		BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(dataInputStream));
		StringBuilder body = new StringBuilder();

		char[] buffer = new char[1024];
		while (dataInputStream.available() > 0) {
			bufferedReader1.read(buffer);
			body.append(buffer);

		}
		this.body = body.toString();
		this.method = method;
		this.headers = headerMap;
	}

	public String getBody() {
		return body;
	}

	public String getMethod() {
		return method;
	}

	public HashMap<String, String> getHeaders() {
		return headers;
	}
}
