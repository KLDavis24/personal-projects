package CircleDraw;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

// The panel in ovalSlider goes into the Frame
public class theWindow extends JFrame {
	
	// Create the slider
	private JSlider slider;
	// Create the panel to sit inside the frame
	private ovalSlider myPanel;
	
	public theWindow() {
		// Put a new title on the window
		super("The Title");
		// Create a panel object from the ovalSlider class
		myPanel = new ovalSlider();
		myPanel.setBackground(Color.ORANGE);
		
		// Create a new slider and call some methods on it
		// New slider arguments: (vertical or horizontal, minimum value, maximum value, initial value)
		slider = new JSlider(SwingConstants.HORIZONTAL, 0, 200, 10);
		// Set a new tick mark every 10px
		slider.setMajorTickSpacing(10);
		// Paints the ticks on the screen
		slider.setPaintTicks(true);
		
		// Change the diameter of the circle
		slider.addChangeListener(
				new ChangeListener() {
					// Every time something is changed, this runs
					public void stateChanged(ChangeEvent e) {
						myPanel.setD(slider.getValue());
					}
				}
		);
		
		add(slider, BorderLayout.SOUTH);
		add(myPanel, BorderLayout.CENTER);
	}
}
