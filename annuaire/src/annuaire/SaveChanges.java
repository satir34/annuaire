package annuaire;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class SaveChanges implements ActionListener {

	/**
	 * La liste des contacts courante en properties
	 */
	private Properties contacts;
	/**
	 * La localisation du fichier properties
	 */
	private String propertiesFielLocation = "myProperties.properties";
	
	/**
	 * Recupération de la listModel courante
	 * @param currentListModel la listModel courante
	 */
	public SaveChanges(Model currentListModel)
	{
		this.contacts = currentListModel.getContacts();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try(OutputStream out = new FileOutputStream(propertiesFielLocation))
		{
			contacts.store(out, "Sauvegarde du fichier");
		} catch (IOException e)	{
			e.printStackTrace();
		}
	}

}
