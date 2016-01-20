package annuaire;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;

public class Model extends DefaultListModel {
	private static Properties contacts = new Properties();
	
	public Model()
	{
		String propertiesFileLocation = "myProperties.properties";
		InputStream in = null;
		
		try {
			in = new FileInputStream(propertiesFileLocation);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			contacts.load(in);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		for(Entry<Object, Object> o : contacts.entrySet())
		{
			addElement((String) o.getKey());
		}
	}
	
	public static Properties getContacts()
	{
		return contacts;
	}
}
