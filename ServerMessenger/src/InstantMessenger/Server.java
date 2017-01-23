package InstantMessenger;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Server extends JFrame {
	
	private JTextField userText;       // Area to type the message before it is sent
	private JTextArea chatWindow;      // Area that displays the messages
	private ObjectOutputStream output; // Stream to handle outgoing messages
	private ObjectInputStream input;   // Stream to handle incoming messages
	private ServerSocket server;       // Server to handle the chat windows
	private Socket connection;         // Socket to connect the two computers
	
	// Constructor for the GUI
	public Server() {
		super("Instant Messenger");
		userText = new JTextField(); // Creating the text box for the chat
		userText.setEditable(false); // Before you're connected, typing in the messege box is impossible
		userText.addActionListener(
				new ActionListener() {
					// Action to be called when the user hits enter to send the message
					public void actionPerformed(ActionEvent event) {
						sendMessage(event.getActionCommand());
						userText.setText(""); // Set the default message box to be blank
					}
				}
		);
		add(userText, BorderLayout.SOUTH); // Place the chatbox on the bottom of the screen
		chatWindow = new JTextArea(); // Create a new chat window to display sent messages
		add(new JScrollPane(chatWindow));
		setSize(500, 350);
		setVisible(true);
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------
	
	// Setup and run the server
	public void startRunning() {
		try {
			// Create a socket that tries to connect with parameters: (port #, backlog)
			server = new ServerSocket(6789, 100);
			while (true) {
				try {
					// Try to connect and have a conversation
					waitForConnection();
					setupStreams();
					whileChatting();
				}
				catch (EOFException eofException) {
					// Whenever the server or the user stops the connection, show error message
					showMessage("\n Server ended the connection!");
				}
				finally {
					closeWindow();
				}
			}
		}
		catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
	
	// Method to wait for connection, then display connection info
	private void waitForConnection() throws IOException {
		showMessage(" Waiting for someone to connect... \n");
		connection = server.accept(); // Once you have a connection, a socket is connected between both users
		showMessage(" Now connected to " + connection.getInetAddress().getHostName());
	}
	
	// Get Stream to send and receive data
	private void setupStreams() throws IOException {
		// Creating the pathway to send to another computer
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush(); // Send excess bytes of info to the other user
		// Creating the pathway to receive from another user
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("\n Streams are now setup! \n");
	}
	
	// During the chat conversation
	private void whileChatting() throws IOException {
		String message = " You are now connected! ";
		sendMessage(message);
		ableToType(true);
		do {
			// Have a conversation until the user types 'END'
			try {
				// Read the message that the other user sends, and store it in 'message'
				message = (String) input.readObject();
				showMessage("\n" + message);
			}
			catch (ClassNotFoundException classNotFoundException) {
				// If the user sends some weird non-string message
				showMessage("\n I don't know what that user sent! ");
			}
		}
		while (!message.equals("CLIENT - END"));
	}
	
	// Close Streams and Sockets after you are done chatting
	private void closeWindow() {
		showMessage("\n Closing connections... \n");
		ableToType(false);
		try {
			output.close();
			input.close();
			connection.close();
		}
		catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
	
	// Send a message to the client
	private void sendMessage(String message) {
		try {
			output.writeObject("SERVER - " + message);
			output.flush();
			showMessage("\n SERVER - " + message);
		}
		catch (IOException ioException) {
			chatWindow.append("\n ERROR: THAT MESSAGE CANNOT BE SENT!");
		}
	}
	
	// Updates chatWindow with new messages
	private void showMessage(final String text){
		// Set aside a thread to update the GUI
		SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						chatWindow.append(text); // Puts every new message into the chat window
					}
				}
		);
	}
	
	// Let the user type a message into the chat box
	private void ableToType(final boolean tOrF) {
		SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						// Sets the chatbox to editable true or false based on what is passed in
						userText.setEditable(tOrF);
					}
				}
		);
	}
}
