package MainPackage;

public class Candle 
{
	private String date;
	private Double opening;
	private Double closing;
	private Double volume;
	private Double cap;
	private Double median;
	
	public Candle(String Date, Double Opening, Double Closing, Double Volume, Double Cap, Double Median)
	{
		date = Date;
		opening = Opening;
		closing = Closing;
		volume = Volume;
		cap = Cap;
		median = Median;
		
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
	
	public Double getMedian()
	{
		return median;
	}
	
	public void setMedian(Double m)
	{
		median=m;
	}
	
	public void setOpening(Candle c, Double b)
	{
		c.opening=b;
	}
}
