package annuaire;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

public class AddEntryListener implements ActionListener {
	
	private boolean cleAjoutee = false;
	private String s,s2;
	
	public AddEntryListener()
	{
		
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
		
	}
}
