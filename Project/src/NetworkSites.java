import java.net.*;
import java.util.*;
import java.awt.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.event.*;

public class NetworkSites extends JApplet {
	
	private HashMap<String, URL> websiteInfo;
	private ArrayList<String> titles;
	private JList mainList;
	
	// init Method
	public void init() {
		// Creating a blank HashMap and a blank ArrayList
		websiteInfo = new HashMap<String, URL>();
		titles = new ArrayList<String>();
		
		grabHTMLInfo();
		// Create the title, and define where you want it to display
		add(new JLabel("What website do you want to visit?"), BorderLayout.NORTH);
		// Add a list to the Applet
		mainList = new JList(titles.toArray());
		
		// Create the event listener to wait for the user to click a website
		mainList.addListSelectionListener(
				new ListSelectionListener() {
					// Add an event listener to the list that will sit and wait for something to happen
					public void valueChanged(ListSelectionEvent even) {
						// Create an object to get the title of the website
						Object object = mainList.getSelectedValue();
						// Create a variable to store the URL or the website
						URL newDocument = websiteInfo.get(object);
						// Get the browser that is being used
						AppletContext browser = getAppletContext();
						// Use the browser to navigate to the URL
						browser.showDocument(newDocument);
					}
				}
		);
		add(new JScrollPane(mainList), BorderLayout.CENTER);
	}
	
	// Create a Method to grab the HTML info
	private void grabHTMLInfo() {
		// Define the variables to store the values
		String title;
		String address;
		URL url;
		int counter = 0;
		
		// Setting the value of the first title to 0
		title = getParameter("title" + counter);
		
		while (title != null) {
			address = getParameter("address" + counter);
			try {
				// Convert the address String to a URL object for Java to read
				url = new URL(address);
				// Add a new item into the HashMap (title and URL)
				websiteInfo.put(title, url);
				// Add items to the 'titles' ArrayList
				titles.add(title);
			}
			catch(MalformedURLException urlException){
				urlException.printStackTrace();
			}
			
			counter++;
			title = getParameter("title" + counter);
		}
	}

}
