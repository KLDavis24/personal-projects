package Threads;
import java.util.*;

// Runnable interface contains run() Method
public class threads implements Runnable {
	
	// Properties to be passed into the objects
	String name;
	int time;
	Random r = new Random();
	
	public threads (String x) {
		// Name of the thread to be passed in
		name = x;
		// Random time will be between 0 and 999 milliseconds
		time = r.nextInt(999);
	}
	
	// Whenever you start the thread, this is the code that will be running
	public void run() {
		try {
			// Print the time in milliseconds that the thread is sleeping
			System.out.printf("%s is sleeping for %d\n", name, time);
			// Put the thread to sleep for time(0-999 milliseconds)
			Thread.sleep(time);
			// Print when the threads wake up in order
			System.out.printf("%s is done\n", name);
		}
		catch (Exception e) {}
	}

}
