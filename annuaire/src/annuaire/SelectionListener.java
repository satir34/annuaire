package annuaire;
import java.util.Properties;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelectionListener implements ListSelectionListener {
	
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
	 * Listener de l'event de selection d'un element du scrollPane
	 * @param list la liste de contenant les contacts
	 * @param textPane le textPane courant
	 * @param currentListModel la listModel courante
	 */
	public SelectionListener(JList<String> list, JTextPane textPane, Model currentListModel)
	{
		this.list = list;
		this.textPane = textPane;
		this.contacts = currentListModel.getContacts();
	}
	
	/**
	 * Changera le contenu du textPane selon l'element cliqué
	 */
	public void valueChanged(ListSelectionEvent e) {
		String selectedKey = this.list.getSelectedValue();
		textPane.setText(contacts.getProperty(selectedKey));
	}
}
