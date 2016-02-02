/**
 * All imports needed
 */
package annuaire;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

	/**
	 * Contient la liste des contacts via le fichier properties 
	 */
	private Properties contacts = new Properties();
	/**
	 * La JList qui sert à afficher les contacts
	 */
	private JList list;
	/**
	 * ListModel qui sert à la structure MVC pour l'affichage dynamique des contacts
	 */
	private Model listModel;
	/**
	 * La frame qui contiendra les contacts
	 */
	private static JFrame frame = new JFrame("Annuaire Telephonique");
	
	/**
	 * Construit la vue par défaut
	 */
	public AddressBook()
	{
		// Creation du list model
		listModel = new Model();
		list = new JList(listModel);
		
		JTextPane textPane = new JTextPane();
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		// Ajout des events sur la listModel et le textField
		SelectionListener hireListener = new SelectionListener(list, textPane, listModel);
		list.addListSelectionListener(hireListener);
		TextFieldListener changedTextListener = new TextFieldListener(list, textPane, listModel);
		textPane.addCaretListener(changedTextListener);
		
		// Creation et ajout du scrollPane au panel
		JScrollPane scroll = new JScrollPane(list);
		panel.add(textPane, BorderLayout.SOUTH);
		panel.add(scroll);
		
		// Ajout du panel à la frame
		frame.getContentPane().add(panel);
		fenetre();
	}
	
	/**
	 * creation de la fenetre, Taille, fermeture, menus
	 */
	public void fenetre()
	{
		// Creation des menus principaux
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFiles = new JMenu("Fichier");
		JMenu menuEdit = new JMenu("Edition");
		
		// Creation des sous-menus
		JMenuItem addEntry = new JMenuItem("Ajouter une entrée");
		JMenuItem saveFile = new JMenuItem("Sauvegarder");
		
		// Ajout des events sur les sous-menus
		AddEntryListener addNewGuy = new AddEntryListener(listModel);
		addEntry.addActionListener(addNewGuy);
		SaveChanges saveNewChanges = new SaveChanges(listModel);
		saveFile.addActionListener(saveNewChanges);
		
		// Ajout des sous-menus
		menuEdit.add(addEntry);
		menuFiles.add(saveFile);
		
		// Ajout des menus principaux
		menuBar.add(menuFiles);
		menuBar.add(menuEdit);
		
		// Paramètrage de la frame
		frame.setJMenuBar(menuBar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	/**
	 * Getter de la frame
	 * @return la frame courante
	 */
	public static JFrame getFrame() {
		return frame;
	}
    
	/**
	 * Debut du programme
	 * @param args
	 */
	public static void main(String[] args) {
		AddressBook a = new AddressBook();
	}
}
