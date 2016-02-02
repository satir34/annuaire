package annuaire;

import java.util.Properties;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class TextFieldListener implements CaretListener {
	
	/**
	 * La liste des contacts
	 */
	private JList<String> list;
	/**
	 * Nouveau textPane qui contiendra le textPane courant
	 */
	private JTextPane textPane = new JTextPane();
	/**
	 * La liste courante des contacts dans le fichier properties
	 */
	private Properties contacts;
	
	/**
	 * Listener de l'event de changement du text dans le textPane
	 * @param list la liste de contenant les contacts
	 * @param textPane le textPane courant
	 * @param currentListModel la listModel courante
	 */
	public TextFieldListener(JList<String> list, JTextPane textPane, Model currentListModel)
	{
		this.list = list;
		this.textPane = textPane;
		this.contacts = currentListModel.getContacts();
	}

	/**
	 * Change le contenu de la liste dynamiquement
	 */
	public void caretUpdate(CaretEvent arg0) {
		String selectedKey = list.getSelectedValue();
		contacts.setProperty(selectedKey, textPane.getText());
	}
}
