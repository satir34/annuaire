package annuaire;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

public class AddEntryListener implements ActionListener {
	
	private boolean cleAjoutee = false;
	private String newKey,newValue, newEntry;
	private Properties contacts;
	private String propertiesFielLocation = "myProperties.properties";
	private Model newModel;
	
	public AddEntryListener(Model currentListModel)
	{
		this.contacts = currentListModel.getContacts();
		this.newModel = currentListModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!cleAjoutee)
		{
			newKey = (String)JOptionPane.showInputDialog(AddressBook.getFrame(), "Entrez le nom à ajouter", "Ajout d'une personne", JOptionPane.YES_NO_CANCEL_OPTION, null, null, null);
			cleAjoutee = true;
			actionPerformed(e);
		}
		else
		{
			newValue = (String)JOptionPane.showInputDialog(AddressBook.getFrame(), "Entrez les infos à ajouter", "Ajout d'une personne", JOptionPane.YES_NO_CANCEL_OPTION, null, null, null);
		}
		// Utilisation d'un Set pour eviter les doublons
		Set<String> setString = new HashSet<String>();
		setString.add(newKey);
		setString.add(newValue);
		for(String a : setString)
		{
			contacts.setProperty(newKey, newValue);
		}
		try (OutputStream out = new FileOutputStream(propertiesFielLocation))
		{
			contacts.store(out, "Fichier de propriétés");
		}
		catch(IOException e1) {
			e1.printStackTrace();
		}
		newEntry = newKey;
		if(!newModel.contains(newEntry))
			newModel.addElement(newEntry);
	}
}
