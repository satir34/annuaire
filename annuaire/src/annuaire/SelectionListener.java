package annuaire;
import java.util.Properties;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelectionListener implements ListSelectionListener {
	
	private JList<String> list;
	private JTextPane textPane = new JTextPane();
	private Properties contacts;
	
	public SelectionListener(JList<String> list, JTextPane textPane, Model currentListModel)
	{
		this.list = list;
		this.textPane = textPane;
		this.contacts = currentListModel.getContacts();
	}
	
	public void valueChanged(ListSelectionEvent e) {
		String selectedKey = this.list.getSelectedValue();
		textPane.setText(contacts.getProperty(selectedKey));
	}
}
