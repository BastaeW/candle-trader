package MainPackage;

import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.java_websocket.client.*;
import org.java_websocket.handshake.*;


public class Client extends WebSocketClient
{
	ListWriter writer;
	public Client(URI serverURI) 
	{
		super(serverURI);
		writer = new ListWriter("D:\\Eclipse\\Output.txt");
	}

	@Override
	public void onClose(int code, String reason, boolean remote) {
		System.out.println("closed with exit code " + code + " additional info: " + reason);
	}

	@Override
	public void onMessage(String message) {
		
		if(message.startsWith("{\"data\":{\"id\""))
		{
			String price = message.substring(message.indexOf("\"price\":")+8, message.indexOf(",\"price_str\":"));
			System.out.println(price);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			writer.written("Time:" + " " + dtf.format(now) + " ;" + " Price:" + " " + price);
		}
	}

	@Override
	public void onError(Exception ex) {
		System.err.println("an error occurred:" + ex);
	}

	@Override
	public void onOpen(ServerHandshake handshake) {
		send("{\r\n"
				+ "    \"event\": \"bts:subscribe\",\r\n"
				+ "    \"data\": {\r\n"
				+ "        \"channel\": \"live_trades_btceur\"\r\n"
				+ "    }\r\n"
				+ "}");
		System.out.println("new connection opened");
	}
}
