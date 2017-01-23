package ReadFile;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ReadFile extends JFrame{
	
	// Create the address bar and the editor pane for the GUI
	private JTextField addressBar;
	private JEditorPane display;
	
	// Create the constructor
	public ReadFile() {
		// Name the application
		super("New Browser");
		
		// Display a JTextField message to the user
		addressBar = new JTextField("Enter a URL");
		addressBar.addActionListener(
				new ActionListener() {
					// Take in the event of the user hitting the Enter button
					public void actionPerformed(ActionEvent event) {
						// When Enter is hit, take the String inside 'addressBar' and pass it to 'loadStuff'
						loadStuff(event.getActionCommand());
					}
				}
		);
		// Display the addressBar at the top of the screen
		add(addressBar, BorderLayout.NORTH);
		
		display = new JEditorPane();
		display.setEditable(false);
		// Create a listener to sit on the links, then pass the clicked link into 'loadStuff'
		display.addHyperlinkListener(
				new HyperlinkListener() {
					// Method called whenever a hyperlink event happens
					public void hyperlinkUpdate(HyperlinkEvent event) {
						// If the user clicked the link (activated)
						if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
							// Use 'loadStuff' to get the URL object and convert it to String
							loadStuff(event.getURL().toString());
						}
					}
				}
		);
		add(new JScrollPane(display), BorderLayout.CENTER);
		setSize(500, 300);
		setVisible(true);
	}
	
	// Create the loadStuff Method to display on the screen
	private void loadStuff(String userText) {
		try {
			// Take in 'userText' entered by the user and use it as a URL
			display.setPage(userText);
			addressBar.setText(userText);
		}
		catch (Exception e) {
			// Display an error if the user enters an improper URL
			System.out.println("Error! Improper URL!");
		}
	}

}
