/**
 * All imports needed
 */
package annuaire;

import java.awt.BorderLayout;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/**
 * @author ronsinl
 *
 */
public class AddressBook extends JFrame{

	private Properties contacts = new Properties();
	private JList list;
	private Model listModel;
	private static JFrame frame = new JFrame("Annuaire Telephonique");
	
	public AddressBook()
	{
		listModel = new Model();

		list = new JList(listModel);
		
		JTextPane textPane = new JTextPane();
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		SelectionListener hireListener = new SelectionListener(list, textPane, listModel);
		list.addListSelectionListener(hireListener);
		
		TextFieldListener changedTextListener = new TextFieldListener(list, textPane, listModel);
		textPane.addCaretListener(changedTextListener);
		
		JScrollPane scroll = new JScrollPane(list);
		
		panel.add(textPane, BorderLayout.SOUTH);
		panel.add(scroll);
		
		frame.getContentPane().add(panel);
		fenetre();
	}
	
	public void fenetre()
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Fichier");
		JMenu menuEdit = new JMenu("Edition");
		
		JMenuItem addEntry = new JMenuItem("Ajouter une entrée");
		
		AddEntryListener addNewGuy = new AddEntryListener(listModel);
		addEntry.addActionListener(addNewGuy);
		
		menuEdit.add(addEntry);
		menuBar.add(menu);
		menuBar.add(menuEdit);
		
		frame.setJMenuBar(menuBar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	public static JFrame getFrame() {
		return frame;
	}

	
	public static void main(String[] args) {
		AddressBook a = new AddressBook();
	}
}
