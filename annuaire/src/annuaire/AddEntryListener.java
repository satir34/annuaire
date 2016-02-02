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
	/**
	 * Booleen qui verifira que le nom du contact est déjà ajouter lors de l'event
	 */
	private boolean cleAjoutee = false;
	/**
	 * La nouvelle clé à ajouter au fichier properties
	 */
	private String newKey;
	/** 
	 * La nouvelle valeur associé à la clé newKey à ajouter au fichier properties
	 */
	private String newValue;
	/**
	 * La liste des contacts courante en properties
	 */
	private Properties contacts;
	/**
	 * La localisation du fichier properties
	 */
	private String propertiesFielLocation = "myProperties.properties";
	/**
	 * listModel pour la structure MVC
	 */
	private Model newModel;
	
	/**
	 * Listener de l'event sur le menu d'ajout d'une entrée au fichier properties
	 * @param currentListModel la listModel à modifier
	 */
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
		if(!newModel.contains(newKey))
			newModel.addElement(newKey);
	}
}
