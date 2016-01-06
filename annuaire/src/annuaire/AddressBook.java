/**
 * 
 */
package annuaire;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;
import java.util.Properties;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author ronsinl
 *
 */
public class AddressBook extends JFrame{

	private Properties contacts = new Properties();
	
	public AddressBook()
	{
		initListeContacts();
		initWindow();
	}
	
	public void initListeContacts()
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
	}
	
	public void initWindow()
	{		
		JFrame frame = new JFrame();
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
	
		for(Entry<Object, Object> o : contacts.entrySet())
		{
			listModel.addElement(o.getKey()+" = "+o.getValue());
		}

		JList<String> list = new JList<String>(listModel);
		
		JTextPane textPane = new JTextPane();
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				String selectedValue = list.getSelectedValue();
				if(!selectedValue.isEmpty()) {
					textPane.setText(selectedValue);
				}
			}
		});
		
		textPane.addCaretListener(new CaretListener() {
			
			@Override
			public void caretUpdate(CaretEvent arg0) {
				listModel.remove(list.getSelectedIndex());
				listModel.addElement(textPane.getText());
					
			}
		});
		
		JScrollPane scroll = new JScrollPane(list);
		scroll.setSize(frame.getWidth(),200);
		
		panel.add(textPane, BorderLayout.SOUTH);
		panel.add(scroll);
		
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Le meilleur prog de France");
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	public void addRow(String key, String value)
	{
		contacts.setProperty(key, value);
	}
	
	public void deleteRow(String key)
	{
		if(contacts.containsKey(key)) 
		{
			contacts.remove(key);
		}
	}
	
	public void changeRow(String key, String value)
	{
		if(contacts.containsKey(key))
		{
			contacts.replace(key, value);
		}
	}
	
	public void afficherProperties()
	{
		for(Entry<Object, Object> o : contacts.entrySet())
		{
			System.out.println(o.getKey()+"="+o.getValue());
		}
	}
	
	public static void main(String[] args) {
		AddressBook a = new AddressBook();
		//a.addRow("nom5", "2");
		//a.deleteRow("nom2");
		//a.changeRow("nom", "02 0000 0000");
		
		//a.afficherProperties();
	}

}
