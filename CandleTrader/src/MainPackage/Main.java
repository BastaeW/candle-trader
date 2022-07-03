package MainPackage;


import java.util.*;



public class Main {

	public ArrayList<Candle> Candles = new ArrayList<Candle>();
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main()
	{
		new ListReader();
	}
	
	public ArrayList<Candle> getCandles()
	{
		return Candles;
	}

}
