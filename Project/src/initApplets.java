import java.awt.*;
import javax.swing.*;

public class initApplets extends JApplet {
	
	private double sum;
	
	// Overriding the initialization method
	public void init() {
		String firstNumber = JOptionPane.showInputDialog("Enter First Number: ");
		String secondNumber = JOptionPane.showInputDialog("Enter Second Number: ");
		
		// Converting the Strings to Doubles for adding
		double number1 = Double.parseDouble(firstNumber);
		double number2 = Double.parseDouble(secondNumber);
		
		sum = (number1 + number2);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawString("The sum is: "+sum, 25, 30);
	}

}
