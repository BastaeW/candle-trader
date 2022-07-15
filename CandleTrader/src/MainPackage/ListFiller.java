package MainPackage;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ListFiller {
	Timer timer;
	Scanner sc;

	ListReader minr;
	ListReader hourr;
	ListReader dayr;
	ListReader minm;
	ListReader hourm;
	ListReader daym;

	ListWriter min;
	ListWriter hour;
	ListWriter day;
	ListWriter mina;
	ListWriter houra;
	ListWriter daya;
	
	ArrayList<String> buffer;

	public ListFiller() {
		sc = new Scanner(System.in);
		minr = new ListReader("D:\\Eclipse\\Output.txt");
		hourr = new ListReader("D:\\Eclipse\\Minute_Orders.txt");
		dayr = new ListReader("D:\\Eclipse\\Hour_Orders.txt");

		minm = new ListReader("D:\\Eclipse\\Minute_Orders.txt");
		hourm = new ListReader("D:\\Eclipse\\Hour_Orders.txt");
		daym = new ListReader("D:\\Eclipse\\Day_Orders.txt");
		
		min = new ListWriter("D:\\Eclipse\\Minute_Orders.txt");
		hour = new ListWriter("D:\\Eclipse\\Hour_Orders.txt");
		day = new ListWriter("D:\\Eclipse\\Day_Orders.txt");
		
		mina = new ListWriter("D:\\Eclipse\\Minute_Median.txt");
		houra = new ListWriter("D:\\Eclipse\\Hour_Median.txt");
		daya = new ListWriter("D:\\Eclipse\\Day_Median.txt");
		
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(3);

		Runnable minuteList = () -> {
			String input = minr.read2();
			min.written(input);
		};

		Runnable hourList = () -> {
			String input = hourr.read2();
			hour.written(input);
		};

		Runnable dayList = () -> {
			String input = dayr.read2();
			day.written(input);
		};
		
		Runnable minuteMedian = () -> {
			int i1=50;
			int i2=100;
			int i3=200;
			
			double d1=0.0;
			double d2=0.0;
			double d3=0.0;
			
			double mass=0;
			
			buffer = new ArrayList<String>();
			buffer = minm.read3();
			
			if(buffer.size() > 0)
			{
				if(buffer.size() > i1)
				{
					mass=0;
					for(int k=1;k<=i1; k++)
					{
						mass=mass + Double.valueOf(buffer.get(buffer.size()-k));
					}
					d1=mass/50;
				}
				else
				{
					mass=0;
					for(int k=1;k<=buffer.size(); k++)
					{
						mass=mass + Double.valueOf(buffer.get(buffer.size()-k));
					}
					d1=mass/buffer.size();
				}
				if(buffer.size() > i2)
				{
					mass=0;
				}
				else
				{
					mass=0;
				}
				if(buffer.size() > i3)
				{
					mass=0;
				}
				else
				{
					mass=0;
				}
			}
			else
			{
				
			}
			mina.written(buffer.get(buffer.size()-1) + " " + "Median1" + d1+ " " + "Median2" + d2+ " " + "Median3" + d3);
		}; 
		
		Runnable hourMedian = () -> {
			
		}; 
		
		Runnable dayMedian = () -> {
			
		}; 
		
		ScheduledFuture<?> scheduledFuture1 = ses.scheduleAtFixedRate(minuteList, 60, 60, TimeUnit.SECONDS);
		ScheduledFuture<?> scheduledFuture2 = ses.scheduleAtFixedRate(hourList, 60, 60, TimeUnit.MINUTES);
		ScheduledFuture<?> scheduledFuture3 = ses.scheduleAtFixedRate(minuteMedian, 60, 60, TimeUnit.SECONDS);
		ScheduledFuture<?> scheduledFuture4 = ses.scheduleAtFixedRate(hourMedian, 60, 60, TimeUnit.MINUTES);
		//ScheduledFuture<?> scheduledFuture3 = ses.scheduleAtFixedRate(dayList, 24, 24, TimeUnit.MINUTES);

		// ses.scheduleAtFixedRate(minuteList, 0, 5, TimeUnit.SECONDS);
		while (true) {
			if (sc.nextLine().equals("close")) 
			{
				scheduledFuture1.cancel(true);
				scheduledFuture2.cancel(true);
				scheduledFuture3.cancel(true);
				scheduledFuture4.cancel(true);
				//scheduledFuture3.cancel(true);
				ses.shutdown();
			}
		}
	}
	
	
}
