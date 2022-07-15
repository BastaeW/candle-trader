package MainPackage;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

import org.java_websocket.client.WebSocketClient;



public class Main {

	public ArrayList<Candle> Candles = new ArrayList<Candle>();
	public ArrayList<String> Orders = new ArrayList<String>(); 
	public WebSocketClient client;
	public Gui gui;
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main()
	{
		Scanner sc = new Scanner(System.in);
		
		try {
			client = new Client(new URI("wss://ws.bitstamp.net"));
			client.connect();
			new ListFiller();
			if (sc.nextLine().equals("close"))
			{
				client.close();
			}
			
		} 	catch (URISyntaxException e) {
			e.printStackTrace();
		}
		gui=new Gui();
		ListReader listReader =new ListReader("C:\\Users\\sebas\\OneDrive\\Eclipse Dateien\\csv.csv");
		Candles=listReader.getCandles();
		
		for(Candle i:Candles)
		{
			if(Candles.indexOf(i)>0)
			{
				i.setOpening(i, Candles.get(Candles.indexOf(i)-1).getClosing());
			}
			else
			{
				i.setOpening(i, 0.0);
			}
			
			int movavg=200;
			if(Candles.indexOf(i)>movavg)
			{
			avg(i, movavg);
			//System.out.println(i.getDate() + " " + i.getOpening() + " " + i.getClosing() + " " + i.getMedian());
			}
		}
	}
	
	public void avg (Candle c, int j)
	{
		
		int k = Candles.indexOf(c);
		double mass=0.0;
		for(int i=k-j; i<=k;i++)
		{
			mass = mass + Candles.get(i).getClosing();
		}
		double m = mass/j;
		c.setMedian(m);
	}
	
	public ArrayList<Candle> getCandles()
	{
		return Candles;
	}
	public ArrayList<String> getOrders()
	{
		return Orders;
	}

}
