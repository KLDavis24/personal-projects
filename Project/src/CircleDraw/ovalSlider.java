package CircleDraw;
import java.awt.*;
import javax.swing.*;

public class ovalSlider extends JPanel {
	
	// Creating a diameter to be passed in by default
	private int d = 10;
	
	// Create a way to paint the circle on the screen
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillOval(10, 10, d, d);
	}
	
	public void setD(int newD) {
		// If the value passed in is greater than 0, use that value
		// Else, use 10 as the value
		d = (newD >= 0 ? newD : 10);
		
		// Automatically calls the paintComponent method from the same Class
		repaint();
	}
	
	// Layout manager gets the preferred size
	public Dimension getPreferredSize() {
		return new Dimension(200, 200);
	}
	
	// Layout manager determines the minimum size
	public Dimension getMinimumSize() {
		return getPreferredSize();
	}
}
