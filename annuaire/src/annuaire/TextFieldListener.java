package annuaire;

import java.util.Properties;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class TextFieldListener implements CaretListener {
	
	private JList<String> list;
	private JTextPane textPane = new JTextPane();
	private Properties contacts;
	
	public TextFieldListener(JList<String> list, JTextPane textPane, Model currentListModel)
	{
		this.list = list;
		this.textPane = textPane;
		this.contacts = currentListModel.getContacts();
	}

	public void caretUpdate(CaretEvent arg0) {
		String selectedKey = list.getSelectedValue();
		contacts.setProperty(selectedKey, textPane.getText());
	}
}
