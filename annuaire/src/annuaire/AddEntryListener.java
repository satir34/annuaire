package annuaire;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

public class AddEntryListener implements ActionListener {
	
	private boolean cleAjoutee = false;
	private String s,s2;
	private Properties contacts;
	private String propertiesFielLocation = "myProperties.properties";
	
	public AddEntryListener()
	{
		this.contacts = Model.getContacts();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object[] options = {"OK", "Annuler"};
		
		if(!cleAjoutee)
		{
			s = (String)JOptionPane.showInputDialog(AddressBook.getFrame(), "Entrez le nom à ajouter", "Ajout d'une personne", JOptionPane.YES_NO_CANCEL_OPTION, null, null, null);
			cleAjoutee = true;
			actionPerformed(e);
		}
		else
		{
			s2 = (String)JOptionPane.showInputDialog(AddressBook.getFrame(), "Entrez les infos à ajouter", "Ajout d'une personne", JOptionPane.YES_NO_CANCEL_OPTION, null, null, null);
		}
		Set<String> setString = new HashSet<String>();
		setString.add(s);
		setString.add(s2);
		for(String a : setString)
		{
			contacts.setProperty(s, s2);
		}
		try (OutputStream out = new FileOutputStream(propertiesFielLocation))
		{
			contacts.store(out, "Fichier de propriétés");
		}
		catch(IOException e1) {
			e1.printStackTrace();
		}
	}
}
