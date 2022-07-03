package MainPackage;

public class Candle 
{
	private String date;
	private Double opening;
	private Double closing;
	private Double volume;
	private Double cap;
	
	public Candle(String Date, Double Opening, Double Closing, Double Volume, Double Cap)
	{
		date = Date;
		opening = Opening;
		closing = Closing;
		volume = Volume;
		cap = Cap;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public Double getOpening()
	{
		return opening;
	}
	
	public Double getClosing()
	{
		return closing;
	}
	
	public Double getVolume()
	{
		return volume;
	}
	
	public Double getCap()
	{
		return cap;
	}
}
