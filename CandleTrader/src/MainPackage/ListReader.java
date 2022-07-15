package MainPackage;

import java.util.*;
import java.io.*;

public class ListReader 
{
	private ArrayList<Candle> candles = new ArrayList<Candle>();
	private ArrayList<String> texts = new ArrayList<String>();
	private ArrayList<String> buffer;
	
	BufferedReader reader;
	
	public ListReader(String path)
	{
		try {
			reader = new BufferedReader(new FileReader (path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//read(path);
	}
	
	public ArrayList<String> read3()
	{
		buffer = new ArrayList<String>();
		String line;
		
		try
		{
			while ((line=reader.readLine())!= null)
			{
				buffer.add(line);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return buffer;
		
	}
	public String read2() 
	{
		buffer = new ArrayList<String>();
		String line;
		try
		{
			while ((line=reader.readLine())!=null)
			{
				buffer.add(line);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return buffer.get(buffer.size()-1);
	}
	
	public void read(String path)
	{
		String line;
		try 
		{
			int i=0;
			
			while((line=reader.readLine()) != null)
			{
				texts.add(line);
				i=i+1;
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		listConverter(texts);
	}
	
	public void listConverter (ArrayList<String> text)
	{
		for(String i: text)
		{
			String[] words = i.split(",");
			Candle e = new Candle(words[0], null, Double.parseDouble(words[1]), Double.parseDouble(words[3]), Double.parseDouble(words[2]), null);	
			candles.add(e);
		}
	}
	public ArrayList<Candle> getCandles()
	{
		return candles;
	}
}
