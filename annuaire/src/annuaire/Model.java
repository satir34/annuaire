package annuaire;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;

public class Model extends DefaultListModel {
	/**
	 * Contient la liste des contacts du fichier properties
	 */
	private Properties contacts = new Properties();
	
	/**
	 * Lit le fichier properties et stock les informations dans contacts
	 */
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
			this.addElement((String) o.getKey());
		}
	}
	
	/**
	 * Getter de la liste des contacts
	 * @return la liste des contacts dans le fichier properties
	 */
	public Properties getContacts()
	{
		return contacts;
	}
}
