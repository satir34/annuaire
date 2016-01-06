package annuaire;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class Test {
	public static void main(String[] args)
	{
		Properties t = System.getProperties();
		for(Object p : t.entrySet())
		{
			System.out.println(p);
		}
	}
}
