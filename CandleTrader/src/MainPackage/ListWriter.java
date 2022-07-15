package MainPackage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ListWriter 
{
	PrintStream pw;
	
	public ListWriter(String path)
	{
		try {
			pw=new PrintStream(new FileOutputStream(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void written(String message) 
	{	
		if(message.startsWith("{" + "\"" + "event")!=true)
		{
		pw.println(message);
		}
	}
	
}
